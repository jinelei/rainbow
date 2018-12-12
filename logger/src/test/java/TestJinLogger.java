import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import rainbow.logger.JinLogger;

public class TestJinLogger {
    @Before
    public void testBefore() {
        System.out.println("before");
    }

    @Test
    public void test() {
        JinLogger.getLogger(TestJinLogger.class).error("test logger");
        System.out.println("test finish");
    }

    @After
    public void testAfter() {
        System.out.println("after");
    }
}
