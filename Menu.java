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
public class Menu extends JPanel{
	public char c;
	public Menu() {
		c = '0';
	}
	public char getC() {
		return c;
	}
   /**
     * 
     *
     * @param g the graphics to be drawn
     */
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      int x0 = 40;
      int y0 = 40;
      g.setColor(Color.BLACK);
      g.drawRect(x0 - 15, y0, 30, 20);
      g.drawOval(x0 - 10, y0 - 20, 20, 20);
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