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
    private String host;
    private Bootstrap bootstrap;
    private EventLoopGroup group;
    private static Channel channel;

    public ReconnectClient() {
        this.port = 9000;
        this.host = "127.0.0.1";
    }

    public ReconnectClient(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public void run() throws InterruptedException {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
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
        ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
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
        new ReconnectClient().run();
    }
}
