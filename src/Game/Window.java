package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Nafiu
 */
public class Window extends JFrame {
//To change body of generated methods, choose Tools | Templates.

    private JFrame win = new JFrame("ULTIMATE TABLE TENNIS");
    private BckGrdnObj play;
    private int width, height, buttonWidth = 350, buttonHeight = 50;
    private JButton Start, Options, Level, Sound, Exit;
    private Choice levelOption, soundDropDown;
    private String lvl, snd, op;
    private JLabel bg;

    public Window(int w, int h) {
        width = w;
        height = h;
        win.setSize(width, height);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setAlwaysOnTop(true);
        win.setLocation(20, 0);
        bg = new JLabel(new ImageIcon("images\\bck.jpg"));
        try {
            play = new BckGrdnObj();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Home() {
        addButtons();
        addActions();
        win.setVisible(true);
    }

    public void Start() {

    }

    public void Gameplay() {
        System.out.println("GamePlay");
        win.setVisible(false);
        win.remove(bg);
        play.setLvl(lvl);
        win.add(play);
        //win.validate();
        //win.repaint();
        win.setVisible(true);
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
        Start.setBackground(new Color(243, 236, 131));
        Options.setForeground(Color.blue);
        Options.setBackground(new Color(243, 236, 131));
        Level.setForeground(Color.blue);
        Level.setBackground(new Color(243, 236, 131));
        Exit.setBackground(new Color(243, 236, 131));
        Exit.setForeground(Color.blue);
        levelOption.setBackground(new Color(243, 236, 0));
        soundDropDown.setBackground(new Color(243, 236, 0));

        levelOption.addItem("EASY");
        levelOption.addItem("MEDIUM");
        levelOption.addItem("HARD");
        soundDropDown.addItem("ON");
        soundDropDown.addItem("OFF");

        Start.setBounds((width - buttonWidth) / 2, 130, buttonWidth, buttonHeight);
        Options.setBounds((width - buttonWidth) / 2, 200, buttonWidth, buttonHeight);
        Options.setEnabled(false);
        Level.setBounds((width - buttonWidth) / 2, 280, buttonWidth / 2, 30);
        Level.setEnabled(false);
        levelOption.setBounds((width - buttonWidth) / 2 + buttonWidth / 2 + 5, 280, buttonWidth / 2, 50);
        Sound.setBounds((width - buttonWidth) / 2, 320, buttonWidth / 2, 30);
        Sound.setEnabled(false);
        soundDropDown.setBounds((width - buttonWidth) / 2 + buttonWidth / 2 + 5, 320, buttonWidth / 2, 50);
        Exit.setBounds((width - buttonWidth) / 2, 360, buttonWidth, buttonHeight);

        bg.add(Start);
        bg.add(Options);
        bg.add(Level);
        bg.add(levelOption);
        bg.add(Sound);
        bg.add(soundDropDown);
        bg.add(Exit);
        win.add(bg);
    }// end of addButtons

    public void addActions() {
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lvl = levelOption.getSelectedItem();
                snd = soundDropDown.getSelectedItem();
                op = "start";
                System.out.println("Start clicked");
                Gameplay();

            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = "exit";
                System.out.println("Exit clicked");
            }
        });
    }
}//End of class
