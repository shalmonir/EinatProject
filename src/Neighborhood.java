import java.util.*;

public class Neighborhood {
    private static final int SAFTY_BUFFER = 0;
    private final int properties_horizontal;
    private final int properties_vertical;
    int length;
    int height;
    ArrayList<Geographic> solutions;
    ArrayList<IPropertyUnit> houses;

    public Neighborhood(int biggest_property_length, int biggest_property_height, int properties_horizontal, int properties_vertical) {
        this.length = biggest_property_length * properties_horizontal + SAFTY_BUFFER;
        this.height = this.length; //2 * (biggest_property_height * properties_vertical + SAFTY_BUFFER);
        this.properties_horizontal = properties_horizontal;
        this.properties_vertical = properties_vertical;

        houses = new ArrayList<>();
        solutions = new ArrayList<>();
    }

    public void addHouse(IPropertyUnit propertyUnit){
        houses.add(propertyUnit);
    }

    public void print(){
        solutions.forEach(e -> e.print());
        System.out.print("Number of solutions: " + solutions.size() + "\n");
    }

    public ArrayList<Geographic> placeAllProperties(ArrayList<IPropertyUnit> unSubmittedProperties, ArrayList<Geographic> res){
        if(unSubmittedProperties.isEmpty()){
            return res;
        }
        ArrayList<Geographic> newRes = new ArrayList<>();
        IPropertyUnit propertyUnit = unSubmittedProperties.remove(0);
        for(Geographic sol: res){
            for(IPropertyUnit rotated: propertyUnit.getRotates()){
                Geographic newSolution = new Geographic(sol);
                newRes.addAll(newSolution.setHouseOnPointAndGetAllSolutions(rotated));
            }
        }
        return placeAllProperties(unSubmittedProperties, newRes);
        }

    public int getDiversity(){
        return 0;
    }

    public int getNotUsedSpace(){
        return 100000;
    }

    public void placeAllPropertiesWrapper() {
        Geographic init = new Geographic(length, height, properties_horizontal, properties_vertical);
//        Geographic initRotate = new Geographic(length, height, max_radius, min_radius, 2, 2);
        IPropertyUnit firstProperty = houses.remove(0);
        // TODO: realize how to locate the first without radius
//        init.placeProperty(firstProperty, new Point(firstProperty.radius,firstProperty.radius));
        init.placeProperty(firstProperty, firstProperty.getFirstLocation());


//        initRotate.placeProperty(firstProperty.rotate(), new Point(firstProperty.radius,firstProperty.radius));
        solutions.add(init);
//        ArrayList<Geographic> t = new ArrayList<>();
//        t.add(init);
//        t.add(initRotate);
        solutions = placeAllProperties(houses, solutions);
        for(Geographic s: solutions){
            s.cleanZeros();
        }
    }
}
