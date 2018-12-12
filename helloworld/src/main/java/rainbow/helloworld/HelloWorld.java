package rainbow.helloworld;

import rainbow.logger.JinLogger;

/**
 * @author zhenlei
 */
public class HelloWorld {
    public String hello(String name) {
        JinLogger.getLogger(HelloWorld.class).info("hello " + name);
        return "hello " + name;
    }
}
