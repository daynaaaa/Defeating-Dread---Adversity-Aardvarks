/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Main" class that runs the game
 *
 * Version #1 May 16 - May 20 - [2.5 hrs]:
 *    Danya - implemented if statements to decide what screen to show next
 *    Also made the quit button work
 * Version #2 May 24 - May 27 - [2 hrs]:
 *    Danya - added splash screen and l3
 *    fix problem with while loop
 * Version #3 June 2 - [1 hrs]:
 *    Danya - added level 2 and 3
 *    
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Main extends JPanel {
    /**the user's choice*/
    public static int c;
    /**the current screen to be displayed*/
    public static JPanel current;
    /**the current frame*/
    public static JFrame frame;
    /** This Graphics2D variable holds the graphics that are being drawn. */
    public static Graphics2D graphics;
    /**
     * initialize the frame
     */
    private static void initializeFrame() {
        frame = new JFrame("Defeating Dread");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setTitle("Defeating Dread");
        frame.pack();
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
     /**
     * Get the image from the file
     *
     * @param path image path
     * @return the image
     */
    public static BufferedImage imageFromFile(String path) {
        try {
            URL resource = Main.class.getClassLoader().getResource(path);
            if (resource == null) throw new NullPointerException();
            return ImageIO.read(resource);
        } catch (IOException | NullPointerException e) {
            System.err.println("There was an error retrieving " + path);

        }
        return null;
    }
    /**
     * Run the game
     */
    public static void main(String[] args) {

        Main m = new Main();
        frame = new JFrame();
        SwingUtilities.invokeLater(Main::initializeFrame);
        frame.setVisible(true);
        SplashScreen s = new SplashScreen();
        frame.add(s);
        s.start();
        current = s;
        m.c = 0;
        while (true) {
            frame.remove(current);
            frame.validate();
            frame.repaint();
            Menu m2 = new Menu();
            frame.add(m2);
            m2.updateC();
            current = m2;
            m.c = m2.getC();
            switch (m.c) {
                case 1:
                    //level 1
                    frame.remove(current);
                    Level1 l1 = new Level1();
                    frame.add(l1);
                    l1.start1();
                    current = l1;
                    frame.remove(current);
                    ConnectingScreen cs = new ConnectingScreen();
                    frame.add(cs);
                    cs.updateC();
                    current = cs;
                    if (cs.getC() == 1) {
                       //level 2
                       frame.remove(current);
                       Level2 l2 = new Level2();
                       frame.add(l2);
                       l2.start2();
                       ArrayList<Tool> cT = l2.returnChosenTools();
                       current = l2;
                       //level 3
                       frame.remove(current);
                       cs = new ConnectingScreen();
                       frame.add(cs);
                       cs.updateC();
                       current = cs;
                       if (cs.getC() == 1) {
                           frame.remove(current);
                           Level3 l3 = new Level3(cT);
                           frame.add(l3);
                           l3.start3();
                           current = l3;
                           //winning screen
                           frame.remove(current);
                           WinningScreen ws = new WinningScreen();
                           frame.add(ws);
                           ws.updateC();
                           current = ws;

                       }
                    }
                    break;
                case 2:
                    frame.remove(current);
                    Instructions i = new Instructions();
                    frame.add(i);
                    if (i.pressed()) m.c = 0;
                    current = i;
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
            }
        }
    }
}