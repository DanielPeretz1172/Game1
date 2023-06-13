import javax.swing.*;

public class MainGameScene extends JFrame {
    public static final int Window_Width =1000;
    public static final int Window_Height =1200;

    public MainGameScene (int x){
        if(x==1) {
            this.setSize(Window_Width, Window_Height);
            this.setLocationRelativeTo(null);
            GameScene gameScene = new GameScene();
            this.add(gameScene);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }else {
            this.setSize(665, 581);
            this.setLocationRelativeTo(null);
            Manuals manuals = new Manuals();
            this.add(manuals);
        }
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);


    }
}
