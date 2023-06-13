import java.awt.*;

public class MyCarRectangl {

    public int x;
    private int y;
    private int height;
    private int width;

    public boolean isAlive;
    private MyCar myCar;


    public MyCarRectangl(int x, int y, int width,int height){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.isAlive = true;
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

    public void moveRight (){
        this.x = x+150;
    }
    public void moveLeft (){
        this.x = x-150;
    }
    public void moveUp (){
        this.y = y - 150;
    }
    public void moveDown (){
        this.y = y + 150;
    }

    public Rectangle calculateRectangle(){
        return new Rectangle(this.x ,  this.y, this.width, this.height);
    }
    public boolean checkCollision (RectanglObstacle rectangleObstacle){
        Rectangle player = new Rectangle(this.x,this.y,this.width,this.height);
        Rectangle obstacle = new Rectangle((int) rectangleObstacle.getX(),(int) rectangleObstacle.getY(),rectangleObstacle.getWidth(),rectangleObstacle.getHeight());
        if (player.intersects(obstacle)){
            return true;
        }
        return false;
    }

}
