/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Level2" class that will run the second level when called
 *
 * Version #1 May 16 - May 20 - [0.5 hrs]:
 *      Mya - created preliminary Level2 class with some methods
 *      Does not draw anything
 *      Calls Tools(String, String, String, int), Monster(int, int), and Talk(ArrayList <String>)
 *
 * Version #1 May 20 - May 27 - [4 hrs]:
 *      Mya - add in some text
 *      try to add in mouse listener
 *      try to add in first activity - will continue next week
 *
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
    private int x, y;
    /**
     * if the tool has been clicked
     */
    private boolean beenClicked=false;

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
        allTools.add(new Tool("cloak", "of something (cloack placeholder)", daggerInfo, 5, Color.BLUE, 300, 200));
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
    }

    /**
     * should check if the mouse is clicking in a certain spot but isn't working how it should
     * @param mouseX x coordinate of place to check
     * @param mouseY y coordinate of place to check
     * @param length how far it should check (past the x cooridnate given)
     * @param height how far it should check (past the y cooridnate given)
     * @return if the area is pressed
     */
    public boolean mouseClicked(int mouseX, int mouseY, int length, int height) {
        beenClicked=false;
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                while(!beenClicked) {
                    if (e.getX() >= mouseX && e.getX() <= mouseX + length && e.getY() >= mouseY && e.getY() <= mouseY + height)
                        beenClicked = true;
                }
            }
        });
        return beenClicked;
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
        switch (count) {
            case 1:
                System.out.println("level 2:");
                break;
            case 2:
                System.out.println("look around the room for tools that you can use to help");
                break;
            case 3:
                System.out.println("click on them to see what they do and equip them");
                break;
            case 4:
                for (Tool t : allTools) {
                    g.setColor(t.getColor());
                    g.drawRect(t.getxCord(), t.getyCord(), 50, 50);
                }
                if(mouseClicked(allTools.get(0).getxCord(), allTools.get(0).getyCord(), 10, 10)){
                    System.out.println(allTools.get(0).getName());
                }
                break;

            case 5:
                System.out.println("good going!");
                end = true;
                break;
            default:

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

    /**
     * takes the arraylist given and returns the first item
     * will eventually take user input to add chosen tools
     *
     * @return the three tools needed for the next step
     */
    public ArrayList<Tool> collectTools() {
        System.out.println("collecting tools:\n");
        ArrayList<Tool> collected = new ArrayList<>();
        collected.add(allTools.remove(0));
        return collected;
    }
}
