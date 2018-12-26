package abstractfactory;

/**
 * @author zhenlei
 */
public class FactoryProducer {
    public static final String COLOR = "COLOR";
    public static final String SHAPE = "SHAPE";

    public static AbstractFactory getFactory(String choice) {
        if (COLOR.equalsIgnoreCase(choice)) {
            return new ColorFactory();
        } else if (SHAPE.equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        } else {
            return null;
        }
    }
}
