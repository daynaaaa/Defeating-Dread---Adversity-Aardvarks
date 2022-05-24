/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Menu" class for the menu where the user can choose to play the game, go to instructions, or quit the game
 *
 * Version #1 May 16 - May 20 - [1 hr]:
 *    Mya - started the instructions screen with a back button
 *
 * Version #2 May 24 - May 27 - [1 hr]:
 *    Mya - finished the instructions screen with the text
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
        Color backgroundColour = new Color(46, 23, 110);
        setBackground(backgroundColour);
        g.setColor(Color.BLACK);
        g.fillRect(250, 330, 300, 80);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("Instructions", 150, 30);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString("Level 1: Deficiencies Room", 150, 70);
        g.drawString("In this level, you will learn about anxiety and how it might be affecting you.", 150, 90);
        g.drawString("Read and click through all of the information that will be provided", 150, 110);
        g.drawString("Level 2: Panic Room", 150, 130);
        g.drawString("In this level, you will be able to look at some possible tools that you can use", 150, 150);
        g.drawString("to defeat the monsters. You’ll get to see a lot of choices, but you can only pick", 150, 170);
        g.drawString("the 3 that you think will be the best for you. ", 150, 190);
        g.drawString("Look for the tools hidden on the screen and click on them to learn/equip", 150, 210);
        g.drawString("Use those tools to help you fight your anxiety in the form of monsters.", 150, 230);
        g.drawString("To use those tools, you will have to complete a task", 150, 250);
        g.drawString("Level 3: Escape Room", 150, 270);
        g.drawString("On this final level, you’ll be able to use your tools to help you defeat your anxiety,", 150, 290);
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("back", 330, 370);
    }
}