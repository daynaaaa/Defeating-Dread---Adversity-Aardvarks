/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Menu" class for the menu where the user can choose to play the game, go to instructions, or quit the game
 *
 * Version #1 May 16 - May 20 - [3 hr]:
 *    Danya - added mouse listener to keep track of where the user clicks
 *    figured out the points that buttons would need to be in, and implemented the buttons
 *    added text
 *    
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu extends JPanel{
   /**the user's choice*/
	public static int c;
   /**the x value of the point the user clicks on*/
   public int x;
   /**the y value of the point the user clicks on*/
   public int y;
   /**
     * Constructor for the Menu class
     * Implements the mouse listener
     */
	public Menu() {
      addMouseListener (new MouseAdapter(){
            public void mousePressed (MouseEvent e) {
               x = e.getX();
               y = e.getY();
               //System.out.println(x+" "+y);
               //if buttons stuff
               if(x>=250&&x <=550){
                  if(y>=150&&y<=230)c = 1;
                  else if(y>=240&&y<=320)c = 2;
                  else if(y>=330&&y<=410)c = 3;
               }
               repaint();
            }
      });
	}
   /**
     * Get the choice
     *
     * @return the int value of c
     */
	public int getC() {
		return this.c;
	}
   /**
     * Draw the graphics
     *
     * @param g the graphics to be drawn
     */
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Color backgroundColour = new Color(46, 23, 110);
      setBackground(backgroundColour);
      g.setColor(Color.BLACK);
      g.fillRect(250, 150, 300, 80);
      g.fillRect(250, 240, 300, 80);
      g.fillRect(250, 330, 300, 80);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Serif", Font.BOLD, 30));
      g.drawString("DEFEATING DREAD", 250, 30);
      g.setFont(new Font("SansSerif", Font.BOLD, 20));
      g.drawString("A game brought to you by:", 270, 70);
      g.drawString("Adversity Aardvarks", 290, 100);
      g.drawString("play game", 330, 190);
      g.drawString("instructions", 330, 280);
      g.drawString("quit", 330, 370);
      //(string, x, y);
      //if(b)g.fillOval(x - 1, y - 1, 3, 3);
   }
}