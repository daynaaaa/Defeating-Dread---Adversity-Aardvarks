/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Level1" class that will run the first level when called
 * <p>
 * Version #2 May 16 - May 20 - [0.5 hrs]:
 * Sulagna - created preliminary Level1 class with some methods
 * Does not draw anything
 * Calls Talk(ArrayList<String>)
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Level1 extends JPanel {

    private ArrayList<String> lesson;

    public Level1() {
//		lesson = new ArrayList<String>();
//		fillArrayList();
//		addMouseListener (new MouseAdapter(){
//			public void mousePressed (MouseEvent e) {
//				int x = e.getX();
//				int y = e.getY();
//				System.out.println(x+" "+y);
//				//if buttons stuff
//				if(x>=250&&x <=550){
//					if(y>=150&&y<=230){
//						repaint();
//					}
//				}
//			}
//		});
        //repaint();
    }

    /**
     * Draw the graphics
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color backgroundColour = new Color(6, 115, 113);
        setBackground(backgroundColour);
        g.setColor(new Color(0, 22, 0));
        g.fillOval(50, 50, 50, 100);
    }

    private void fillArrayList() {
        lesson.add("");
        lesson.add("");
        lesson.add("");

        lesson.add("");
        lesson.add("");
        lesson.add("");

        lesson.add("");
        lesson.add("");
        lesson.add("");
    }

    public void showAllText() {
        Talk t = new Talk(lesson);
        t.talking();
    }

    public static void main(String[] hallo) {
        Level1 l1 = new Level1();
        JFrame f = new JFrame("hallooo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l1);
        f.pack();
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
