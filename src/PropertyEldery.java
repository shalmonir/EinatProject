import java.util.ArrayList;

/**
 * Created by Nir on 12/01/2019.
 */
public class PropertyEldery extends IPropertyUnit {
    PropertyEldery(int id) {
        this.id = id;
        minDistLeft = FiveCmConverter.convert(300);
        minDistUp = FiveCmConverter.convert(1060);
        minDistDown = FiveCmConverter.convert(500);
        minDistRight = FiveCmConverter.convert(1190);
    }

    public PropertyEldery(PropertyEldery propertyEldery) {
        this.id = propertyEldery.id;
        minDistLeft = propertyEldery.minDistLeft;
        minDistUp = propertyEldery.minDistUp;
        minDistDown = propertyEldery.minDistDown;
        minDistRight = propertyEldery. minDistRight;
    }

    @Override
    public ArrayList<Point> getShapeFromPoint(Point point) {
        grainLB = point;
        ArrayList<Point> res = new ArrayList<>();
        point.moveCurrentPosition(FiveCmConverter.convert(5), 0, 0, FiveCmConverter.convert(500));
        FillArea(point, res, 200, 1195);
        point.moveCurrentPosition(FiveCmConverter.convert(295), 0, FiveCmConverter.convert(200), 0);
        FillArea(point, res, 930, 1490);
        point.moveCurrentPosition(0, 0, FiveCmConverter.convert(930), 0);
        FillArea(point, res, 300, 1415);
        point.moveCurrentPosition(0, FiveCmConverter.convert(375), FiveCmConverter.convert(300), 0);
        FillArea(point, res, 130, 1040);
        return res;
    }

    @Override
    public IPropertyUnit rotate() {
        return new PropertyEldery(this);
    }

    @Override
    public ArrayList<IPropertyUnit> getRotates() {
        ArrayList<IPropertyUnit> res = new ArrayList<>();
        res.add(new PropertyEldery(this));
        return res;
    }
}
