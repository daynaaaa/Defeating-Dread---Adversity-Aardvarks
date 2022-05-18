/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Menu" class for the menu where the user can choose to play the game, go to instructions, or quit the game
 *
 * Variables:
 *
 * Version #1 May 16 - May 20 - [2 hr]:
 *    Danya - [modification] 
 *    
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu extends JPanel{
	public char c;
   public int x;
   public int y;
   public boolean b = false;
	public Menu() {
		c = '0';
      addMouseListener (new MouseAdapter(){
            public void mousePressed (MouseEvent e) {
               x = e.getX();
               y = e.getY();
               System.out.println(x+" "+y);
               //if buttons stuff
               b = true;
               repaint();
            }
      });
	}
	public char getC() {
		return c;
	}
   /*public void mousePressed(MouseEvent e)
   {

      x = e.getX();
      y = e.getY();
      System.out.println(x+" "+y);
      //if buttons stuff
      b = true;
      repaint();
   }
   /**not used*
   public void mouseClicked(MouseEvent e) {}
   public void mouseReleased(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   */
   /**
     * 
     *
     * @param g the graphics to be drawn
     */
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      setBackground(Color.WHITE);
      if(b)g.fillOval(x - 1, y - 1, 3, 3);
      g.setFont(new Font("Serif", Font.BOLD, 30));
      g.drawString("DEFEATING DREAD", 250, 30);
      g.setFont(new Font("SansSerif", Font.BOLD, 20));
      g.drawString("A game brought to you by:", 250, 70);
      g.drawString("Adversity Aardvarks", 250, 100);
      //(string, x, y);

   }
	public static void runMenu() {
		Menu m = new Menu();
      Scanner in = new Scanner(System.in);
		System.out.println("DEFEATING DREAD");
		System.out.println("A game brought to you by:\nAdversity Aardvarks");
		System.out.println("Play Game\nInstructions\nQuit");
		while(true) {
			try {
				m.c = in.next().charAt(0);
				if(m.c < 49 || m.c > 51){
					throw new IllegalArgumentException();
				}
            else break;
			} 
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Please enter an integer between 1-3");

			}
		}
		
	}

}