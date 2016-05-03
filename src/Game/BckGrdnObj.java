package Game;

import java.awt.*;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

//import javax.sound.sampled.*
/**
 *
 * @author Nafiu
 */
public class BckGrdnObj extends Canvas {

    private String lvl;
    private int oneX = 100, oneY = 200, incrementor = 5;
    private int cScore = 0, hScore = 0, speed;
    private int batX = 460, batY = 400, size = 25;
    private float lvlTmp;
    private boolean up = false;
    private boolean down = true;
    private boolean left = false;
    private boolean right = true;
    private boolean inGame = true, point = false;
    private Random rn = new Random();
    private Image bckPic, CBat, UsrBat, ball;
    
    

    public BckGrdnObj() throws Exception {
        bckPic = ImageIO.read(new File("images\\table.jpg"));
        CBat = ImageIO.read(new File("images\\bat.png"));
        UsrBat = ImageIO.read(new File("images\\bat.png"));
        ball = ImageIO.read(new File("images\\ball.png"));
        System.out.println("Initialized BckGrdnObj Default");
    }

    public void setLvl(String l) {
        lvl = l.toLowerCase();
       
        switch (lvl) {
            case "hard":
                speed = 10;
                lvlTmp = (float) 0.8;
                break;
            case "medium":
                speed = 15;
                lvlTmp = (float) 0.6;
                break;
            default:
                speed = 20;
                lvlTmp = (float) 0.4;
                break;
        }
    }

    public void paint(Graphics g) {
        System.out.println("Graphics painting");
        g.setFont(new Font("Sans-serif", Font.BOLD, 20));
        g.drawString("Human", 150, 20);
        g.drawString("Computer", 225, 20);
        g.setFont(new Font("Sans-serif", Font.BOLD, 30));
        g.drawString("SCORE", 10, 50);
        while (inGame) {
            while (!point) {
                g.setColor(Color.white);
                g.fill3DRect(160, 30, 80, 20, true);
                g.setColor(Color.blue);
                g.drawString(Integer.toString(cScore), 175, 50);
                g.drawString(Integer.toString(hScore), 250, 50);
                try {
                    Thread.sleep(speed);
                } catch (Exception ex) {
                    System.err.printf("%s", ex);
                }
                g.drawImage(bckPic, 0, 55, this);
                
                g.fillOval(oneX, oneY, size, size);
                try {
                    g.drawImage(UsrBat, (int) super.getMousePosition().getX() - 50, 400, 125, 130, this);
                     g.drawImage(CBat, oneX, 100, 60, 70, this);
                } catch (NullPointerException npe) {
                    try {
                        System.out.println("(x, y)" + oneX + " " + oneY);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Thread error");
                    }
                }
                g.drawLine(0, 500, 900, 500);
                if (oneY > 150 && oneY < 300){
                if (oneY > 450 && oneY < 465) {
                    if (oneX >= super.getMousePosition().getX() - 50 && oneX <= super.getMousePosition().getX() + 50) {
                        up = true;
                        down = false;
                        System.out.println("Collision Occured");
                    } else {
                        cScore++;
                        /*point = true;
                         oneY = 150;
                         oneX = 300;
                        
                         if(cScore == 21 || hScore == 21)
                         {
                         inGame = false;
                         }
                         /*try {
                         Thread.sleep(1000);
                         } catch (Exception e) {
                         System.out.println("Thread error");
                         }*/
                    }
                }
                if (oneY > 178 && oneY < 182 && rn.nextFloat() > lvlTmp) {
                   
                    if (oneX >= super.getMousePosition().getX() - 50 && oneX <= super.getMousePosition().getX() + 50) {
                        up = false;
                        down = true;
                        System.out.println("Collision Occured with computer");
                    } else {
                        hScore++;
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
                    incrementor = 7;

                } else if (oneY > 391 && oneY < 400) {
                    incrementor = 8;
                    //size = 25;
                } else {
                    incrementor = 5;
                    //size = 21;
                }
                if (oneY >= 100 && oneY < 220) {
                    System.out.println("Frame 1");
                    size = 18;
                    if (oneX < 330) {
                        right = true;
                        left = false;
                    }
                    if (oneX > 660) {
                        right = false;
                        left = true;
                    }
                    if (oneY < 120) {
                        up = false;
                        down = true;
                    }
                }
                if (oneY >= 220 && oneY < 320) {
                    System.out.println("Frame 2");
                    size = 20;
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
                    size = 22;
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
                    size = 25;
                    if (oneX < 120) {
                        right = true;
                        left = false;
                    }
                    if (oneX > 900) {
                        right = false;
                        left = true;
                    }
                    if (oneY > 530) {
                        up = true;
                        down = false;
                    }
                }
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
}
}
