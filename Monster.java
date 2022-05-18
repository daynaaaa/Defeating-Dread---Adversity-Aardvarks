import java.util.ArrayList;

public class Monster {
    //damage
    private final int damage;
    //starting health
    private int health;

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
     * @return true if the monster is defeated
     */
    public boolean fight(Tools tool) {
        System.out.println("\nfighting:");
        this.decrease(tool.getDamage());
        return health<=0;
    }
}
