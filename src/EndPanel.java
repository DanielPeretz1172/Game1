import javax.swing.*;
import java.awt.*;

public class EndPanel extends JPanel {
    public static final int Window_Width = 1000;
    public static final int Window_Height = 1200;
    private ImageIcon beckGround;
    private int counter = GameScene.getCounter();


    public EndPanel() {
        this.setBounds(0, 0, Window_Width, Window_Height);
        this.beckGround = new ImageIcon("carAfterAnAccident.jpg");
        this.setLayout(null);

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.beckGround.paintIcon(this, graphics, 0, 0);
        graphics.setColor(Color.RED);
        graphics.setFont(new Font(null,50,50));
        graphics.drawString("Your score is: " + counter ,100,70);
    }
}
