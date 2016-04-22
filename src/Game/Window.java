package Game;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Nafiu
 */
public class Window extends JFrame {
//To change body of generated methods, choose Tools | Templates.

    private JFrame win = new JFrame("ULTIMATE TABLE TENNIS");
    private BckGrdnObj bck;
    private int width, height, buttonWidth = 350, buttonHeight = 50;

    private static enum Level {
        EASY, NORMAL, HARD
    }

    public Window(int w, int h) {
        width = w;
        height = h;
        win.setSize(width, height);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setAlwaysOnTop(true);
        win.setLocation(20, 0);
    }
    public void Home(){
        addButtons();
        win.setVisible(true);
    }
    
    public void Start() {
        
    }

    public void Gameplay() {
        
    }
    
    public void addButtons(){
        JButton Start, Options, Level, Sound, Exit;
        Choice levelOption, soundDropDown;
        Start = new JButton("New Game", new ImageIcon("images\\icon.jpg"));
        Exit = new JButton("End Game");
        Options = new JButton("Options");
        Level = new JButton("LEVEL");
        Sound = new JButton("SOUND");
        levelOption = new Choice();
        soundDropDown = new Choice();
        
        levelOption.setFont(new Font("Arial", Font.BOLD, 20));
        soundDropDown.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        Start.setForeground(Color.blue);
        Start.setBackground(new Color(243, 236,131));
        Options.setForeground(Color.blue);
        Options.setBackground(new Color(243, 236,131));
        Level.setForeground(Color.blue);
        Level.setBackground(new Color(243, 236,131));
        Exit.setBackground(new Color(243, 236,131));
        Exit.setForeground(Color.blue);
        levelOption.setBackground(new Color(243, 236,0));
        soundDropDown.setBackground(new Color(243, 236,0));
        
        levelOption.addItem("EASY");
        levelOption.addItem("MEDIUM");
        levelOption.addItem("HARD");
        soundDropDown.addItem("ON");
        soundDropDown.addItem("OFF");
        
        Start.setBounds((width - buttonWidth) / 2, 130, buttonWidth, buttonHeight);
       
        Options.setBounds((width - buttonWidth) / 2, 200, buttonWidth, buttonHeight);
        Options.setEnabled(false);
        Level.setBounds((width - buttonWidth) / 2 , 280, buttonWidth/2, 30);
        Level.setEnabled(false);
        levelOption.setBounds((width - buttonWidth) / 2 + buttonWidth/2 + 5 , 280, buttonWidth/2, 50);
        Sound.setBounds((width - buttonWidth) / 2 , 320, buttonWidth/2, 30);
        Sound.setEnabled(false);
        soundDropDown.setBounds((width - buttonWidth) / 2 + buttonWidth/2 + 5 , 320, buttonWidth/2, 50);
        Exit.setBounds((width - buttonWidth) / 2, 360, buttonWidth, buttonHeight);
        
        JLabel bg = new JLabel(new ImageIcon("images\\bck.jpg"));
        bg.add(Start);
        bg.add(Options);
        bg.add(Level);
        bg.add(levelOption);
        bg.add(Sound);
        bg.add(soundDropDown);
        bg.add(Exit);
        win.add(bg); 
    }
}//End of class
