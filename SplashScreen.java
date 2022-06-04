/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 25, 2022
 * Desc: "SplashScreen" class that will run the splash screen when called
 * <p>
 * Version #1 May 25 - May 27 - [15 mins]:
 * Danya - framework and exiting
 * Version #2 May 25 - May 27 - [0.5 hrs]:
 * Mya - preliminaty animation
 * Version #3 May 27 - June 3 - [0.5 hrs]:
 * Mya - fixed final animation and stylistic changes
 */

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SplashScreen extends JPanel implements ActionListener {
    /**
     * if the splash screen is over
     */
    private volatile boolean a;
    /**
     * timer for animation
     */
    Timer tm = new Timer(100, this);

    /**
     * speed and stating x for animation
     */
    int x = 0, speed = 25;

    /**
     * animates the square/aardvark
     *
     * @param arg
     * @Override
     */
    public void actionPerformed(ActionEvent arg) {
        if (x < 800) x += speed;
        else a = true;
        repaint();
    }

    /**
     * runs the splashscreen
     */
    public SplashScreen() {
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color backgroundColour = new Color(113, 189, 217);
        setBackground(backgroundColour);
        g.setColor(Color.GREEN);
        g.fillRect(0, 400, 800, 100);
        g.setColor(new Color(159, 84, 43)); //brown like an aardvark hehe
        g.fillOval(x, 360, 70, 70);
        tm.start();
        g.setColor(Color.ORANGE);
        g.fillOval(700, -50, 200, 200);

    }

    /**
     * update the graphics/start
     */
    public void start() {
        revalidate();
        repaint();
        while (!a) ;
    }


}
