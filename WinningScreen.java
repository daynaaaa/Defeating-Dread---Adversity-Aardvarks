import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: June 9, 2022
 * Desc: "WinningScreen" to be used when the player finishes all three levels
 * <p>
 * Version #1 June 9 - [1 hr]:
 * Danya - framework
 */
public class WinningScreen extends JPanel {
    /**whether the user has made a choice or not*/
    private volatile boolean isChosen;

    /**
     * Constructor for the WinningScreen class
     * Implements the mouse listener
     */
    public WinningScreen() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (x >= 250 && x <= 550) {
                    if (y >= 150 && y <= 230) {
                        isChosen = true;
                        repaint();
                    }
                }
            }
        });
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
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", Font.BOLD, 33));
        g.drawString("DEFEATING DREAD", 250, 30);
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g.drawString("You have beat all 3 levels of the game!", 150, 70);
        g.drawString("CONGRATULATIONS!", 290, 100);
        g.drawString("Continue", 330, 190);
    }

}