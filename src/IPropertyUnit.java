import java.util.ArrayList;

public abstract class IPropertyUnit {
    int id;

    public int minDistLeft;
    public int minDistUp;
    public int minDistDown;
    public int minDistRight;

    // LB = left bottom
    Point grainLB;

    abstract public ArrayList<Point> getShapeFromPoint(Point point);

    public abstract IPropertyUnit rotate();

    public IPropertyUnit rotate90Right(int num) {
        int old_r = minDistRight;
        int old_l = minDistLeft;
        int old_u = minDistUp;
        int old_d = minDistDown;
        minDistRight = old_u;
        minDistDown = old_r;
        minDistLeft = old_d;
        minDistUp = old_l;



        return null;
    }

    abstract public ArrayList<IPropertyUnit> getRotates();


    public Point getFirstLocation() {
        return new Point(minDistUp, minDistLeft);
    }

    public int getWidth() { return minDistLeft + minDistRight;}

    public int getHeight() { return minDistUp + minDistDown;}

    public void FillArea(Point point, ArrayList<Point> res, int height, int width) {
        for(int line = point.x; line > point.x - FiveCmConverter.convert(height); line--){
            for(int col = point.y; col < point.y + FiveCmConverter.convert(width); col++){
                res.add(new Point(line, col ));
            }
        }
    }

    /*
    public void FillArea(Point point, ArrayList<Point> res, int height, int width) {
        for(int line = point.x; line > point.x - FiveCmConverter.convert(height); line--){
            for(int col = point.y; col < point.y + FiveCmConverter.convert(width); col++){
                res.add(new Point(line, col ));
            }
        }
    }
    */
}
