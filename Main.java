/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Main" class that runs the game
 *
 * Variables:
 *
 * Version #1 May 16 - May 20 - [1.5 hrs]:
 *    Danya - [modification] 
 *    
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
public class Main extends JPanel{
	public char c;
   /**the current screen to be displayed*/
   public static JPanel current;
   /**the current frame*/
   public static JFrame frame;
   //public static Graphics2D graphics;
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);  //canvas
      int w = getWidth();
      int h = getHeight();
      g.setColor(Color.RED);
      g.drawRect(w/4, h/4, w/2, h/2);  //rectangle is proportionate to canvas
      g.setColor(Color.BLUE);
      g.setFont(new Font("Serif", Font.PLAIN, 18));
      g.drawString("SUCCESS!", w/4 + 15, h/2 + 5);
   }
   /**
     * Initialize the JFrame
   */
   private static void frame() {
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Defeating Dread");
      frame.pack();
      frame.setVisible(true);
      frame.setSize(1000, 900);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
   }
   public static void main(String[] args)
  {

      Main m = new Main();
      SwingUtilities.invokeLater(Main::frame);

      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      //panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      panel.setLayout(new GridLayout(0, 1));
      
      /*
      SplashScreen splash = new SplashScreen();
      frame.add (splash);
      splash.play();
      current = splash;*/
      while (frame.isVisible()) {
            frame.remove(current);
            Menu m2 = new Menu();
            frame.add(m2);
            
            current = m2;
      }
	}
}