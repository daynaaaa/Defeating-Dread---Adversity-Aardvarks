public class Monster {
    int damage;
    int health;
    public Monster(){
        damage=5;
        health=100;
    }
    public Monster(int d, int h){
        damage=d;
        health=h;
    }
    public void decrease(int amt){
        health-=amt;
    }
}
