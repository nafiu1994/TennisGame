package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nafiu
 */
public class SplashScreen extends JFrame{
    private JLabel imgLabel;
    private static JProgressBar pBar;
    public SplashScreen()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        imgLabel = new JLabel(new ImageIcon("images\\splash.jpg"));
        imgLabel.setBounds(0, 0, 404, 310);
        pBar = new JProgressBar();
        pBar.setStringPainted(true);
        pBar.setForeground(Color.GREEN);
        pBar.setPreferredSize(new Dimension(310, 30));
        pBar.setBounds(0, 290, 400,300);
        
        setTitle("ULTIMATE TABLE TENNIS");
        setSize(400,300);
        setUndecorated(true);
        setLocation(screenSize.width/ 2 - 200, screenSize.height/ 2 - 150);
        setLayout(null);
        add(pBar);
        add(imgLabel);
        setAlwaysOnTop(true);
        Thread t = new Thread(){
            public void run(){
                int i = 0;
                while(i < 100){
                    pBar.setValue(i);
                    try{
                        sleep(90);
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        };
        t.start();   
    }
    public void stop() {
        dispose();
    }
}
