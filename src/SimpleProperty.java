/*
import java.util.ArrayList;

public class SimpleProperty extends IPropertyUnit {
    private int len = 2;
    private int width = 3;

    public SimpleProperty(int id){
        this.radius = 3;
        this.id = id;
    }

    public SimpleProperty(SimpleProperty simpleProperty) {
        super();
        this.len = simpleProperty.len;
        this.width = simpleProperty.width;
    }

    @Override
    public ArrayList<Point> getAllLegalPositions(int[][] map) {
        return null;
    }

    @Override
    public ArrayList<Point> getShapeFromPoint(Point point) {
        ArrayList<Point> res = new ArrayList<>();
        for(int i = 0; i < this.len ; i++){
            for(int j = 0; j < this.width ; j++) {
                res.add(new Point(point.x + i, point.y + j));
            }
        }
        return res;
    }

    @Override
    public IPropertyUnit rotate() {
        SimpleProperty res = new SimpleProperty(this.id);
        res.len = this.width;
        res.width = this.len;
        return res;
    }

    @Override
    public boolean isLegalLocation(Point point, int[][] map) {
        for(int i = Integer.max(0, point.x - radius); i < point.x + width + radius; i++){
            for(int j = Integer.max(0, point.y - radius); j < point.y + len+ radius; j++){
                try {
                    if (map[i][j] != 0)
                        return false;
                } catch (ArrayIndexOutOfBoundsException e){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ArrayList<IPropertyUnit> getRotates() {
        ArrayList<IPropertyUnit> res = new ArrayList<>();
        res.add(this);
        res.add(this.rotate());
        return res;
    }
}
*/
