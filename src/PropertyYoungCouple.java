import java.util.ArrayList;

/**
 * Created by Nir on 11/01/2019.
 */
public class PropertyYoungCouple extends IPropertyUnit {


    PropertyYoungCouple(int id){
        this.id = id;
        minDistLeft = FiveCmConverter.convert(375);
        minDistUp = FiveCmConverter.convert(1030);
        minDistDown = FiveCmConverter.convert(330);
        minDistRight = FiveCmConverter.convert(1115);
    }

    public PropertyYoungCouple(PropertyYoungCouple propertyYoungCouple) {
        this.id = propertyYoungCouple.id;
        minDistLeft = propertyYoungCouple.minDistLeft;
        minDistUp = propertyYoungCouple.minDistUp;
        minDistDown = propertyYoungCouple.minDistDown;
        minDistRight = propertyYoungCouple. minDistRight;
    }

    @Override
    public ArrayList<Point> getShapeFromPoint(Point point) {
        grainLB = point;
        ArrayList<Point> res = new ArrayList<>();
        point.moveCurrentPosition(FiveCmConverter.convert(375), 0, 0, FiveCmConverter.convert(330));
        FillArea(point, res, 330, 1175);
        point.moveCurrentPosition(0, 0, FiveCmConverter.convert(330), 0);
        FillArea(point, res, 900, 1415);
        point.moveCurrentPosition(0, FiveCmConverter.convert(375), FiveCmConverter.convert(900), 0);
        FillArea(point, res, 130, 1040);
        return res;
    }

    @Override
    public IPropertyUnit rotate() {
        return new PropertyYoungCouple(this);
    }

    @Override
    public ArrayList<IPropertyUnit> getRotates() {
        ArrayList<IPropertyUnit> res = new ArrayList<>();
        res.add(new PropertyYoungCouple(this));
        return res;
    }

    /*@Override
    public int getWidth() {
        return FiveCmConverter.convert(1415);
    }

    @Override
    public int getHeight() {
        return FiveCmConverter.convert(1480);
    }*/
}
