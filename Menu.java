/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Menu" class for the menu where the user can choose to play the game, go to instructions, or quit the game
 * <p>
 * Version #1 May 16 - May 20 - [3 hr]:
 * Danya - added mouse listener to keep track of where the user clicks
 * figured out the points that buttons would need to be in, and implemented the buttons
 * added text
 * Version #2 May 25 - [1 hr]:
 * Danya - added a method to update the graphics
 * Version #3 June 3-10
 * Mya - added in backgrounds and logo
 */

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel {
    /**
     * the user's choice
     */
    private int c;
    /**
     * whether the user has made a choice or not
     */
    private volatile boolean isChosen;
    /**
     * the x value of the point the user clicks on
     */
    private int x;
    /**
     * the y value of the point the user clicks on
     */
    private int y;

    /**
     * Constructor for the Menu class
     * Implements the mouse listener
     */
    public Menu() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                //if buttons stuff
                if (x >= 250 && x <= 550) {
                    if (y >= 150 && y <= 230) {
                        c = 1;
                        isChosen = true;
                        repaint();
                    } else if (y >= 240 && y <= 320) {
                        c = 2;
                        isChosen = true;
                        repaint();
                    } else if (y >= 330 && y <= 410) {
                        c = 3;
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
        g.drawImage(Main.imageFromFile("adversityNEW.png").getScaledInstance(100, -1, Image.SCALE_DEFAULT), 25, 380, this);
        g.fillRect(250, 150, 300, 80);
        g.fillRect(250, 240, 300, 80);
        g.fillRect(250, 330, 300, 80);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", Font.BOLD, 33));
        g.drawString("DEFEATING DREAD", 250, 30);
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g.drawString("A game brought to you by:", 250, 70);
        g.drawString("Adversity Aardvarks", 290, 100);
        g.drawString("play game", 330, 190);
        g.drawString("instructions", 330, 280);
        g.drawString("quit", 330, 370);
    }
}
