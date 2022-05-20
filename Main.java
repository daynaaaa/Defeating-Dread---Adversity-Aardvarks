/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Main" class that runs the game
 *
 * Version #1 May 16 - May 20 - [2.5 hrs]:
 *    Danya - implemented if statements to decide what screen to show next
 *    Also made the quit button work
 *    
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
public class Main extends JPanel{
   /**the user's choice*/
	public static int c;
   /**the current screen to be displayed*/
   public static JPanel current;
   /**the current frame*/
   public static JFrame frame;
   //public static Graphics2D graphics;
   /**
     * initialize the frame
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
   /**
     * Run the game
     */
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
      SplashScreen s = new SplashScreen();
      frame.add (s);
      s.play();
      current = s;*/
      m.c = 0;
      while (true) {
            //frame.remove(current);
            switch(m.c){
               case 0:
                  Menu m2 = new Menu();
                  frame.add(m2);
                  current = m2;
                  m.c = m2.getC();

               case 1:
                  break;
               case 2:
                  frame.remove(current);
                  Instructions i = new Instructions();
                  frame.add(i);
                  i.pressed();
                  current=i;
                  //System.out.println("a");
                  break;
               case 3:
                  System.exit(0);
                  break;
               default:
            }
        }
	}
}