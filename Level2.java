/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Level2" class that will run the second level when called
 * <p>
 * Version #1 May 16 - May 20 - [0.5 hrs]:
 * Mya - created preliminary Level2 class with some methods
 * Does not draw anything
 * Calls Tools(String, String, String, int), Monster(int, int), and Talk(ArrayList <String>)
 * <p>
 * Version #1 May 20 - May 27 - [5 hrs]:
 * Mya - add in some text
 * try to add in mouse listener
 * try to add in first activity - will continue next week
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.util.ArrayList;

public class Level2 extends JPanel {
    /**
     * monster
     */
    Monster monster;
    /**
     * all tools - made from constructor
     */
    ArrayList<Tool> allTools = new ArrayList<>();
    /**
     * chosen tools - made from collectTools method
     */
    ArrayList<Tool> chosenTools = new ArrayList<>();
    /**
     * Text message
     */
    ArrayList<String> message = new ArrayList<>();
    /**
     * If the level has ended
     */
    private volatile boolean end;
    /**
     * Variable to control the storyline
     */
    private int count;
    /**
     * ints store x and y coordinates of mouse
     */
    private int x=0, y=0;

    /**
     * constructor
     */
    //public Level2( ArrayList<Tool> cT) {
    public Level2() {
        end = false;
        ArrayList<String> daggerInfo = new ArrayList<>();
        daggerInfo.add("of deep breaths");
        daggerInfo.add("Deep breathing can help you control your anxiety");
        daggerInfo.add("Deep breathing tells your nervous system to relax");
        daggerInfo.add("To use this tool, practice some deep breathing");
        daggerInfo.add("In…2….3….4…. Out…2…3…4…");

        allTools.add(new Tool("dagger", "of deep breaths", daggerInfo, 5, Color.BLACK, 100, 100));
        allTools.add(new Tool("cloak", "of something (cloak placeholder)", daggerInfo, 5, Color.BLUE, 300, 200));
        allTools.add(new Tool("potion", "of something (potion placeholder)", daggerInfo, 5, Color.PINK, 200, 300));
        allTools.add(new Tool("net", "of something (net placeholder)", daggerInfo, 5, Color.GRAY, 300, 300));

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("hi");
                count++;
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                System.out.println(x + " in main " + y);
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
        //System.out.println(end);
        g.setColor(Color.WHITE);
        switch (count) {
            case 0:
                g.drawString("level 2:", 100, 100);
                break;
            case 1:
                g.drawString("look around the room for tools that you can use to help", 100, 100);
                break;
            case 2:
                g.drawString("click on them to see what they do and equip them", 100, 100);
                break;
            case 3:
                collectTools(g);
                break;

            case 4:
                g.drawString("good going!", 100, 100);
                end = true;
                break;
            default:

        }
    }

    /**
     * takes the arraylist given and returns the first item
     * will eventually take user input to add chosen tools
     */
    public void collectTools(Graphics g) {
        g.drawString("collecting tools:", 20, 100);
        ArrayList<Tool> collected = new ArrayList<>();
        collected.add(allTools.remove(0));

        while (chosenTools.size() < 3) {
            repaint();
            System.out.println(x+" in while "+y);
            x= getMousePosition().x;
            y= getMousePosition().y;

            for (Tool t : allTools) {
                g.setColor(t.getColor());
                g.fillRect(t.getxCord(), t.getyCord(), t.getxSize(), t.getySize());
                g.drawString(t.getName(), t.getxCord(), t.getyCord());
            }

            if (x >= 100 && x <= 150) {
                allTools.add(allTools.get(0));
                g.drawString("item " + chosenTools.get(0).getName() + " has been chosen", 200, 100);
            }
        }
    }

    /**
     * update the graphics
     */
    public void start2() {
        revalidate();
        repaint();
        while (!end) ;
    }


}







