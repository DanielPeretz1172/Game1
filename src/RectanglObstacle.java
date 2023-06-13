import java.awt.*;

public class RectanglObstacle {
    private double x ;
    private double y ;
    private int height;
    private int width;

    public RectanglObstacle(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public void moveDown (double z){
        this.y = y + z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public Rectangle calculateRectangle(){
        return new Rectangle((int) this.x , (int) this.y, this.width, this.height);
    }
}
