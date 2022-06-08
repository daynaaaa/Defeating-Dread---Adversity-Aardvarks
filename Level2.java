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
 * Version #2 May 20 - May 27 - [5 hrs]:
 * Mya - add in some text
 * try to add in mouse listener
 * try to add in first activity - will continue next week
 * <p>
 * Version #3 May 27 - June 3 - [5 hrs]:
 * Mya - added in tools and mouse actions
 * brought text to screen
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
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
    private int x = 0, y = 0;
    /**
     * checks if dialogue is playing
     */
    private boolean isDialogue;

    /**
     * constructor
     */
    //public Level2( ArrayList<Tool> cT) {
    public Level2() {
        end = false;
        isDialogue = true;
        ArrayList<String> daggerInfo = new ArrayList<>();
        daggerInfo.add("Deep breathing can help you control your anxiety");
        daggerInfo.add("Deep breathing tells your nervous system to relax");
        daggerInfo.add("To use this tool, practice some deep breathing");
        daggerInfo.add("In...2...3...4... Out...2...3...4... ");

        ArrayList<String> sceptreInfo = new ArrayList<>();
        sceptreInfo.add("At school, there are counsellors and administrators trained to help you");
        sceptreInfo.add("spot the roots of your anxiety and give you a range of strategies to deal with them.");
        sceptreInfo.add("It may be scary at first, but they are there for you and it is definitely worth a try.");
        sceptreInfo.add("To use this tool, identify some people who are there to support you.");
        sceptreInfo.add("Come up with 3 people around you who are ready to help");

        ArrayList<String> cloakInfo = new ArrayList<>();
        cloakInfo.add("Communicating with your parents, teachers, and friends is key to reducing your anxiety.");
        cloakInfo.add("Telling them about your difficulties can help them help you identify");
        cloakInfo.add("the stressors in your life and take steps to working through them.");
        cloakInfo.add("To use this tool, message a friend and ask them how they are feeling.");
        cloakInfo.add("Continue when you have sent a friend a message to let them know you are there");

        ArrayList<String> elixirInfo = new ArrayList<>();
        elixirInfo.add("Develop a routine to be physically active throughout the week.");
        elixirInfo.add("Exercise can improve your mood.");
        elixirInfo.add("To use this tool, do 10 jumping jacks and note how you feel before/after.");
        elixirInfo.add("Continue when you finish");

        ArrayList<String> javelinInfo = new ArrayList<>();
        javelinInfo.add("Journaling can help you identify what's causing you stress.");
        javelinInfo.add("Putting your feelings in words can help you feel better.");
        javelinInfo.add("To use this tool, write down something you’ve been feeling.");
        javelinInfo.add("Continue when you finish");

        ArrayList<String> swordInfo = new ArrayList<>();
        swordInfo.add("Make sure sleep is a priority and that you feel rested.");
        swordInfo.add("You can talk with your doctor if you aren't sleeping well.");
        swordInfo.add("To use this tool, plan out a full night of sleep.");
        swordInfo.add("Continue when you calculate the time you will have go to bed.");
        swordInfo.add("tonight to get the recommended 8-10 hours");

        ArrayList<String> slingInfo = new ArrayList<>();
        slingInfo.add("Anxiety can prevent you from wanting to see your friends.");
        slingInfo.add("Spend time with loved ones and do activities you enjoy.");
        slingInfo.add("To use this tool, plan out time to see your friend.");
        slingInfo.add("Continue when you set out some time to see your friend");

        ArrayList<String> netInfo = new ArrayList<>();
        netInfo.add("Incorporate vegetables, fruits, whole grains, and fish into your diet.");
        netInfo.add("Along with other positive changes, changing your diet to include ");
        netInfo.add("healthy, balanced meals, can improve your mood");
        netInfo.add("To use this tool, decide on a healthy meal.");
        netInfo.add("Continue when you have a plan for what you will eat");

        availableTools.add(new Tool("Dagger", "of deep breaths", daggerInfo, 5,"aa-dagger.png", new Point(140-25, 405)));
        availableTools.add(new Tool("Scepter", "of support", sceptreInfo, 5, "aa-septer.png", new Point(255-25, 140)));
        availableTools.add(new Tool("Elixir", "of exercise ", elixirInfo, 5, "aa-potion.png", new Point(360-25, 410)));
        availableTools.add(new Tool("Cloak", "of communication", cloakInfo, 5, "aa-cloak.png", new Point(640-25, 368)));
        availableTools.add(new Tool("Javelin", "of journaling", javelinInfo, 5, "aa-javelin.png", new Point(675-25, 110)));
        availableTools.add(new Tool("Sword", "of sleep", swordInfo, 5, "aa-sword.png", new Point(530, 201)));
        availableTools.add(new Tool("Slingshot", "of socializing", slingInfo, 5, "aa-slingshot.png", new Point(50-25, 55)));
        availableTools.add(new Tool("Net", "of nutrition", netInfo, 5, "aa-net.png", new Point(5-25, 330)));


        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isDialogue) count++;
                repaint();
            }
        });

        //mouse listener
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                System.out.println(x+" "+y);
                collectTool(x, y);
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
        //Color backgroundColour = new Color(46, 23, 110);
        //setBackground(backgroundColour);
        g.drawImage(Main.imageFromFile("background1revised.jpeg"), 0, 0, null);
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
                isDialogue = false;
                drawAvailableTools(g);
                break;
            case 4:
                isDialogue = true;
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

    /**
     * collects the tools if they are clicked and moves to next screen when 3 tools are chosen
     *
     * @param x mouse x
     * @param y mouse y
     */
    private void collectTool(int x, int y) {
        Tool selectedTool = clickedInAvailableTool(x, y);
        if (selectedTool != null) {
            // collect it
            availableTools.remove(selectedTool);
            chosenTools.add(selectedTool);
            if (chosenTools.size() == 3) {
                // move to the next screen
                count++;
            }
            // redraw to reflect the currently available tools
            repaint();
        }
    }

    /**
     * checks if the mouse clicked inside a tool
     *
     * @param x mouse x
     * @param y mouse y
     * @return the tool that was clicked in if a tool was clicked, else returns null
     */
    private Tool clickedInAvailableTool(int x, int y) {
        for (Tool t : availableTools) {
            if (x >= t.getCords().getX() && x <= ( t.getCords().getX() + t.getxSize()) &&
                    y >= t.getCords().getY() && y <= (t.getCords().getY() + t.getySize())) {
                // we have hit the tool
                return t;
            }
        }
        return null;
    }

    /**
     * writes out chosen tools across the screen
     *
     * @param g graphics to draw
     */
    private void displayChosenTools(Graphics g) {
        g.drawString("The tools you have chosen are:", 100, 120);
        int drawStringY = 150;
        for (Tool t : chosenTools) {
            g.drawString(t.getName() + ", ", 100, drawStringY);
            drawStringY += 20;
        }
    }

    /**
     * draws available tools during selection
     *
     * @param g grpahics to draw
     */
    private void drawAvailableTools(Graphics g) {
        for (Tool t : availableTools) {
            g.setColor(t.getColor());
            g.drawImage(t.getToolImg().getScaledInstance(60, -1, Image.SCALE_DEFAULT), (int)t.getCords().getX(), (int)t.getCords().getY(), this);
        }
    }


    /**
     * takes the arraylist given and returns the first item
     * will eventually take user input to add chosen tools
     *
     * @param g graphics to draw
     */
    public void collectTools(Graphics g) {
        g.drawString("collecting tools:", 20, 100);

        while (chosenTools.size() < 3) {
            repaint();
            x = getMousePosition().x;
            y = getMousePosition().y;


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
    public ArrayList<Tool> returnChosenTools() {
        return chosenTools;
    }


}
