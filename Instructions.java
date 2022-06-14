import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Menu" class for the menu where the user can choose to play the game, go to instructions, or quit the game
 * <p>
 * Version #1 May 16 - May 20 - [1 hr]:
 * Mya - original menu placeholder
 * Version #2 May 24 - May 27 - [2.5 hrs]:
 * Danya - Fix instructions bug where the user can click anywhere
 * Mya - add text to the screen
 * Version #2 June 3 -10- [2.5 hrs]:
 * Mya - update menu with user information for submission
 */
public class Instructions extends JPanel {
    /**
     * if the back button is pressed
     */
    private volatile boolean pressed;
    /**
     * the x value of the point the user clicks on
     */
    private int x;
    /**
     * the y value of the point the user clicks on
     */
    private int y;
    /**
     * increases the slide
     */
    private int countinst = 0;
    /**
     * holds the instructions/user manual for menu
     */
    ArrayList<String> instructionsmenu = new ArrayList<>();
    /**
     * holds the instructions/user manual for level 1
     */
    ArrayList<String> instructionslvl1= new ArrayList<>();
    /**
     * holds the instructions/user manual for level 2
     */
    ArrayList<String> instructionslvl2 = new ArrayList<>();
    /**
     * holds the instructions/user manual for level 3
     */
    ArrayList<String> instructionslvl3 = new ArrayList<>();
    /**
     * holds the instructions/user manual for end screen
     */
    ArrayList<String> instructionsend = new ArrayList<>();


    /**
     * checks and holds if the instructions are done showing
     */
    private volatile boolean end=false;


    /**
     * Constructor for the Menu class
     * Implements the mouse listener
     */
    public Instructions() {
        pressed = false;
        instructionsmenu.add("Welcome to Defeating Dread - an Adversity Aardvark game");
        instructionsmenu.add("You've probably figured out how to navigate our menu");
        instructionsmenu.add("by this point, but if you need help, the menu is");
        instructionsmenu.add("navigated with the use of the mouse and buttons");
        instructionsmenu.add("to bring you to the instructions, game, or let");
        instructionsmenu.add("you quit when you are finished.");
        instructionsmenu.add("");
        instructionsmenu.add("You can switch to the next page of the instructions by ");
        instructionsmenu.add("pressing the space bar");
        instructionslvl1.add("Level 1: Deficiencies Room");
        instructionslvl1.add("In this level, you will learn about anxiety and ");
        instructionslvl1.add("how it might be affecting you. Read and click ");
        instructionslvl1.add("through all of the information that will be provided");
        instructionslvl1.add("To navigate this level, press space when you finish");
        instructionslvl1.add("reading to keep going");
        instructionslvl2.add("Level 2: Panic Room");
        instructionslvl2.add("In this level, you will be able to look at some possible ");
        instructionslvl2.add("tools that you can use to defeat the monsters. You'll get ");
        instructionslvl2.add("to see a lot of choices, but you can only pick the 3  ");
        instructionslvl2.add("that you think will be the best for you.");
        instructionslvl2.add("You can use the space bar to read through the instructions");
        instructionslvl2.add("and then use the mousepad to find and select tools.");
        instructionslvl2.add("Once a tool has been selected, you will be able to");
        instructionslvl2.add("read all about it and choose to equip or leave it behind.");
        instructionslvl2.add("To use all of those tools, you will have to complete a task.");
        instructionslvl2.add("Once you finish selecting your tools, you will have to");
        instructionslvl2.add("answer some trivia questions to make sure you will be ");
        instructionslvl2.add("ready for the next round. Use the mousepad to start");
        instructionslvl2.add("the quiz and select answers.");
        instructionslvl3.add("Level 3: Escape Room");
        instructionslvl3.add("On this final level, you'll be able to use your tools ");
        instructionslvl3.add("to help you defeat your anxiety");
        instructionslvl3.add("The tools you chose in level 2 will come back here");
        instructionslvl3.add("to help you defeat the monsters. After using the space");
        instructionslvl3.add("to navigate the instructions, you will click on");
        instructionslvl3.add("the tool you want to use, and then in order to ");
        instructionslvl3.add("use it, you will have to press the space bar");
        instructionslvl3.add("once you finish the associated task.");
        instructionslvl3.add("A random number of monsters will spawn, between 1-5");
        instructionslvl3.add("and when you defeat all of them, you will win");
        instructionsend.add("You can always come back here for more clarification late :)");
        instructionsend.add("Press back when you are done reading.");
        instructionsend.add("");
        instructionsend.add("Good luck! We believe in you!");

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                //if buttons stuff
                if (x >= 250 && x <= 550 && y >= 330 && y <= 410) {
                    pressed = true;
                    repaint();
                }

            }
        });//space key for next
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countinst++;
                repaint();
            }
        });
    }

    /**
     * exit when the back button is pressed
     *
     * @return the boolean value of pressed
     */
    public boolean pressed() {
        revalidate();
        repaint();
        while (!pressed) ;
        return pressed;
    }

    /**
     * Draw the graphics
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yLine=60;
        g.drawImage(Main.imageFromFile("backgroundmenu.jpg"), 0, 0, null);
        g.setColor(Color.BLACK);
        g.fillRect(250, 330, 300, 80);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("Instructions", 150, 30);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        switch (countinst) {
            case 0:
                yLine=50;
                for (String s: instructionsmenu){
                    g.drawString(s, 150, yLine);
                    yLine+=20;
                }
                break;
            case 1:
                yLine=50;
                for (String s: instructionslvl1){
                    g.drawString(s, 150, yLine);
                    yLine+=20;
                }
                break;
            case 2:
                yLine=50;
                for (String s: instructionslvl2){
                    g.drawString(s, 150, yLine);
                    yLine+=20;
                }
                break;
            case 3:
                yLine=50;
                for (String s: instructionslvl3){
                    g.drawString(s, 150, yLine);
                    yLine+=20;
                }
                break;
            case 4:
                yLine=50;
                for (String s: instructionsend){
                    g.drawString(s, 150, yLine);
                    yLine+=20;
                }
                countinst=0;
                break;
            default:
        }

        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("back", 330, 370);
    }

}
