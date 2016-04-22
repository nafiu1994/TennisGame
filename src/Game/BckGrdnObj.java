package Game;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

//import javax.sound.sampled.*
/**
 *
 * @author Nafiu
 */
public class BckGrdnObj extends Canvas {

    private int oneX = 100;
    private int oneY = 200;
    private int incrementor = 5;
    private int cScore = 0, hScore = 0;
    private boolean up = false;
    private boolean down = true;
    private boolean left = false;
    private boolean right = true;
    int ballX, ballY, mouseX, mouseY;
    Image bckPic;
    Image CBat, UsrBat, ball;
    int batX = 460, batY = 400;

    public BckGrdnObj() throws Exception {
        bckPic = ImageIO.read(new File("images\\table.jpg"));
        CBat = ImageIO.read(new File("images\\bat.png"));
        UsrBat = ImageIO.read(new File("images\\bat.png"));
        ball = ImageIO.read(new File("images\\ball.png"));
        System.out.println("Initialized BckGrdnObj Default");
    }

    public BckGrdnObj(int BallX, int BallY, int BatX, int BatY) {
        batX = BatX;
        batY = BatY;
        ballX = BallX;
        ballY = BallY;
        System.out.println("Initialized BckGrdnObj with parameters");
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Sans-serif", Font.BOLD, 20));
        g.drawString("Human", 150, 20);
        g.drawString("Computer", 225, 20);
        g.setFont(new Font("Sans-serif", Font.BOLD, 30));
        g.drawString("SCORE", 10, 50);
        while (true) {
            g.setColor(Color.white);
            g.fill3DRect(160, 30, 80, 20, true);
            g.setColor(Color.blue);
            g.drawString(Integer.toString(cScore), 175, 50);
            g.drawString(Integer.toString(hScore), 250, 50);
            try {
                Thread.sleep(5);
            } catch (Exception ex) {
                System.err.printf("%s", ex);
            }
            //g.drawString("x = " + Double.toString(super.getMousePosition().getX()), 500, 50);
            //g.drawString("y = " + Double.toString(super.getMousePosition().getY()), 600, 50);
            g.drawImage(bckPic, 0, 55, this);
            g.drawImage(CBat, oneX, 100, 60, 70, this);
            //g.drawImage(ball, oneX, oneY, 40, 40, this);
            g.fillOval(oneX, oneY, 25, 25);
            try {
                g.drawImage(UsrBat, (int) super.getMousePosition().getX() - 50, 400, 125, 130, this);
            } catch (NullPointerException npe) {
                try {
                    System.out.println("(x, y)" + oneX + " " + oneY);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Thread error");
                }
            }
            //g.drawLine(390, 100, 50, 500);
            if (oneY >= super.getHeight() - 250) {
                if (oneX >= super.getMousePosition().getX() - 50 && oneX <= super.getMousePosition().getX() + 50) {
                    up = true;
                    down = false;
                    System.out.println("Collision Occured");
                } else {
                    cScore++;
                    try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Thread error");
                }
                }
            }
            if (oneY < 300) {
                if (oneX > 900) {
                    right = false;
                    left = true;
                }
                if (oneX < 100) {
                    right = true;
                    left = false;
                }
            }
            if (oneY > 180 && oneY < 187) {
                incrementor = 8;
            } 
            else if (oneY > 391 && oneY < 400) {
                incrementor = 10;
            }
            else{
                incrementor = 5;
            }
            if (oneY >= 100 && oneY < 220) 
            {
                System.out.println("Frame 1");
                if (oneX < 330) {
                    right = true;
                    left = false;
                }
                if (oneX > 660) {
                    right = false;
                    left = true;
                }
                if(oneY < 120){
                    up = false;
                    down = true;
                }
            }
            if (oneY >= 220 && oneY < 320) {
                System.out.println("Frame 2");
                if (oneX < 280) {
                    right = true;
                    left = false;
                }
                if (oneX > 750) {
                    right = false;
                    left = true;
                }
            }
            if (oneY >= 320 && oneY < 390) {
                System.out.println("Frame 3");
                if (oneX < 200) {
                    right = true;
                    left = false;
                }
                if (oneX > 830) {
                    right = false;
                    left = true;
                }
            }
            if (oneY >= 390 && oneY < 550) {
                System.out.println("Frame 4");
                if (oneX < 120) {
                    right = true;
                    left = false;
                }
                if (oneX > 900) {
                    right = false;
                    left = true;
                }
                if(oneY > 530){
                    up = true;
                    down = false;
                }
            }
            /*if (oneX >= 900) {
                right = false;
                left = true;
            }
            if (oneX <= 50) {
                right = true;
                left = false;
            }
            if (oneY <= 200) {
                up = false;
                down = true;
            }
            if (oneY >= 650) {
                up = true;
                down = false;
            }*/
            if (up) {
                oneY -= 5;
            }
            if (down) {
                oneY += 5;
            }
            if (left) {
                oneX -= incrementor;
            }
            if (right) {
                oneX += incrementor;
            }
        }
    }
}
