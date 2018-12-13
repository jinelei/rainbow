package rainbow.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

import java.time.Clock;
import java.time.Instant;

/**
 * @author zhenlei
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    private StringBuffer sb = new StringBuffer();

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        ByteBuf in = ((ByteBuf) msg).copy();
        try {
            sb.setLength(0);
            while (in.isReadable()) {
                char c = (char) in.readByte();
                sb.append(c);
            }
            System.out.print(sb.toString());
        } finally {
            ctx.writeAndFlush(msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            switch (event.state()) {
                case READER_IDLE:
                    System.out.println("read idle " + Instant.now().toString());
                    break;
                case WRITER_IDLE:
                    System.out.println("write idle " + Instant.now().toString());
                    break;
                case ALL_IDLE:
                    System.out.println("all idle " + Instant.now().toString());
                    ctx.close();
                    break;
                default:
                    break;
            }
        }
    }
}
