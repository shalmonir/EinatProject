public class Point {
    public int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point clone(){
        return new Point(this.x, this.y);
    }

    public void moveCurrentPosition(int left, int right, int up, int down) {
        this.x = x + down - up;
        this.y = y - left + right;
    }

    public void moveCurrentPositionWith5CmConvert(int left, int right, int up, int down) {
        this.x = x + FiveCmConverter.convert(down) - FiveCmConverter.convert(up);
        this.y = y - FiveCmConverter.convert(left) + FiveCmConverter.convert(right);
    }

    public void print(){
        System.out.print("(" + x + ", " + y + ")\n");
    }
}
