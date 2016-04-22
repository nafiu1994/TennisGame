package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Nafiu
 */
public class UsrInterface extends JFrame {
    private BckGrdnObj bck;
    private final int screenWidth;
    private final int screenHeight;
    private final int buttonWidth = 350;
    private final int buttonHeight = 50;
    private String lvl, snd, op;

    JButton Start, Options, Level, Sound, Exit;
    Choice levelOption, soundDropDown;

    public UsrInterface(int w, int h) {
        super("JFrame");
        setVisible(true);
        screenWidth = w;
        screenHeight = h;
        lvl = snd = "N/A";
        addButtons();
        addActions();
        getContentPane().setLayout(new BorderLayout());
        JLabel bg = new JLabel(new ImageIcon("images\\bck.jpg"));
        getContentPane().add(bg);

        bg.add(Start);
        bg.add(Options);
        bg.add(Level);
        bg.add(levelOption);
        bg.add(Sound);
        bg.add(soundDropDown);
        bg.add(Exit);

        pack();
        setLocation(0, 0);
        setSize(screenWidth, screenHeight);
        setTitle("Ultimate Table Tennis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }
    public String getOp(){
        return op;
    }
    public String getLevel(){
        return lvl;
    }
    public String getSound(){
        return snd;
    }
        

    public void addButtons() {
        Start = new JButton("New Game");
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
        soundDropDown.addItem("Sound ON");
        soundDropDown.addItem("Sound OFF");
        
        Start.setBounds((screenWidth - buttonWidth) / 2, 130, buttonWidth, buttonHeight);
        Options.setBounds((screenWidth - buttonWidth) / 2, 200, buttonWidth, buttonHeight);
        Options.setEnabled(false);
        Level.setBounds((screenWidth - buttonWidth) / 2 , 280, buttonWidth/2, 30);
        Level.setEnabled(false);
        levelOption.setBounds((screenWidth - buttonWidth) / 2 + buttonWidth/2 + 5 , 280, buttonWidth/2, 50);
        Sound.setBounds((screenWidth - buttonWidth) / 2 , 320, buttonWidth/2, 30);
        Sound.setEnabled(false);
        soundDropDown.setBounds((screenWidth - buttonWidth) / 2 + buttonWidth/2 + 5 , 320, buttonWidth/2, 50);
        Exit.setBounds((screenWidth - buttonWidth) / 2, 360, buttonWidth, buttonHeight);
        
        
    }

    public void addActions() {
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lvl = levelOption.getSelectedItem();
                snd = soundDropDown.getSelectedItem();
                op = "start";
                setVisible(false);
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = "exit";
                dispose();
            }
        });
    }
}
