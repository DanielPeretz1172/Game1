import javax.swing.*;
import java.awt.*;

public class MyCar {
    private int x ;
    private int y ;
    ImageIcon car ;
    public static boolean isAlive;

    public MyCar(ImageIcon car, int x, int y){
        this.car = car;
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }

    public void moveRight (){
        this.x = x+155;
    }
    public void moveLeft (){
        this.x = x-155;
    }
    public void moveUp (){
        this.y = y- 150;
    }
    public void moveDown (){
        this.y =y + 150;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    protected void paint (Graphics graphics){
        if (isAlive){
            this.car.paintIcon(null,graphics,x,y);

        }
    }



}
