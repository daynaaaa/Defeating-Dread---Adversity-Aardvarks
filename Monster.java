/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Monster" class that creates a monster with parameters
 *
 * Version #1 May 16 - May 20 - [0.5 hrs]:
 *    Mya - created preliminary Monster class with some methods
 *
 */

public class Monster {
    /**
     * starting health
     */
    private int health;

    /**
     * constructor with parameters
     *
     * @param d damage
     * @param h health
     */
    public Monster(int h){
        health=h;
    }

    /**
     * decrement health when fighting
     *
     * @param amt
     */
    public void decrease(int amt){
        health-=amt;
    }
    /**
     * @return health
     */
    public int getHealth(){
        return health;
    }
    /**
     * fight the monster
     *
     * @param tool the tool being used
     * @return true if the monster is defeated
     */
    public boolean fight(Tool tool) {
        this.decrease(tool.getDamage());
        return health<=0;
    }
}