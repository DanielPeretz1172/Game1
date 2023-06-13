import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement implements KeyListener {

    private MyCar carPlayer;
    private MyCarRectangl rectanglPlayer;

    public PlayerMovement(MyCar carPlayer, MyCarRectangl rectanglPlayer){
        this.carPlayer = carPlayer;
        this.rectanglPlayer = rectanglPlayer;

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_UP:
                this.carPlayer.moveUp();
                this.rectanglPlayer.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                this.carPlayer.moveDown();
                this.rectanglPlayer.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                this.carPlayer.moveLeft();
                this.rectanglPlayer.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                this.carPlayer.moveRight();
                this.rectanglPlayer.moveRight();
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
