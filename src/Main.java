
import javax.swing.*;

public class Main extends JFrame {
    public static final int Window_Width =1600;
    public static final int Window_Height =1000;


    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main (){
        Panel p = new Panel();
        this.add(p);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Window_Width, Window_Height);
        this.setVisible(true);

    }
}