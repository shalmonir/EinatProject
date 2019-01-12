import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FindNeighborhood {

    public static void main(String[] args){
        System.out.print(">>> Start \n");
//        Neighborhood neighborhood = CreateBasicQuadNeighborhood();
//        Print45Solutions(neighborhood);
        Neighborhood n = CreateBasicUnoNeighborhood();
        PrintSolution(n, 0);
    }

    private static Neighborhood CreateBasicUnoNeighborhood() {
        IPropertyUnit x = new PropertyLaterCouple(3);
        int biggest_property_width = x.getWidth();
        int biggest_property_height = x.getHeight();

        int properties_horizontal = 2;
        int properties_vertical = 2;
        Neighborhood neighborhood = new Neighborhood(biggest_property_height, biggest_property_width, properties_horizontal, properties_vertical);
        neighborhood.addHouse(x);
        neighborhood.placeAllPropertiesWrapper();
        return neighborhood;
    }

    private static void Print45Solutions(Neighborhood neighborhood) {
        for(int i=0; i < 45; i++)
            PrintSolution(neighborhood, i);
        System.out.print("Number of solutions: " + neighborhood.solutions.size() + "\n");
        neighborhood.getBestSpaceUse();
    }

    private static Neighborhood CreateBasicQuadNeighborhood() {
        IPropertyUnit first_fam = new PropertyFamilyOfThree(5);
        IPropertyUnit fiveFamily = new PropertyFamilyOfFive(3);
        int biggest_property_width = fiveFamily.getWidth();
        int biggest_property_height = fiveFamily.getHeight();

        int properties_horizontal = 2;
        int properties_vertical = 2;
        Neighborhood neighborhood = new Neighborhood(biggest_property_height, biggest_property_width, properties_horizontal, properties_vertical);
        neighborhood.addHouse(first_fam);
        neighborhood.addHouse(new PropertyYoungCouple(2));
        neighborhood.addHouse(fiveFamily);
        neighborhood.addHouse(new PropertyLaterCouple(4));
        neighborhood.placeAllPropertiesWrapper();
        return neighborhood;
    }

    private static void PrintSolution(Neighborhood neighborhood, int index) {
        try {
            Geographic sol = neighborhood.solutions.get(index);
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
            File output = new File("../GrayScalesEinat/GrayScale" + index + ".jpg");

                ImageIO.write(image, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
