package abstractfactory;

import java.util.Random;

/**
 * @author zhenlei
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Shape getShape() {
        switch (new Random().nextInt(3)) {
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Rectangle();
            default:
                return new Rectangle();

        }
    }
}
