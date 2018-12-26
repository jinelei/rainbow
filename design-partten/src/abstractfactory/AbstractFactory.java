package abstractfactory;

/**
 * @author zhenlei
 */
public abstract class AbstractFactory {
    /**
     * 获取Color
     *
     * @return Color
     */
    public abstract Color getColor();

    /**
     * 获取Shape
     *
     * @return Shape
     */
    public abstract Shape getShape();
}
