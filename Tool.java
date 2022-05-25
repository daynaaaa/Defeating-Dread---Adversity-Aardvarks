/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Menu" class for the menu where the user can choose to play the game, go to instructions, or quit the game
 * <p>
 * Version #1 May 16 - May 20 - [0.5 hr]:
 * Mya - created preliminary Tool class with some methods
 */
public class Tool {
    /**
     * String with name/info/task for tool
     */
    private String name, info, task;
    /**
     * how much damage
     */
    private int damage;

    /**
     * constructor with parameters
     *
     * @param i info string
     * @param t task string
     * @param d damage int
     */
    public Tool(String n, String i, String t, int d) {
        name = n;
        info = i;
        task = t;
        damage = d;
    }

    /**
     * get name
     *
     * @return name as a string
     */
    public String getName() {
        return name;
    }

    /**
     * get information about tool
     *
     * @return info as string
     */
    public String getInfo() {
        return info;
    }

    /**
     * get task needed to use tool
     *
     * @return task as string
     */
    public String getTask() {
        return task;
    }

    /**
     * get damage tool does
     *
     * @return damage as int
     */
    public int getDamage() {
        return damage;
    }


}
