/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Menu" class for the menu where the user can choose to play the game, go to instructions, or quit the game
 *
 * Version #1 May 16 - May 20 - [1 hr]:
 *    Mya -
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Instructions extends JPanel {
    /**
     * if the back button is pressed
     */
    private boolean pressed =false;
    /**the x value of the point the user clicks on*/
    private int x;
    /**the y value of the point the user clicks on*/
    private int y;
    /**
     * Constructor for the Menu class
     * Implements the mouse listener
     */
    public Instructions() {
        addMouseListener (new MouseAdapter(){
            public void mousePressed (MouseEvent e) {
                x = e.getX();
                y = e.getY();
                //if buttons stuff
                if(x>=250&&x <=550&&y>=150&&y<=230) pressed=true;
                repaint();
            }
        });
    }
    /**
     * exit when the back button is pressed
     * @return the boolean value of pressed
     */
    public boolean pressed() {
        revalidate();
        repaint();
        while (!pressed);
        return pressed;
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
        Color backgroundColour = new Color(255, 62, 158);
        setBackground(backgroundColour);
        g.setColor(Color.BLACK);
        g.fillRect(250, 150, 300, 80);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("instructions", 150, 30);
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("back", 330, 190);
        //(string, x, y);
        //if(b)g.fillOval(x - 1, y - 1, 3, 3);
    }
}
