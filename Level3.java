/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 24, 2022
 * Desc: "Level3" class that will run the last level when called
 *
 * Version #1 May 24 - May 27 - [1 hrs]:
 *    Danya - added messages, which the user can go through by pressing space
 * Version #2 May 30 - June 3 - [5 hrs]:
 *    Danya - added squares to represent the characters and the tools
 *    Added the function to view the tools details
 *    Also implemented fighting the monster
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
    /** If the user has chosen a tool yet */
    private boolean toolChosen;
    /** If the user has completed the task*/
    private boolean taskComplete;
    /**If the user is currently doing a task*/
    private boolean isTask;
    /** The current monster the user is fighting */
    private Monster m;
    /** the number of the monster the user is fighting*/
    private int monNum;
    /* The health of the monster*/
    private int health;
    /**
     * constructor
     *
     * @param cT chosen tools stored
     */
    public Level3(ArrayList<Tool> cT) {
         //cT.get(0).getName();
         health = 10;
         monNum = 1;
         m = new Monster(health);
         chosenTools = cT;
         end = false;
         isDialogue = true;
         taskComplete = true;
         getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
         getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isDialogue)count++;
                //System.out.println(isDialogue);
                else if(isTask)taskComplete = true;
                /*else {
                  taskComplete = true;
                }*/
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
                       if(currentTool == null){
                           toolChosen = true;   
                       }
                       else if(currentTool.getName() != chosenTools.get(0).getName()){
                           toolChosen = true;   
                       }
                       else toolChosen = false;
                       currentTool = chosenTools.get(0);
                       tool = 1;
                       //toolChosen = true;
                       taskComplete = false;
                       repaint();
                   }
                   else if (x > 270 && y > 370 && x < 350 && y < 450) {
                       if(currentTool == null){
                           toolChosen = true;   
                       }
                       else if(currentTool.getName() != chosenTools.get(1).getName()){
                           toolChosen = true;   
                       }

                       else toolChosen = false;
                       tool = 2;
                       //toolChosen = true;
                       taskComplete = false;
                       repaint();
                   }
                   else if (x > 370 && y > 370 && x < 450 && y < 450) {
                       if(currentTool == null){
                           toolChosen = true;   
                       }
                       else if(currentTool.getName() != chosenTools.get(2).getName()){
                           toolChosen = true;   
                       }
                       else toolChosen = false;
                       currentTool = chosenTools.get(2);
                       tool = 3;
                       //toolChosen = true;
                       taskComplete = false;
                       repaint();
                   }
                }
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
           g.fillRect(20, 10, 400, 150);
           g.setColor(Color.BLACK);
           g.drawString(currentTool.getName()+" " + currentTool.getInfo(), 20, 20);
           for(int i = 0;i < currentTool.getTask().size();i++){
               g.drawString(currentTool.getTask().get(i), 20, i*20+40);
           }
           
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
               
               //monster:
               g.setColor(Color.WHITE);   
               g.fillRect(500, 100, 260, 350);
               g.setColor(Color.RED);   
               g.fillRect(500, 50, 260, 20);
               g.setColor(Color.GREEN);
               g.fillRect(500, 50, m.getHealth()*26, 20);
               g.setColor(Color.WHITE);  
               g.drawString("Monster number: " + monNum, 500, 10);
               g.drawString("Health: " + health, 500, 30);
               isDialogue = false;
               
               if(toolChosen&& monNum <= 5){
                  isTask = true;
                  if(taskComplete){
                  //System.out.println(m.getHealth());
                  if(m.fight(currentTool)&&monNum != 5){
                        monNum++;
                        health = monNum * 10;
                        m = new Monster(health);
                  }
                  else health = m.getHealth();
                  toolChosen = false;
                  System.out.println(m.getHealth());
                  }
               }
               else if (monNum == 5) count++;
                
               //isDialogue = true;
               break;
            
            case 5:
               isTask = false;
               end = true;
               break;
            default:
            
        }
        /*if(isMonster){
            g.setColor(Color.WHITE);   
            g.fillRect(500, 100, 260, 350);
            g.setColor(Color.RED);   
            g.fillRect(500, 50, 260, 20);
            g.setColor(Color.GREEN);
            g.fillRect(500, 50, m.getHealth()*26, 20);
        }*/
        
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
