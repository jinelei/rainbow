package rainbow.test;

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
