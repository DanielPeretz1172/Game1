import javax.swing.*;
import java.awt.*;

public class Manuals extends JPanel {
    public static final int Window_Width =665;
    public static final int Window_Height =581;
   private ImageIcon beckGround;


    public Manuals (){
        this.setBounds(0 ,0, Window_Width,Window_Height);
        this.beckGround = new ImageIcon("panel of game instructions.jpg");
        this.setLayout(null);
       
    }
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        this.beckGround.paintIcon(this,graphics,0,0);
    }
}
