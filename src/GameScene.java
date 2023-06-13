import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameScene extends JPanel  {
    private ImageIcon roadBackGround;
    public static final int Window_Width =1112;
    public static final int Window_Height =1200;
    public static int counter = 0;
    private JTextField textField;
    private ImageIcon myCar ;
    private MyCar playerCar;
    private int x = 510;
    private int y = 500;
    private ImageIcon texiCar ;
    private ImageIcon whiteCar ;
    private ImageIcon redCar ;
    private ImageIcon texiCarAgainst ;
    private ImageIcon whiteCarAgainst ;
    private ImageIcon redCarAgainst ;


     private int [] rightRedCarPath = new int[2];
    private int [] rightTaxiCarPath = new int[2];
    private int [] rightWhiteCarPath = new int[2];
    private int [] rightRedCarOppositivePath = new int[2];
    private int [] rightTaxiCarOppositivePath = new int[2];
    private int [] rightWhiteCarOppositivePath = new int[2];
    private CarObstacle [] carObstacleArr;
    private RectanglObstacle[] rectanglObstaclesArr;
    private CarObstacle [] oppositiveCarObstacleArr;
    private RectanglObstacle[] oppositiveRectanglObstaclesArr;

    private CarObstacle carObstacle ;
    // private RectanglObstacle rectanglObstacle;                                           //


    private MyCarRectangl myCarRectangl;



    public GameScene(){
        counter =0;
        this.setBounds(0,0, Window_Width,Window_Height);
        this.roadBackGround = new ImageIcon("medium.gif");
        this.setLayout(null);
        this.setVisible(true);
        this.myCar = new ImageIcon("myCar.png");
        this.playerCar = new MyCar(myCar,this.x , this.y);
        this.myCarRectangl = new MyCarRectangl(this.x,this.y, 90,170);
        this.texiCar = new ImageIcon("texiCar.png");
        this.whiteCar= new ImageIcon("whiteCar.png");
        this.redCar = new ImageIcon("redCar.png");
        this.texiCarAgainst = new ImageIcon("texiCarAgainst.png");
        this.whiteCarAgainst = new ImageIcon("whiteCarAgainst.png");
        this.redCarAgainst = new ImageIcon("redCarAgainst.png");
        this.rightRedCarPath[0] = 665;
        this.rightRedCarPath[1] = 510;
        this.rightTaxiCarPath[0] = 665;
        this.rightTaxiCarPath[1] = 510;
        this.rightWhiteCarPath[0] = 665;
        this.rightWhiteCarPath[1] = 510;

        this.rightRedCarOppositivePath[0] = 205;
        this.rightRedCarOppositivePath[1] = 350;
        this.rightTaxiCarOppositivePath[0] = 215;
        this.rightTaxiCarOppositivePath[1] = 350;
        this.rightWhiteCarOppositivePath[0] = 205;
        this.rightWhiteCarOppositivePath[1] = 350;


        int carYSpace = 0;
        carObstacleArr = new CarObstacle[8001];
        rectanglObstaclesArr = new RectanglObstacle[8001];
        for (int i = 0; i < carObstacleArr.length; i=i+3) {
             carObstacle = new CarObstacle(getRandom(rightRedCarPath),carYSpace,redCar );
             carObstacleArr[i] = carObstacle;
            rectanglObstaclesArr[i] = new RectanglObstacle(carObstacle.getX()+50, carObstacle.getY()+5,75,155 );
              carYSpace -= 700;

           carObstacle = new CarObstacle(getRandom(rightTaxiCarPath),carYSpace,texiCar );
            carObstacleArr[i+1] = carObstacle;
            rectanglObstaclesArr[i+1] = new RectanglObstacle(carObstacle.getX()+ 25, carObstacle.getY()+5,75,155);
             carYSpace -=700;


            carObstacle = new CarObstacle(getRandom(rightWhiteCarPath),carYSpace,whiteCar );
            carObstacleArr[i+2] = carObstacle;
            rectanglObstaclesArr[i+2] = new RectanglObstacle(carObstacle.getX()+60, carObstacle.getY()+10,65,145);
            carYSpace -= 700;

        }
        int oppositiveCarYSpace = 0;
        oppositiveCarObstacleArr = new CarObstacle[8001];
        oppositiveRectanglObstaclesArr = new RectanglObstacle[8001];
        for (int i = 0; i < oppositiveCarObstacleArr.length; i=i+3) {
            carObstacle = new CarObstacle(getRandom(rightRedCarOppositivePath),oppositiveCarYSpace,redCarAgainst);
            oppositiveCarObstacleArr[i] = carObstacle;
            oppositiveRectanglObstaclesArr[i] = new RectanglObstacle(carObstacle.getX()+50, carObstacle.getY()+10,70,150);
            oppositiveCarYSpace -= 700;

            carObstacle = new CarObstacle(getRandom(rightTaxiCarOppositivePath),oppositiveCarYSpace,texiCarAgainst );
            oppositiveCarObstacleArr[i+1] = carObstacle;
            oppositiveRectanglObstaclesArr[i+1] = new RectanglObstacle(carObstacle.getX()+20, carObstacle.getY()+5,70,150);
            oppositiveCarYSpace -=700;


            carObstacle = new CarObstacle(getRandom(rightWhiteCarOppositivePath),oppositiveCarYSpace,whiteCarAgainst );
            oppositiveCarObstacleArr[i+2] = carObstacle;
            oppositiveRectanglObstaclesArr[i+2] = new RectanglObstacle(carObstacle.getX()+50, carObstacle.getY()+15,65,150);
            oppositiveCarYSpace -= 700;

        }

        Font font = new Font("arial",Font.BOLD,30);
        textField = new JTextField();
        textField.setBackground(Color.red);
        textField.setForeground(Color.black);
        textField.setFont(font);
        textField.setBounds(0 ,0 ,150,30);
        this.add(textField);
        textField.setText(String.valueOf(counter));
        moveCars();
        mainGameLoop();
    }


    public void moveCars (){
        Thread t = new Thread(() -> {


            double speed = 0.4;
                double oppositiveSpeed = 0.7;
                int counter = 0;
                int checkCounter = 0;
                while (true) {
                    for (int i = 0; i < carObstacleArr.length; i++) {
                        counter++;
                        if (counter > checkCounter + 3) {
                            speed += 0.00000002;
                            oppositiveSpeed += 0.00000002;

                            checkCounter = counter;
                        }

                        carObstacleArr[i].moveDown(speed);
                        rectanglObstaclesArr[i].moveDown(speed);
                        oppositiveCarObstacleArr[i].moveDown(oppositiveSpeed);
                        oppositiveRectanglObstaclesArr[i].moveDown(oppositiveSpeed);
                    }

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

        });t.start();
    }

    public static int getRandom (int[] arr){
        int rnd = new Random().nextInt(arr.length);
        return arr[rnd];
    }

    public void mainGameLoop(){
        Thread t = new Thread(()-> {
            PlayerMovement playerMovement = new PlayerMovement(playerCar, myCarRectangl);
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(playerMovement);

            while (true){

                for (int i = 0; i < rectanglObstaclesArr.length; i++) {
                    if (myCarRectangl.checkCollision(rectanglObstaclesArr[i])){

                  EndPanel end = new EndPanel();
                        this.add(end);
                        textField.setVisible(false);

                    }
                }

                for (int j = 0; j < oppositiveRectanglObstaclesArr.length; j++) {
                    if (myCarRectangl.checkCollision(oppositiveRectanglObstaclesArr[j])){

                        EndPanel end = new EndPanel();
                        this.add(end);
                        textField.setVisible(false);
                    }
                }

                try {
                    Thread.sleep(3);
                    counter ++;
                    textField.setText(String.valueOf(counter));
                    repaint();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                limits();
         }
        });t.start();
    }
    public void limits (){
        if(this.myCarRectangl.getY() < 0 || this.playerCar.getY() < 0){
            this.playerCar.setY(0);
            this.myCarRectangl.setY(0);
        }
        if(this.myCarRectangl.getY() > 500 || this.playerCar.getY() > 500){
            this.playerCar.setY(500);
            this.myCarRectangl.setY(500);
        }
          System.out.print("");
        if(this.myCarRectangl.getX() > 665 || this.playerCar.getX() > 665){
            this.playerCar.setX(665);
            this.myCarRectangl.setX(665);
        }
        if(this.myCarRectangl.getX() < 215 || this.playerCar.getX() < 215){
            this.playerCar.setX(215);
            this.myCarRectangl.setX(215);
        }
    }


    public void paintComponent(Graphics g ){
        super.paintComponent(g);
        this.roadBackGround.paintIcon(this,g,0,0);
        this.playerCar.paint(g);
        for (int i = 0; i < carObstacleArr.length; i++) {
            this.carObstacleArr[i].paint(g);
            this.oppositiveCarObstacleArr[i].paint(g);
        }
    }
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        GameScene.counter = counter;
    }
        
}
