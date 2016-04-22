package Game;

import javax.swing.JFrame;

/**
 *
 * @author Nafiu
 */
public class Window extends JFrame {
//To change body of generated methods, choose Tools | Templates.

    private JFrame win = new JFrame("ULTIMATE TABLE TENNIS");
    private BckGrdnObj bck;

    private static enum Level {
        EASY, NORMAL, HARD
    }

    public Window(int h, int w) {
        win.setSize(h, w);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setAlwaysOnTop(true);
        win.setLocation(20, 0);
    }
    public void Home(){
        
    }
    
    public void Start() {
        
    }

    public void Gameplay() {
        
    }
}//End of class
