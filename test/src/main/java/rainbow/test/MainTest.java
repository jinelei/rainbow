package rainbow.test;

import org.slf4j.LoggerFactory;
import rainbow.helloworld.HelloWorld;

import java.nio.channels.Pipe;

/**
 * @author zhenlei
 */
public class MainTest {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.hello("jinelei"));
    }
}
