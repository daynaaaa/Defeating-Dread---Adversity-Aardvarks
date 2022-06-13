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
 * Version #4 Jun 3-10 [4 hrs]:
 * Mya - tools can be selected with the mouse
 * Text is shown and the user is able to choose to equip
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
     * when user first opens tool, it will be stored here
     * info will be displayed
     * the user will decide to take the tool or choose a different one
     */
    private Tool openTool = null;
    /**
     * Dimensions for the yes/no buttons during the tool selection screen
     */
    private Point buttonDimensions = new Point(45, 30);
    /**
     * Locations for the yes/no buttons
     * The no button will be set to the right of the yes button
     */
    private Point noButton = new Point(310 + buttonDimensions.x + 5, 100);
    private Point yesButton = new Point(310, 100);

    /**
     * constructor
     */
    public Level2() {
        end = false;
        isDialogue = true;
        ArrayList<String> daggerInfo = new ArrayList<>();
        Tool dagger = new Tool("Dagger", "of deep breaths", daggerInfo, 8, "aa-dagger.png", new Point(140 - 25, 405));
        daggerInfo.add("Deep breathing can help you control your anxiety.");
        daggerInfo.add("Deep breathing tells your nervous system to relax.");
        daggerInfo.add("To use this tool, practice some deep breathing.");
        daggerInfo.add("In...2...3...4... Out...2...3...4... ");
        daggerInfo.add("This tool will do " + dagger.getDamage() + " damage to your anxiety");

        ArrayList<String> sceptreInfo = new ArrayList<>();
        Tool scepter = new Tool("Scepter", "of support", sceptreInfo, 7, "aa-septer.png", new Point(255 - 25, 140));
        sceptreInfo.add("At school, there are counsellors and administrators");
        sceptreInfo.add("trained to help you spot the roots of your anxiety");
        sceptreInfo.add(" and give you a range of strategies to deal with them.");
        sceptreInfo.add("It may be scary at first, but they are there for you ");
        sceptreInfo.add("and it is definitely worth a try.");
        sceptreInfo.add("To use this tool, identify some people who are there to support you.");
        sceptreInfo.add("Come up with 3 people around you who are ready to help");
        sceptreInfo.add("This tool will do " + scepter.getDamage() + " damage to your anxiety");

        ArrayList<String> cloakInfo = new ArrayList<>();
        Tool cloak = new Tool("Cloak", "of communication", cloakInfo, 3, "aa-cloak.png", new Point(640 - 25, 368));
        cloakInfo.add("Communicating with your parents, teachers, and friends");
        cloakInfo.add("is key to reducing your anxiety. Telling them about ");
        cloakInfo.add("your difficulties can help them help you identify the");
        cloakInfo.add("stressors in your life and take steps to working through them.");
        cloakInfo.add("To use this tool, message a friend and ask them how they are feeling.");
        cloakInfo.add("This tool will do " + cloak.getDamage() + " damage to your anxiety");

        ArrayList<String> elixirInfo = new ArrayList<>();
        Tool elixir = new Tool("Elixir", "of exercise ", elixirInfo, 6, "aa-potion.png", new Point(360 - 25, 410));
        elixirInfo.add("Develop a routine to be physically active throughout the week.");
        elixirInfo.add("Exercise can improve your mood.");
        elixirInfo.add("To use this tool, do 10 jumping jacks and note");
        elixirInfo.add("how you feel before/after.");
        elixirInfo.add("This tool will do " + elixir.getDamage() + " damage to your anxiety");

        ArrayList<String> javelinInfo = new ArrayList<>();
        Tool javelin = new Tool("Javelin", "of journaling", javelinInfo, 5, "aa-javelin.png", new Point(675 - 25, 110));
        javelinInfo.add("Journaling can help you identify what's causing you stress.");
        javelinInfo.add("Putting your feelings in words can help you feel better.");
        javelinInfo.add("To use this tool, write down something you have ve been feeling.");
        javelinInfo.add("This tool will do " + javelin.getDamage() + " damage to your anxiety");

        ArrayList<String> swordInfo = new ArrayList<>();
        Tool sword = new Tool("Sword", "of sleep", swordInfo, 6, "aa-sword.png", new Point(530, 201));
        swordInfo.add("Make sure sleep is a priority and that you feel rested.");
        swordInfo.add("You can talk with your doctor if you aren't sleeping well.");
        swordInfo.add("To use this tool, plan out a full night of sleep.");
        swordInfo.add("Calculate the time you will have go to bed");
        swordInfo.add("tonight to get the recommended 8-10 hours.");
        swordInfo.add("This tool will do " + sword.getDamage() + " damage to your anxiety");

        ArrayList<String> slingInfo = new ArrayList<>();
        Tool slingshot = new Tool("Slingshot", "of socializing", slingInfo, 4, "aa-slingshot.png", new Point(50 - 25, 55));
        slingInfo.add("Anxiety can prevent you from wanting to see your friends.");
        slingInfo.add("Spend time with loved ones and do activities you enjoy.");
        slingInfo.add("To use this tool, plan out time to see your friend.");
        slingInfo.add("This tool will do " + slingshot.getDamage() + " damage to your anxiety");

        ArrayList<String> netInfo = new ArrayList<>();
        Tool net = new Tool("Net", "of nutrition", netInfo, 3, "aa-net.png", new Point(5 - 25, 330));
        netInfo.add("Incorporate vegetables, fruits, whole grains, and ");
        netInfo.add("fish into your diet. Along with other positive changes, ");
        netInfo.add("changing your diet to include healthy, balanced meals, ");
        netInfo.add("can improve your mood.");
        netInfo.add("To use this tool, decide on a healthy meal.");
        netInfo.add("This tool will do " + net.getDamage() + " damage to your anxiety");

        availableTools.add(dagger);
        availableTools.add(scepter);
        availableTools.add(elixir);
        availableTools.add(cloak);
        availableTools.add(javelin);
        availableTools.add(sword);
        availableTools.add(slingshot);
        availableTools.add(net);

        //space key for next
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isDialogue) count++;
                repaint();
            }
        });

        //mouse listener for tool selection and button pressing
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                if (openTool != null) checkButtons(x, y);
                else collectTool(x, y);
                // redraw to reflect the currently available tools
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
        g.drawImage(Main.imageFromFile("background2revised.jpg"), 0, 0, null);
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawImage(Main.imageFromFile("PlayerSad.png").getScaledInstance(100, -1, Image.SCALE_DEFAULT), 350, 260, this);
        switch (count) {
            case 0:
                g.drawString("Level 2: Panic room", 100, 100);
                break;
            case 1:
                g.drawString("Now that it is almost nighttime, it is time for me to teach you", 100, 100);
                g.drawString("some strategies for fighting these monsters", 100, 130);
                break;
            case 2:
                g.drawString("There are 9 tools hidden in the bushes for you to find", 100, 100);
                g.drawString("If you click on them, I will teach you about them", 100, 130);
                g.drawString("Then, you can select your 3 favourite tools to equip.", 100, 160);
                break;
            case 3:
                isDialogue = false;
                drawAvailableTools(g);
                break;
            case 4:
                isDialogue=true;
                g.drawString("Good choices! But, I can't let you move on just yet...", 100, 100);
                break;
            case 5:
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
            this.openTool = selectedTool;
        } else {
            this.openTool = null;
        }
    }

    /**
     * checks if the yes or no buttons have been pressed
     *
     * @param x mouse x
     * @param y mouse y
     */
    private void checkButtons(int x, int y) {
        if (x >= yesButton.x && x <= yesButton.x + buttonDimensions.x &&
                y >= yesButton.y && y <= yesButton.y + buttonDimensions.y) {
            //user equips tool
            //collect it
            availableTools.remove(openTool);
            chosenTools.add(openTool);
            openTool = null; //text closes
            if (chosenTools.size() == 3) {
                // move to the next screen
                count++;
            }
        } else if (x >= noButton.x && x <= noButton.x + buttonDimensions.x &&
                y >= noButton.y && y <= noButton.y + buttonDimensions.y) {
            openTool = null; //text closes
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
            if (x >= t.getCords().getX() && x <= (t.getCords().getX() + t.getxSize()) &&
                    y >= t.getCords().getY() && y <= (t.getCords().getY() + t.getySize())) {
                // we have hit the tool
                return t;
            }
        }
        return null;
    }

    /**
     * draws available tools during selection
     *
     * @param g graphics to draw
     */
    private void drawAvailableTools(Graphics g) {
        for (Tool t : availableTools) {
            g.setColor(t.getColor());
            g.drawImage(t.getToolImg().getScaledInstance(60, -1, Image.SCALE_DEFAULT), (int) t.getCords().getX(), (int) t.getCords().getY(), this);
        }
        if (this.openTool != null) {
            displayToolInfo(g);
        }
    }

    /**
     * writes out the tool information
     *
     * @param g
     */
    private void displayToolInfo(Graphics g) {
        g.setColor(new Color(100, 100, 100, 195));
        g.fillRect(yesButton.x-20, 0, 600, 500);
        g.setFont(new Font("Courier", Font.BOLD, 25));
        g.setColor(Color.WHITE);
        int drawStringY = 30;
        g.drawString(this.openTool.getName(), yesButton.x, drawStringY);
        drawStringY += 30;
        g.setFont(new Font("Courier", Font.ITALIC, 20));
        g.drawString(this.openTool.getInfo(), yesButton.x, drawStringY);
        drawStringY += 30;
        g.setFont(new Font("Courier", Font.PLAIN, 15));
        for (String s : this.openTool.getTask()) {
            g.drawString(s, yesButton.x, drawStringY);
            drawStringY += 18;
        }
        g.setColor(Color.GRAY);
        yesButton.y = drawStringY;
        g.fillRect(yesButton.x, yesButton.y, buttonDimensions.x, buttonDimensions.y);
        noButton.y = drawStringY;
        g.fillRect(noButton.x, noButton.y, buttonDimensions.x, buttonDimensions.y);
        g.setFont(new Font("Courier", Font.BOLD, 18));
        g.setColor(Color.WHITE);
        g.drawString("Yes", yesButton.x + 5, yesButton.y + 20);
        g.drawString("No", noButton.x + 5, noButton.y + 20);
    }


    /**
     * checks if tools are still being collected
     * while tools are being collected, the chosen tool is equipped
     *
     * @param g graphics to draw
     */
    public void collectTools(Graphics g) {
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString("Collecting tools:", 100, 100);

        while (chosenTools.size() < 3) {
            repaint();
            x = getMousePosition().x;
            y = getMousePosition().y;

            if (x >= 100 && x <= 150) {
                chosenTools.add(availableTools.remove(0));
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