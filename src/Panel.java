import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public static final int Window_Width =1600;
    public static final int Window_Height =1000;
    private ImageIcon backGround;
    private int counter = 0;
    public Panel(){
        this.setBounds(0 ,0, Window_Width,Window_Height);
        this.backGround = new ImageIcon("homeScreen.jpg");
        this.setLayout(null);

        JButton startButton =  new JButton("start game");
        startButton.setBounds(350, 50, 250,50);
        startButton.setBackground(Color.yellow);
        startButton.setFocusable(false);
        startButton.addActionListener((event) -> {
            if (counter == 0) {
                counter++;
                MainGameScene mainGameScene = new MainGameScene(1);
                this.add(mainGameScene);
            }
        });
        this.add(startButton);

        JButton manualButton =  new JButton("manuals");
        manualButton.setBounds(50, 50, 250,50);
        manualButton.setBackground(Color.yellow);
        manualButton.setFocusable(false);
        manualButton.addActionListener((event) -> {
           MainGameScene mainGameScene = new MainGameScene(0);
           this.add(mainGameScene);
        });
        this.add(manualButton);


    }



    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        this.backGround.paintIcon(this,graphics,0,0);
    }
}
