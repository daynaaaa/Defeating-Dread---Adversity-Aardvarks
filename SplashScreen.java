/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 25, 2022
 * Desc: "SplashScreen" class that will run the splash screen when called
 *
 * Version #1 May 25 - May 27 - [15 mins]:
 *    Danya - framework
 *
 */

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SplashScreen extends JPanel{
    private volatile boolean a;
    public SplashScreen(){
         getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
         getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = true;
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
    }
    /**
     * update the graphics/start
     */
    public void start() {
        revalidate();
        repaint();
        while (!a);
    }

    
}
