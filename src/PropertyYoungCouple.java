import java.util.ArrayList;

/**
 * Created by Nir on 11/01/2019.
 */
public class PropertyYoungCouple extends IPropertyUnit {
    // LB = left bottom
    Point grainLB;

    PropertyYoungCouple(int id){
        this.id = id;
        minDistLeft = FiveCmConverter.convert(375);
        minDistUp = FiveCmConverter.convert(1030);
        minDistDown = FiveCmConverter.convert(330);
        minDistRight = FiveCmConverter.convert(1115);
    }

    @Override
    public ArrayList<Point> getShapeFromPoint(Point point) {
        ArrayList<Point> res = new ArrayList<>();
        point.moveCurrentPosition(FiveCmConverter.convert(375), 0, 0, FiveCmConverter.convert(330));
        FillArea(point, res, 330, 1175);
        point.moveCurrentPosition(0, 0, FiveCmConverter.convert(330), 0);
        FillArea(point, res, 900, 1415);
        point.moveCurrentPosition(0, FiveCmConverter.convert(375), FiveCmConverter.convert(900), 0);
        FillArea(point, res, 130, 1040);
        return res;
    }

    private void FillArea(Point point, ArrayList<Point> res, int height, int width) {
        for(int line = point.x; line > point.x - FiveCmConverter.convert(height); line--){
            for(int col = point.y; col < point.y + FiveCmConverter.convert(width); col++){
                res.add(new Point(line, col ));
            }
        }
    }

    @Override
    public IPropertyUnit rotate() {
        return null;
    }

    @Override
    public ArrayList<IPropertyUnit> getRotates() {
        ArrayList<IPropertyUnit> res = new ArrayList<>();
        res.add(this);
        return res;
    }

    @Override
    public Point getFirstLocation() {
        return new Point(minDistUp, minDistLeft);
    }

    @Override
    public int getWidth() {
        return FiveCmConverter.convert(1415);
    }

    @Override
    public int getHeight() {
        return FiveCmConverter.convert(1480);
    }
}
