package rainbow.client.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

import java.time.Instant;

/**
 * @author zhenlei
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

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
