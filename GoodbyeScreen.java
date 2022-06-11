/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: June 10, 2022
 * Desc: "GoodbyeScreen" class that will run the goodbye screen when called
 * <p>
 * Version #1 June 10 - [15 mins]:
 * Danya - framework
 */

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoodbyeScreen extends JPanel implements ActionListener {
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
    int x = 800, speed = 25;


    /**
     * animates the square/aardvark
     *
     * @param arg
     * @Override
     */
    public void actionPerformed(ActionEvent arg) {
        if (x > -100) x -= speed;
        else a = true;
        repaint();
    }

    /**
     * runs the GoodbyeScreen
     */
    public GoodbyeScreen() {
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
        Color backgroundColour = new Color(159, 204, 222);
        setBackground(backgroundColour);
        g.setColor(new Color(133, 189, 92));
        g.fillRect(0, 400, 800, 100);
        g.drawImage(Main.imageFromFile("adverbNobackground.png").getScaledInstance(100, -1, Image.SCALE_DEFAULT), x, 360, this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g.drawString("Goodbye! Thanks for playing Defeating Dread!", 30, 100);
        g.drawString("Programmed and drawn by Danya, Mya, and Sulagna", 30, 130);
        g.drawString("(Adversity Aardvarks)", 30, 160);

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