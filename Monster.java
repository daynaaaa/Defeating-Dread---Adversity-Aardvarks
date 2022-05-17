import java.util.ArrayList;

public class Monster {
    //damage
    final int damage;
    //starting health
    int health;

    /**
     * temporary constructor
     */
    public Monster(){
        damage=5;
        health=100;
    }

    /**
     * constructor with parameters
     *
     * @param d damage
     * @param h health
     */
    public Monster(int d, int h){
        damage=d;
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
     * fight the monster
     *
     * @param tool the tool being used
     * @return if the monster is defeated
     */
    public boolean Fight(Tools tool) {
        System.out.println("fighting:\n");
        this.decrease(tool.damage);
        if(health>0) return false;
        return true;
    }
}
