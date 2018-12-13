package rainbow.client.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

import java.time.Instant;

/**
 * @author zhenlei
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            switch (event.state()) {
                case READER_IDLE:
                    break;
                case WRITER_IDLE:
                    break;
                case ALL_IDLE:
                    reconnenct(ctx);
                    break;
                default:
                    break;
            }
        }
    }

    public void reconnenct(ChannelHandlerContext ctx) {
        System.out.println("reconnect");
        ctx.writeAndFlush(Unpooled.copiedBuffer("reconnect\n", CharsetUtil.UTF_8));
    }
}
