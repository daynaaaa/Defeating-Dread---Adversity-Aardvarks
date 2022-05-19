/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Tools" class that creates tools with parameters, can make/get values
 *
 * Version #1 May 16 - May 20 - [0.5 hrs]:
 *    Mya - created preliminary Tools class with some methods
 *
 */

public class Tools {
    /**
     * name holds the tool name
     * info holds the tool information
     * task holds the task that needs to be done to use
     */
    private String name, info, task;
    /**
     * how much damage the weapon does
     */
    private int damage;

    /**
     * constructor with parameters
     * @param i info string
     * @param t task string
     * @param d damage int
     */
    public Tools(String n, String i, String t, int d){
        name=n;
        info=i;
        task=t;
        damage=d;
    }

    public String getName(){return name;}
    public String getInfo(){return info;}
    public String getTask(){return task;}
    public int getDamage(){return damage;}



}
