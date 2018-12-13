package rainbow.client.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import rainbow.client.ReconnectClient;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @author zhenlei
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        final EventLoop loop = ctx.channel().eventLoop();
        loop.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("run");
                    new ReconnectClient().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1L, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent && ((IdleStateEvent) evt).state().equals(IdleState.ALL_IDLE)) {
            reconnenct(ctx);
        }
    }

    public void reconnenct(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer(new byte[]{'\0'}));
    }
}
