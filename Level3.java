/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 24, 2022
 * Desc: "Level3" class that will run the last level when called
 *
 * Version #1 May 24 - May 27 - [1 hrs]:
 *    Danya - added messages, which the user can go through by pressing space
 * Version #2 May 30 - June 3 - [1 hrs]:
 *    Danya - added squares to represent the characters and the tools
 *
 */

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Level3 extends JPanel{
    /**
     * monster
     */
    Monster monster;
    /**
     * chosen tools - made from collectTools method
     */
    ArrayList <Tool> chosenTools;
    /** Text message*/
    ArrayList <String> message;
    /** If the level has ended */
    private volatile boolean end;
    /** Variable to control the storyline*/
    private int count;
    /** Holds the tool the user is using currently*/
    private Tool currentTool;
    /** Holds the number of the tool the user is using currently*/
    private int tool;
    /** If the user is fighting the monster yet*/
    private boolean isMonster;
    /**
     * constructor
     *
    // * @param cT chosen tools stored
     */
    //public Level3( ArrayList<Tool> cT) {
    public Level3() {
         end = false;
         getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
         getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                repaint();
            }
         });
         addMouseListener (new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                //choosing tools
                if (x > 170 && y > 370 && x < 250 && y < 450) {
                    //currentTool = chosenTools.get(0);
                    tool = 1;
                    //g.setColor(Color.WHITE);
                    //g.drawString(currentTool.getName(), 0, 0);

                    repaint();
                }
                else if (x > 270 && y > 370 && x < 350 && y < 450) {
                    //currentTool = chosenTools.get(1);
                    tool = 2;
                    repaint();
                }
                else if (x > 370 && y > 370 && x < 450 && y < 450) {
                    //currentTool = chosenTools.get(2);
                    tool = 3;
                    repaint();
                }
            }
        });
    }
    /**
     * Draw the graphics
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color backgroundColour = new Color(46, 23, 110);
        setBackground(backgroundColour);
        g.setColor(Color.WHITE);
        g.fillRect(20, 200, 130, 250);
        g.fillRect(170, 370, 80, 80);
        g.fillRect(270, 370, 80, 80);
        g.fillRect(370, 370, 80, 80);
        if(tool == 1){
           g.setColor(Color.GREEN);
           g.fillRect(170, 370, 80, 80);
           g.setColor(Color.WHITE);
           g.fillRect(270, 370, 80, 80);
           g.fillRect(370, 370, 80, 80);
        }
        else if(tool == 2){
           g.setColor(Color.GREEN);
           g.fillRect(270, 370, 80, 80);
           g.setColor(Color.WHITE);
           g.fillRect(170, 370, 80, 80);
           g.fillRect(370, 370, 80, 80);
        }
        else if(tool == 3){
           g.setColor(Color.GREEN);
           g.fillRect(370, 370, 80, 80);
           g.setColor(Color.WHITE);
           g.fillRect(270, 370, 80, 80);
           g.fillRect(170, 370, 80, 80);
        }
        
        //System.out.println(end);
        switch(count){
            case 1:
               System.out.println("It's getting pretty dark out here...");
               break;
            case 2:
               System.out.println("Now that you have chosen your tools, it is time to make your way out of this forest, but watch out for the monsters!");
               break;
            case 3:
               System.out.println("Good luck! I won�t be able to help you anymore, but I believe in you! Click on each tool to use them on the monsters.");
               break;
            case 4:
               isMonster = true;
               
               break;
            
            case 5:
               System.out.println("You win!");
               end = true;
               break;
            default:
            
        }
        if(isMonster){
            g.setColor(Color.WHITE);   
            g.fillRect(500, 100, 260, 350);
        }
        
    }
    /**
     * update the graphics
     */
    public void start3() {
        revalidate();
        repaint();
        while (!end);
    }
    
}
