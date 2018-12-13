package rainbow.server.handler;

import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author zhenlei
 */
public class TimeoutHandler extends IdleStateHandler {
    public TimeoutHandler(int readerIdleTimeSeconds, int writerIdleTimeSeconds, int allIdleTimeSeconds) {
        super(readerIdleTimeSeconds, writerIdleTimeSeconds, allIdleTimeSeconds);
    }
}
