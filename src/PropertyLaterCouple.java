import java.util.ArrayList;

/**
 * Created by Nir on 12/01/2019.
 */
public class PropertyLaterCouple extends IPropertyUnit {
    PropertyLaterCouple(int id) {
        this.id = id;
        minDistUp = FiveCmConverter.convert(1150);
        minDistDown = FiveCmConverter.convert(530);
        minDistLeft = FiveCmConverter.convert(420);
        minDistRight = FiveCmConverter.convert(1260);
    }

    public PropertyLaterCouple(PropertyLaterCouple propertyLaterCouple) {
        this.id = propertyLaterCouple.id;
        minDistLeft = propertyLaterCouple.minDistLeft;
        minDistUp = propertyLaterCouple.minDistUp;
        minDistDown = propertyLaterCouple.minDistDown;
        minDistRight = propertyLaterCouple. minDistRight;
    }

    @Override
    public ArrayList<Point> getShapeFromPoint(Point point) {
        grainLB = point;
        ArrayList<Point> res = new ArrayList<>();
        point.moveCurrentPositionWith5CmConvert(0, 0, 0, 530);
        FillArea(point, res, 200, 1260);
        point.moveCurrentPositionWith5CmConvert(295, 0, 200, 0);
        FillArea(point, res, 330, 1555);
        point.moveCurrentPositionWith5CmConvert(125, 0, 330, 0);
        FillArea(point, res, 1030, 1680);
        point.moveCurrentPositionWith5CmConvert(0, 0, 1030, 0);
        FillArea(point, res, 120, 1100);
        return res;
    }

    @Override
    public IPropertyUnit rotate() {
        return new PropertyLaterCouple(this);
    }

    @Override
    public ArrayList<IPropertyUnit> getRotates() {
        ArrayList<IPropertyUnit> res = new ArrayList<>();
        res.add(new PropertyLaterCouple(this));
        return res;
    }
}
