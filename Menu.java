/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Menu" class for the menu where the user can choose to play the game, go to instructions, or quit the game
 *
 * Variables:
 *
 * Version #1 May 16 - May 20 - [1 hr]:
 *    [author] - [modification] 
 *    
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
public class Menu {
	public static char c;
	public Menu() {
		c = '0';
	}
	public static char getC() {
		return c;
	}
	public static void runMenu() {
		Menu m = new Menu();
      Scanner in = new Scanner(System.in);
		System.out.println("DEFEATING DREAD");
		System.out.println("A game brought to you by:\nAdversity Aardvarks");
		System.out.println("Play Game\nInstructions\nQuit");
		while(true) {
			try {
				c = in.next().charAt(0);
				if(c < 49 || c > 51){
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