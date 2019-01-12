import java.util.ArrayList;

public abstract class IPropertyUnit {
    Point pointOfReferance;
    int radius;
    int id;

    public int minDistLeft;
    public int minDistUp;
    public int minDistDown;
    public int minDistRight;

    abstract public ArrayList<Point> getShapeFromPoint(Point point);

    public abstract IPropertyUnit rotate();

    abstract public ArrayList<IPropertyUnit> getRotates();

    abstract public Point getFirstLocation();

    abstract public int getWidth();

    public abstract int getHeight();
}
