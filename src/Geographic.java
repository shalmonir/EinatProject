import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Geographic {
    int length;
    int height;
    int[][] map;
    List<IPropertyUnit> houses;
    int rightest = 0;
    int downiest = 0;
    boolean[][] taken;

    public Geographic(int length, int height, int NPropertiesInRow, int NPropertiesInColumn){
        this.length = length;
        this.height = height;
        map = new int[height][length];
        houses = new ArrayList<>();
        taken = new boolean[NPropertiesInRow][NPropertiesInColumn];
        for(int i = 0; i < NPropertiesInRow; i++) {
            for (int j = 0; j < NPropertiesInColumn; j++) {
                taken[i][j] = false;
            }
        }
    }

    public Geographic(Geographic geographic) {
        this.length = geographic.length;
        this.height = geographic.height;
        this.map = new int[geographic.height][geographic.length];
        for(int i = 0; i < geographic.height; i++){
            for(int j = 0; j < geographic.length; j++){
                this.map[i][j] = geographic.map[i][j]       ;
            }
        }
        this.houses = new ArrayList<>(geographic.houses);
        this.downiest = geographic.downiest;
        this.rightest = geographic.rightest;
        taken = new boolean[geographic.taken.length][geographic.taken[0].length];
        for(int i = 0; i < geographic.taken.length; i++) {
            for (int j = 0; j < geographic.taken[0].length; j++) {
                taken[i][j] = geographic.taken[i][j];
            }
        }
    }

    public void print() {
        for(int line = 0; line < height ; line++){
            for(int column = 0; column < length ; column++){
                System.out.print(map[line][column]);
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    public ArrayList<Geographic> setHouseOnPointAndGetAllSolutions(IPropertyUnit propertyUnit) {
        ArrayList<Geographic> res = new ArrayList<>();
        for(Point p: getAllCandidateLocationPoints(propertyUnit)){
            Geographic geographic = new Geographic(this);
            try {
                res.add(geographic.placeProperty(propertyUnit, p));
            } catch (Exception e){ /*e.printStackTrace(); no legal solution - do nothing */ }
        }
        return res;
    }

    public Geographic placeProperty(IPropertyUnit propertyUnit, Point p) {
        ArrayList<Point> w = propertyUnit.getShapeFromPoint(p);
        for(Point point: w){
            if(point.x > downiest)
                downiest = point.x;
            if(point.y > rightest)
                rightest = point.y;
            try{
                if(map[point.x][point.y] != 0) {
                    throw new notLegalLocation();
                }
            } catch (ArrayIndexOutOfBoundsException e){
                throw new notLegalLocation();
            }
            map[point.x][point.y] = propertyUnit.id;
        }
        this.houses.add(propertyUnit);
        this.markNextTakenProperty();
        return this;
    }

    private void markNextTakenProperty() {
        for(int i = 0; i < taken.length ; i++) {
            for(int j = 0; j < taken[0].length ; j++){
                if(taken[i][j] == false){
                    if(j == taken[0].length - 1){
                        rightest = 0;
                    }
                    taken[i][j] = true;
                    return;
                }
            }
        }
    }

    // Constrains related to the general area
    public Collection<Point> getAllCandidateLocationPoints(IPropertyUnit propertyUnit){
        try {
            ArrayList<Point> res = new ArrayList<>();
            int line = getCurrentLine();
            int Column = getCurrentColumn();
            int line_to_start = propertyUnit.minDistUp + 1;
            if (line > 0) {
                line_to_start = map.length - 1;
                boolean found = false;
                for (int i = map.length - 1; i > 0; i--) {
                    for (int col = rightest + propertyUnit.minDistLeft; col < rightest + propertyUnit.minDistLeft + propertyUnit.getWidth(); col++) {
                        if (map[i - propertyUnit.minDistUp][col] != 0) {
                            line_to_start = i + 1;
                            found = true;
                            break;
                        }
                    }
                    //                if(map[i - propertyUnit.minDistUp][rightest + propertyUnit.minDistLeft] != 0){}
                    if (found) {
                        break;
                    }
                }
            }

            Point start = new Point(line_to_start, rightest + propertyUnit.minDistLeft + 1);
            res.add(start);
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 1; j++) {
                    res.add(new Point(start.x + i, start.y + j));
                }
            }
            return res;
        } catch (ArrayIndexOutOfBoundsException e) {
            return new ArrayList<Point>();
        }
    }

    public int getDiversity(){
        return 0;
    }

    public int getNotUsedSpace(){
        int res = 0;
        for(int[] line: map)
            for(int num: line)
                if(num == 0)
                    res++;
        return res;
    }

    public void cleanZeros(){
        int firstColumn = 0;
        int firstLine = 0;
        int lastColumn = length - 1;
        int lastLine = height - 1;
        boolean found = false;
        for (int line = 0; line < height; line++){
            for(int col = 0; col < length; col++){
                if(map[line][col] != 0){
                    firstLine = line;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        found = false;
        for (int col = 0; col < length; col++){
            for(int line = 0; line < height; line++){
                if(map[line][col] != 0){
                    firstColumn = col;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        found = false;
        for (int line = height - 1; line > 0; line--){
            for(int col = length - 1; col > 0; col--){
                if(map[line][col] != 0){
                    lastLine = line;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        found = false;
        for(int col = length - 1; col > 0; col--){
            for (int line = height - 1; line > 0; line--){
                if(map[line][col] != 0){
                    lastColumn = col;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        int[][] cleaned = new int[lastLine - firstLine + 1][lastColumn - firstColumn + 1];
        for(int line = 0; line < lastLine - firstLine + 1; line ++){
            for(int col = 0; col < lastColumn - firstColumn + 1; col ++){
                cleaned[line][col] = map[line + firstLine][col + firstColumn];
            }
        }
        map = cleaned;
        this.length = lastColumn - firstColumn + 1;
        this.height = lastLine - firstLine + 1;

        /*for(int line = 0; line < lastLine - firstLine + 1; line ++){
            for(int col = 0; col < lastColumn - firstColumn + 1; col ++){
                System.out.print(cleaned[line][col]);
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");*/
    }

    public int getCurrentLine() {
        for(int i = 0; i < taken.length ; i++) {
            for(int j = 0; j < taken[0].length ; j++){
                if(taken[i][j] == false){
                    return i;
                }
            }
        }
        return 10000000;
    }

    public int getCurrentColumn() {
        for(int j = 0; j < taken[0].length ; j++){
            for(int i = 0; i < taken.length ; i++) {
                if(taken[i][j] == false){
                    return j;
                }
            }
        }
        return 10000000;
    }

    class notLegalLocation extends RuntimeException {

    }
}
