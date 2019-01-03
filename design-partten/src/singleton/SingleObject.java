package singleton;

/**
 * @author zhenlei
 */
public class SingleObject {
    private static SingleObject instance;

    private SingleObject() {
        instance = new SingleObject();
    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("show message");
    }

}
