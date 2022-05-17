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
}
