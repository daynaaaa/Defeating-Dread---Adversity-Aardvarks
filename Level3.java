import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 24, 2022
 * Desc: "Level3" class that will run the last level when called
 *
 * Version #1 May 24 - May 27 - [1 hrs]:
 *    Danya - added messages, which the user can go through by pressing space
 * Version #2 May 30 - June 3 - [7 hrs]:
 *    Danya - added squares to represent the characters and the tools
 *    Added the function to view the tools details
 *    Also implemented fighting the monster
 * Version #3 June 6 - June 10 - [5 hrs]:
 *    Danya - fixed bugs in fighting the monster, such as pressing space to continue
 */
public class Level3 extends JPanel{
    /**
     * monster
     */
    Monster monster;
    /**
     * chosen tools - made from collectTools method
     */
    ArrayList <Tool> chosenTools;
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
    /** Image of the player*/
    private Image player;
    /** The health of the monster*/
    private int health;
    /**Array of the fileNames of the monsters*/
    private String[] monsters;
    /** Amount of Monsters*/
    private final int numMon;
    /**
     * constructor
     *
     * @param cT chosen tools stored
     */
    public Level3(ArrayList<Tool> cT) {
         health = 10;
         monNum = 1;
         chosenTools = cT;
         end = false;
         isDialogue = true;
         taskComplete = true;
         monsters = new String[]{"aaMonster_Blue.png", "aaMonster_Green.png", "aaMonster_Purple.png", "aaMonster_Red.png", "aaMonster_Yellow.png"};
         numMon = (int)(Math.random()*5+1);
         m = new Monster(health, monsters[monNum-1]);
         getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
         getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isDialogue&&count != 4){
                  count++;
                }
                else if(isTask&&!m.isDefeated()){
                  taskComplete = true;
                }
                else if(!m.isDefeated()){
                        health = m.getHealth();
                }
                else if(monNum!=numMon){
                        monNum++;
                        health = monNum * 10;
                        m = new Monster(health, monsters[monNum-1]);
                        
                  }
                  else count++;

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
                       toolChosen = true;
                       currentTool = chosenTools.get(0);
                       tool = 1;
                       taskComplete = false;
                       repaint();
                   }
                   else if (x > 270 && y > 370 && x < 350 && y < 450) {
                       toolChosen = true;
                       currentTool = chosenTools.get(1);
                       tool = 2;
                       taskComplete = false;
                       repaint();
                   }
                   else if (x > 370 && y > 370 && x < 450 && y < 450) {
                       toolChosen = true;
                       currentTool = chosenTools.get(2);
                       tool = 3;
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
        
        Image bg = Main.imageFromFile("background3revised.jpg");
        g.drawImage(bg, 0,0,this);
        g.drawImage(chosenTools.get(0).getToolImg().getScaledInstance(60, -1, Image.SCALE_DEFAULT), 170, 370, this);
        g.drawImage(chosenTools.get(1).getToolImg().getScaledInstance(60, -1, Image.SCALE_DEFAULT), 270, 370, this);
        g.drawImage(chosenTools.get(2).getToolImg().getScaledInstance(60, -1, Image.SCALE_DEFAULT), 370, 370, this);

        player = Main.imageFromFile("PlayerSad.png");
        g.drawImage(player, 20, 200, null);
        if(tool == 1 && !m.isDefeated()){
           g.setColor(Color.GRAY);
           
           g.fillRect(170, 370, 80, 80);
           g.drawImage(chosenTools.get(0).getToolImg().getScaledInstance(60, -1, Image.SCALE_DEFAULT), 170, 370, this);
           g.setColor(Color.WHITE);
           g.drawString(currentTool.getName()+" " + currentTool.getInfo(), 20, 20);
           for(int i = 0;i < currentTool.getTask().size();i++){
               g.drawString(currentTool.getTask().get(i), 20, i*20+40);
           }
           g.drawString("Press space once you have done this task...", 20, currentTool.getTask().size()*20+40);

           
        }
        else if(tool == 2 && !m.isDefeated()){
           g.setColor(Color.GRAY);
           g.fillRect(270, 370, 80, 80);
           g.drawImage(chosenTools.get(1).getToolImg().getScaledInstance(60, -1, Image.SCALE_DEFAULT), 270, 370, this);
           g.setColor(Color.WHITE);
           g.drawString(currentTool.getName()+" " + currentTool.getInfo(), 20, 20);
           for(int i = 0;i < currentTool.getTask().size();i++){
               g.drawString(currentTool.getTask().get(i), 20, i*20+40);
           }
           g.drawString("Press space once you have done this task...", 20, currentTool.getTask().size()*20+40);
        }
        else if(tool == 3 && !m.isDefeated()){
           g.setColor(Color.GRAY);
           g.fillRect(370, 370, 80, 80);
           g.drawImage(chosenTools.get(2).getToolImg().getScaledInstance(60, -1, Image.SCALE_DEFAULT), 370, 370, this);
           g.setColor(Color.WHITE);
           g.drawString(currentTool.getName()+" " + currentTool.getInfo(), 20, 20);
           for(int i = 0;i < currentTool.getTask().size();i++){
               g.drawString(currentTool.getTask().get(i), 20, i*20+40);
           }
           g.drawString("Press space once you have done this task...", 20, currentTool.getTask().size()*20+40);
        }
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g.setColor(Color.WHITE);

        switch(count){
            case 0:
               g.drawString("Level 3: Escape Room", 20, 70);
               break;
            case 1:
               g.drawString("It's getting pretty dark out here...", 20, 70);
               break;
            case 2:
               g.drawString("Now that you have chosen your tools, it is time to make your", 20, 70);
               g.drawString("way out of this forest, but watch out for the monsters!", 20, 100);
               break;
            case 3:
               g.drawString("Good luck! I won't be able to help you anymore, but I believe", 20, 70);
               g.drawString("in you! Click on each tool to use them on the monsters.", 20, 100);
               break;
            case 4:
               isMonster = true;
               isDialogue = false;
               if(m.isDefeated()){
                  g.setColor(Color.WHITE);
                  g.drawString("Congrats! You have", 500, 20);
                  g.drawString("defeated Monster #"+monNum, 500, 40);
                  
                  if(monNum == numMon){
                     tool = 0;
                     g.setColor(Color.WHITE);
                     g.drawString("You have defeated your last anxiety monster!", 20, 70);
                     g.drawString("Press space or click anywhere to continue...", 20, 100);

                  }
                  else g.drawString("Press space to continue...", 20, 100);
               }
               else{
                  g.drawImage(m.getImage(), 500, 100, null);
                  g.setColor(Color.RED);   
                  g.fillRect(500, 50, 260, 20);
                  g.setColor(Color.GREEN);
                  g.fillRect(500, 50, (int)(m.getHealth()/(monNum*10.0)*260), 20);
                  g.setColor(Color.WHITE);  
                  g.drawString("Monster number: " + monNum, 500, 10);
                  g.drawString("Health: " + m.getHealth(), 500, 30);
               }
               
               if(toolChosen&& monNum <= numMon){
                  isTask = true;
                  if(taskComplete){
                  m.fight(currentTool);
                  repaint();
                  toolChosen = false;
                  
                  }
               }
               break;
            case 5:
               isMonster = false;
               isDialogue = true;
               g.drawImage(Main.imageFromFile("background1revised.jpg"), 0, 0, null);
               g.drawString("You did it! You fought off the anxiety and learned all sorts of", 20, 100);
               g.drawString("new stress management tools. Now you can return safely to camp!", 20, 130);
               player = Main.imageFromFile("PlayerHappy.png");
               g.drawImage(player, 20, 200, null);
               break;
            case 6:
               isTask = false;
               end = true;
               break;
            default:
            
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
