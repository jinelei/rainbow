package abstractfactory;

/**
 * @author zhenlei
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        int upLimit = 10;
        for (int i = 0; i < upLimit; i++) {
            ShapeFactory.getShape().draw();
        }
    }
}
