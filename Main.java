/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Main" class that runs the game
 *
 * Variables:
 *
 * Version #1 May 16 - May 20 - [30 mins]:
 *    [author] - [modification] 
 *    
 */
 import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
public class Main extends JPanel{
	public static char c;
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
	public static void main(String[]args) {
		Main m = new Main();
      /*JFrame window = new JFrame("Drawings");
       window.setBounds(100, 100, 300, 200);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel canvas = new Main();
       canvas.setBackground(Color.WHITE);
       window.getContentPane().add(canvas);
       window.setVisible(true);
*/
		//runMenu();
      //c = getC();
	}
}