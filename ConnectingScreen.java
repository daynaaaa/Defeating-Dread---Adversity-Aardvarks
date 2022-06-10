/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "ConnectingScreen" to be used between the levels
 * <p>
 * Version #1 May 30 - June 3 - [1 hr]:
 * Danya - framework
 * Version #2 June 3-10 [15 minutes]
 * Mya - Final touch-ups
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConnectingScreen extends JPanel {
    /**
     * whether the user has made a choice or not
     */
    private volatile boolean isChosen;
    /**
     * the user's choice
     */
    int c;

    /**
     * Constructor for the ConnectingScreen class
     * Implements the mouse listener
     */
    public ConnectingScreen() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (x >= 250 && x <= 550) {
                    if (y >= 150 && y <= 230) {
                        c = 1;
                        isChosen = true;
                        repaint();
                    } else if (y >= 240 && y <= 320) {
                        c = 2;
                        isChosen = true;
                        repaint();
                    }
                }
            }
        });
    }

    /**
     * Get the choice
     *
     * @return the int value of c
     */
    public int getC() {
        return c;
    }

    /**
     * update the graphics until user makes a choice
     */
    public void updateC() {
        repaint();
        revalidate();
        while (!isChosen) ;
    }

    /**
     * Draw the graphics
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Main.imageFromFile("backgroundmenu.jpg"), 0, 0, null);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(250, 150, 300, 80);
        g.fillRect(250, 240, 300, 80);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", Font.BOLD, 33));
        g.drawString("DEFEATING DREAD", 250, 30);
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g.drawString("A game brought to you by:", 250, 70);
        g.drawString("Adversity Aardvarks", 290, 100);
        g.drawString("continue", 330, 190);
        g.drawString("quit", 330, 280);
    }

}
