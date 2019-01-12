import java.util.ArrayList;

/**
 * Created by Nir on 12/01/2019.
 */
public class PropertyFamilyOfFive extends IPropertyUnit {
    PropertyFamilyOfFive(int id) {
        this.id = id;
        minDistLeft = FiveCmConverter.convert(435);
        minDistUp = FiveCmConverter.convert(1180);
        minDistDown = FiveCmConverter.convert(500);
        minDistRight = FiveCmConverter.convert(1260);
    }

    public PropertyFamilyOfFive(PropertyFamilyOfFive propertyFamilyOfFive) {
        this.id = propertyFamilyOfFive.id;
        minDistLeft = propertyFamilyOfFive.minDistLeft;
        minDistUp = propertyFamilyOfFive.minDistUp;
        minDistDown = propertyFamilyOfFive.minDistDown;
        minDistRight = propertyFamilyOfFive. minDistRight;
    }

    @Override
    public ArrayList<Point> getShapeFromPoint(Point point) {
        grainLB = point;
        ArrayList<Point> res = new ArrayList<>();
        point.moveCurrentPosition(FiveCmConverter.convert(5), 0, 0, FiveCmConverter.convert(500));
        FillArea(point, res, 200, 1260);
        point.moveCurrentPosition(FiveCmConverter.convert(295), 0, FiveCmConverter.convert(200), 0);
        FillArea(point, res, 330, 1555);
        point.moveCurrentPosition(FiveCmConverter.convert(125), 0, FiveCmConverter.convert(330), 0);
        FillArea(point, res, 1030, 1680);
        point.moveCurrentPosition(0, 0, FiveCmConverter.convert(1030), 0);
        FillArea(point, res, 120, 1100);
        return res;
    }

    @Override
    public IPropertyUnit rotate() {
        return new PropertyFamilyOfFive(this);
    }

    @Override
    public ArrayList<IPropertyUnit> getRotates() {
        ArrayList<IPropertyUnit> res = new ArrayList<>();
        res.add(new PropertyFamilyOfFive(this));
        return res;
    }

    /*@Override
    public int getWidth() {
        return FiveCmConverter.convert(1680);
    }

    @Override
    public int getHeight() {
        return FiveCmConverter.convert(1680);
    }*/
}
