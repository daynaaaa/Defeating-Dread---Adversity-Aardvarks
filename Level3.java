/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 24, 2022
 * Desc: "Level3" class that will run the last level when called
 *
 * Version #1 May 24 - May 27 - [1 hrs]:
 *    Danya - added messages, which the user can go through by pressing space
 * Version #2 May 30 - June 3 - [2 hrs]:
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
    /** If the user is reading dialogue */
    private boolean isDialogue;
    /**
     * constructor
     *
     * @param cT chosen tools stored
     */
    public Level3(ArrayList<Tool> cT) {
    //public Level3() {
         //cT.get(0).getName();
         chosenTools = cT;
         end = false;
         isDialogue = true;
         getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
         getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isDialogue) count++;
                repaint();
            }
         });
         addMouseListener (new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                //choosing tools
                if(count >= 4){
                   if (x > 170 && y > 370 && x < 250 && y < 450) {
                       currentTool = chosenTools.get(0);
                       tool = 1;
                       repaint();
                   }
                   else if (x > 270 && y > 370 && x < 350 && y < 450) {
                       currentTool = chosenTools.get(1);
                       tool = 2;
                       repaint();
                   }
                   else if (x > 370 && y > 370 && x < 450 && y < 450) {
                       currentTool = chosenTools.get(2);
                       tool = 3;
                       repaint();
                   }
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
           g.setColor(Color.WHITE);
           g.drawString(currentTool.getName(), 20, 20);
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
        g.setFont(new Font("Courier", Font.BOLD, 20));
        switch(count){
            case 1:
               g.drawString("It's getting pretty dark out here...", 20, 70);
               break;
            case 2:
               g.drawString("Now that you have chosen your tools, it is time to make your", 20, 70);
               g.drawString("way out of this forest, but watch out for the monsters!", 20, 100);
               break;
            case 3:
               g.drawString("Good luck! I won’t be able to help you anymore, but I believe", 20, 70);
               g.drawString("in you! Click on each tool to use them on the monsters.", 20, 100);
               break;
            case 4:
               isMonster = true;
               isDialogue = false;
               for(int i = 1; i <= 5; i++){
                  Monster m = new Monster(i*10);
                  /*if(!m.fight(chosenTool)){
                     //kill
                  }*/
               }
               break;
            
            case 5:
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
