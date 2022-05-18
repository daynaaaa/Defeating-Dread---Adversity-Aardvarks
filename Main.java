/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Main" class that runs the game
 *
 * Variables:
 *
 * Version #1 May 16 - May 20 - [2.5 hrs]:
 *    Danya - implemented if statements to decide what screen to show next
 *    
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
public class Main extends JPanel{
   /**the user's choice*/
	public char c;
   /**the current screen to be displayed*/
   public static JPanel current;
   /**the current frame*/
   public static JFrame frame;
   //public static Graphics2D graphics;
   /**
     * Initialize the JFrame
   */
   private static void initializeFrame() {
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Defeating Dread");
      frame.pack();
      frame.setSize(800, 500);
      //frame.setBounds(0, 0, 800, 500);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
   public static void main(String[] args)
  {

      Main m = new Main();
      frame = new JFrame();
      SwingUtilities.invokeLater(Main::initializeFrame);
      frame.setVisible(true);
      //JPanel panel = new JPanel();
      //panel.setBackground(Color.WHITE);
      //panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //panel.setLayout(new GridLayout(0, 1));
      
      /*
      SplashScreen splash = new SplashScreen();
      frame.add (splash);
      splash.play();
      current = splash;*/
      //System.out.println(frame.isVisible());
      while (m2.getC!=3) {
            //frame.remove(current);
            Menu m2 = new Menu();
            frame.add(m2);
            frame.setBackground(Color.WHITE);
            current = m2;
            if(m2.getC() == 1){
                           }
            else if(m2.getC() == 2){
            }
            else if(m2.getC() == 3){

               break;
            }
            //frame.setVisible (false);
      }
	}
}