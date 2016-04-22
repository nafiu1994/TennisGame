package Game;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Nafiu
 */
public class UsrInteract extends Canvas {

    Image bck;

    public UsrInteract() 
    {
        try {
            bck = ImageIO.read(new File("images\\bck.jpg"));
            System.out.println("UsrInteract class default contructor");
        } catch (IOException ex) {
            System.err.println("File not found...  " + ex);
        }
    }

    public void paint(Graphics g) {
        System.out.println("UsrInteract class paint component");
        String[] menu = {"START", "OPTIONS", "HELP", "EXIT"};
        g.drawImage(bck, 0, 0, 1000, 720, this);
        System.out.println("Draw");
        g.setFont(new Font("Sans-serif", Font.BOLD, 40));
        for (int i = 150, j = 0; i < 500; i += 100, j++) {
            g.setColor(Color.blue);
            g.fill3DRect(400, i, 300, 80, true);
            g.setColor(new Color(210, 70, 30));
            g.drawString(menu[j], 470, i + 50);
        }
    }

    /*public static void main(String[] args) {
        JFrame win = new JFrame("Test Frame");
        Box bx = Box.createVerticalBox();
        bx.add(new JButton("Exit"));
        JButton sB = new JButton("Start Game");
        bx.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getPoint());
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        bx.add(sB);
        win.add(bx);
        win.add(bx).setLocation(400, 300);
        win.setSize(1000, 720);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        try {
            win.setIconImage(ImageIO.read(new File("bat.png")));
        } catch (IOException ex) {
            Logger.getLogger(UsrInteract.class.getName()).log(Level.SEVERE, null, ex);
        }
        win.setAlwaysOnTop(true);
        //win.add(new UsrInteract());
        win.setVisible(true);
    }*/

}
