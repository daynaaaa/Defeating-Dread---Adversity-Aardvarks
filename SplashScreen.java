/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 25, 2022
 * Desc: "SplashScreen" class that will run the splash screen when called
 * <p>
 * Version #1 May 25 - May 27 - [15 mins]:
 * Danya - framework and exiting
 * Version #1 May 25 - May 27 - [0.5 hrs]:
 * Mya - preliminaty animation
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
    Timer tm;
    /**
     * speed and stating x for animation
     */
    int x = 0, speed = 2;

    /**
     * animates the square/aardvark
     *
     * @param arg
     * @Override
     */
    public void actionPerformed(ActionEvent arg) {
        if(x<800) x += speed;
        else a=true;
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
        Color backgroundColour = new Color(46, 23, 110);
        setBackground(backgroundColour);
        g.setColor(new Color(159, 84, 43)); //brown like an aardvark hehe
        g.fillRect(x, 30, 50, 50);
        tm = new Timer(100, this);
        tm.start();
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
