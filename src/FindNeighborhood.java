import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FindNeighborhood {

    public static void main(String[] args){
        System.out.print(">>> Start \n");
        /*
        int length_in_meters = 20;
        int height_in_meters = 20;
        int max_radius = 5;
        int min_radius = 3;
        int properties_horizontal = 2;
        int properties_vertical = 2;
        Neighborhood neighborhood = new Neighborhood(length_in_meters, height_in_meters, max_radius, min_radius,
                properties_horizontal, properties_vertical);
        neighborhood.addHouse(new SimpleProperty(1));
        neighborhood.addHouse(new SimpleProperty(2));
        neighborhood.addHouse(new SimpleProperty(3));
        neighborhood.addHouse(new SimpleProperty(4));
        neighborhood.placeAllPropertiesWrapper();
        neighborhood.print();
        */










        // first property try :)
        IPropertyUnit p = new PropertyYoungCouple(1);
        int biggest_property_width = p.getWidth();
        int biggest_property_height = p.getHeight();

        int properties_horizontal = 2;
        int properties_vertical = 2;
        Neighborhood neighborhood = new Neighborhood(biggest_property_height, biggest_property_width, properties_horizontal, properties_vertical);
        neighborhood.addHouse(p);
        neighborhood.addHouse(new PropertyYoungCouple(2));
        neighborhood.addHouse(new PropertyYoungCouple(3));
//        neighborhood.addHouse(new PropertyYoungCouple(4));
//        neighborhood.addHouse(new PropertyYoungCouple(5));
//        neighborhood.addHouse(new PropertyYoungCouple(6));
//        neighborhood.addHouse(new PropertyYoungCouple(7));
//        neighborhood.addHouse(new PropertyYoungCouple(8));
//        neighborhood.addHouse(new PropertyYoungCouple(9));
        neighborhood.placeAllPropertiesWrapper();







        try {
            Geographic sol = neighborhood.solutions.get(0);
            int[][] yourmatrix = sol.map;
            BufferedImage image = new BufferedImage(yourmatrix[0].length, yourmatrix.length, 1);
            for(int i=0; i < yourmatrix.length; i++) {
                for(int j=0; j < yourmatrix[0].length; j++) {
                    int a = yourmatrix[i][j];
                    Color newColor = new Color(a*28,a*28,a*28);
//                    System.out.print("i = " + i + ", j = " + j + "\n");
                    image.setRGB(j, i, newColor.getRGB());
                }
            }
            File output = new File("GrayScale.jpg");

                ImageIO.write(image, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
//        neighborhood.print();
    }
}
