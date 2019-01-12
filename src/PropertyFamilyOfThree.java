import java.util.ArrayList;

/**
 * Created by Nir on 12/01/2019.
 */
public class PropertyFamilyOfThree extends IPropertyUnit {
    PropertyFamilyOfThree(int id) {
        this.id = id;
        minDistUp = FiveCmConverter.convert(1180);
        minDistDown = FiveCmConverter.convert(300);
        minDistLeft = FiveCmConverter.convert(340);
        minDistRight = FiveCmConverter.convert(1115);
    }

    public PropertyFamilyOfThree(PropertyFamilyOfThree propertyFamilyOfThree) {
        this.id = propertyFamilyOfThree.id;
        minDistLeft = propertyFamilyOfThree.minDistLeft;
        minDistUp = propertyFamilyOfThree.minDistUp;
        minDistDown = propertyFamilyOfThree.minDistDown;
        minDistRight = propertyFamilyOfThree. minDistRight;
    }

    @Override
    public ArrayList<Point> getShapeFromPoint(Point point) {
        grainLB = point;
        ArrayList<Point> res = new ArrayList<>();
        point.moveCurrentPositionWith5CmConvert(300, 0, 0, 300);
        FillArea(point, res, 230, 1175);
        point.moveCurrentPositionWith5CmConvert(0, 0, 230, 0);
        FillArea(point, res, 100, 1325);
        point.moveCurrentPositionWith5CmConvert(40, 0, 100,0);
        FillArea(point, res, 1030, 1455);
        point.moveCurrentPositionWith5CmConvert(0, 0, 1030,0);
        FillArea(point, res, 120, 1015);
        return res;
    }

    @Override
    public IPropertyUnit rotate() {
        return new PropertyFamilyOfThree(this);
    }

    @Override
    public ArrayList<IPropertyUnit> getRotates() {
        ArrayList<IPropertyUnit> res = new ArrayList<>();
        res.add(new PropertyFamilyOfThree(this));
        return res;
    }
}
