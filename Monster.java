/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Monster" class that creates a monster with parameters
 * <p>
 * Version #1 May 16 - May 20 - [0.5 hrs]:
 * Mya - created preliminary Monster class with some methods
 * Version #2 June 6 - [1 hrs]:
 * Danya - change some parameters for functionality purposes 
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class Monster {
    /**
     * starting health
     */
    private int health;
    private Image monster;
    /**
     * constructor with parameters
     *
     * @param h health
     * @param mName name of monster image file
     */
    public Monster(int h, String mName) {
        health = h;
        monster = Main.imageFromFile(mName);

    }
    /**get Monster image
     *@return image of monster
     */
    public Image getImage(){
      return monster;
    }
    /**
     * decrement health when fighting
     *
     * @param amt
     */
    public void decrease(int amt) {
        health -= amt;
    }

    /**
     * @return health
     */
    public int getHealth() {
        return health;
    }
      
    /**
     * fight the monster
     *
     * @param tool the tool being used
     */
    public void fight(Tool tool) {
        this.decrease(tool.getDamage());
    }
    /**
      * @return true if the monster is defeated
      */
     public boolean isDefeated(){
         return health <= 0;
     }
      
}