/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 24, 2022
 * Desc: "Level3" class that will run the last level when called
 *
 * Version #1 May 24 - May 27 - [_ hrs]:
 *    Danya - 
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
    /**
     * Text message
     */
    ArrayList <String> message;
    /** If the level has ended */
    private volatile boolean end;
    /**
     * constructor
     *
     * @param m calls super with text
     * @param cT chosen tools stored
     */
    public Level3(ArrayList<String> m, ArrayList<Tool> cT) {
        message=m;
        chosenTools=cT;
    }
    public Level3() {
         end = false;
         getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
         getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi");
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
        System.out.println(end);
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
