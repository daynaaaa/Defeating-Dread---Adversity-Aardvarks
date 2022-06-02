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
import java.util.ArrayList;

public class Level2 extends JPanel {
    /**
     * monster
     */
    Monster monster;
    /**
     * available tools - made from constructor
     */
    ArrayList<Tool> availableTools = new ArrayList<>();
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

        availableTools.add(new Tool("dagger", "of deep breaths", daggerInfo, 5, Color.BLACK, 100, 100));
        availableTools.add(new Tool("cloak", "of something (cloak placeholder)", daggerInfo, 5, Color.BLUE, 300, 200));
        availableTools.add(new Tool("potion", "of something (potion placeholder)", daggerInfo, 5, Color.PINK, 200, 300));
        availableTools.add(new Tool("net", "of something (net placeholder)", daggerInfo, 5, Color.GRAY, 300, 300));

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
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                System.out.println(x + " in main " + y);
                collectTool(x, y);
            }
        });
    }

    private void collectTool(int x, int y) {
        Tool selectedTool = clickedInAvailableTool(x,y);
        if (selectedTool != null) {
            // collect it
            availableTools.remove(selectedTool);
            chosenTools.add(selectedTool);
            if (chosenTools.size()==3) {
                // move to the next screen
                count++;
            }
            // redraw to reflect the currently available tools
            repaint();
        }
    }

    private Tool clickedInAvailableTool(int x, int y) {
        for (Tool t : availableTools) {
            if (x >= t.getxCord() && x <= (t.getxCord()+t.getxSize()) &&
                y >= t.getyCord() && y <= (t.getyCord()+t.getySize())) {
                // we have hit the tool
                return t;
            }
        }
        return null;
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
                drawAvailableTools(g);
                break;
            case 4:
                displayChosenTools(g);
                break;
            case 5:
                g.drawString("good going! next level...", 100, 100);
                break;

            case 6:
                end = true;
                break;

            default:

        }
    }

    private void displayChosenTools(Graphics g) {
        g.drawString("The tools you have chosen are:", 100, 120);
        int drawStringY=150;
        for (Tool t : chosenTools) {
            g.drawString(t.getName()+", ", 100, drawStringY);
            drawStringY+=20;
        }
    }

    private void drawAvailableTools(Graphics g) {
        for (Tool t : availableTools) {
            g.setColor(t.getColor());
            g.fillRect(t.getxCord(), t.getyCord(), t.getxSize(), t.getySize());
            g.drawString(t.getName(), t.getxCord(), t.getyCord());
        }
    }


    /**
     * takes the arraylist given and returns the first item
     * will eventually take user input to add chosen tools
     */
    public void collectTools(Graphics g) {
        g.drawString("collecting tools:", 20, 100);

        while (chosenTools.size() < 3) {
            repaint();
            x= getMousePosition().x;
            y= getMousePosition().y;


            if (x >= 100 && x <= 150) {
                chosenTools.add(availableTools.remove(0));
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
    
    /**
     * @return chosenTools
     */
    public ArrayList<Tool> returnChosenTools(){
        return chosenTools;
    }


}







