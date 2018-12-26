package abstractfactory;

import java.util.Random;

/**
 * @author zhenlei
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor() {
        switch (new Random().nextInt(3)) {
            case 0:
                return new Red();
            case 1:
                return new Green();
            case 2:
            default:
                return new Blue();
        }
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
