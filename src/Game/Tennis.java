/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Nafiu
 */
public class Tennis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*SplashScreen s = new SplashScreen();
        s.setVisible(true);
        try {
            Thread.sleep(7500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        s.stop();*/
        Window wn = new Window(1000, 720);
        wn.Home();
    }
    
}
