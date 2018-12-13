package rainbow.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import rainbow.client.handler.HeartBeatHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author zhenlei
 */
public class ReconnectClient {
    private int port;
    private Bootstrap bootstrap = new Bootstrap();
    private EventLoopGroup group = new NioEventLoopGroup();
    private static Channel channel;


    public ReconnectClient(int port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
        bootstrap.group(group)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast("idleStateHandler", new IdleStateHandler(0, 0, 5, TimeUnit.SECONDS))
                                .addLast("timeoutClentHandler", new HeartBeatHandler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", port).sync();
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture futureListener) throws Exception {
                if (futureListener.isSuccess()) {
                    channel = futureListener.channel();
                    System.out.println("连接成功");
                } else {
                    System.out.println("连接失败");
                }
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 9000;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        ReconnectClient client = new ReconnectClient(port);
        client.run();
    }
}
