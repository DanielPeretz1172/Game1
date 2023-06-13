import javax.swing.*;
import java.awt.*;

public class CarObstacle {

    private double x;
    private double y;
    private ImageIcon car;

    public CarObstacle(int x, int y, ImageIcon car) {
        this.x = x;
        this.y = y;
        this.car = car;
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

    protected void paint (Graphics graphics){
        this.car.paintIcon(null,graphics,(int) x, (int) y);
    }
}

