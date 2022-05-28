/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 24, 2022
 * Desc: "Level3" class that will run the last level when called
 *
 * Version #1 May 24 - May 27 - [1 hrs]:
 *    Danya - added messages, which the user can go through by pressing space
 *
 */

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Level3 extends JPanel{
    /**
     * monster
     */
    Monster monster;
    /**
     * chosen tools - made from collectTools method
     */
    ArrayList <Tool> chosenTools;
    /** Text message*/
    ArrayList <String> message;
    /** If the level has ended */
    private volatile boolean end;
    /** Variable to control the storyline*/
    private int count;
    /**
     * constructor
     *
     */
    //public Level3( ArrayList<Tool> cT) {
    public Level3() {
         end = false;
         getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
         getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("hi");
                count++;
                repaint();
            }
         });

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
        //System.out.println(end);
        switch(count){
            case 1:
               System.out.println("It's getting pretty dark out here...");
               break;
            case 2:
               System.out.println("Now that you have chosen your tools, it is time to make your way out of this forest, but watch out for the monsters! Click on each tool to use them on the monsters.");
               break;
            case 3:
               System.out.println("Good luck! I won’t be able to help you anymore, but I believe in you!");
               break;
            case 4:
               break;
            
            case 5:
               System.out.println("You win!");
               end = true;
               break;
            default:
            
        }
    }
    /**
     * update the graphics
     */
    public void start3() {
        revalidate();
        repaint();
        while (!end);
    }
    
}
