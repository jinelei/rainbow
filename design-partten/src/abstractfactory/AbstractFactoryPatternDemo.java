package abstractfactory;

/**
 * @author zhenlei
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        int upLimit = 10;
        for (int i = 0; i < upLimit; i++) {
            FactoryProducer.getFactory("color").getColor().fill();
        }
        upLimit = 10;
        for (int i = 0; i < upLimit; i++) {
            FactoryProducer.getFactory("shape").getShape().draw();
        }
    }
}
