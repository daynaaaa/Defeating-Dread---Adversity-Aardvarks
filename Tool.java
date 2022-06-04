import java.awt.*;
import java.util.ArrayList;

/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Menu" class for the menu where the user can choose to play the game, go to instructions, or quit the game
 * <p>
 * Version #1 May 16 - May 20 - [0.5 hr]:
 * Mya - created preliminary Tool class with some methods
 * Version #2 May 20 - May 27 - [0.5 hr]:
 * Mya - changed some parameters for easier use
 */
public class Tool {
    /**
     * String with name/info/task for tool
     */
    private String name, info;
    private ArrayList<String> task;
    /**
     * how much damage
     */
    private int damage;
    /**
     * color of the weapon, will be replaced with an image
     */
    private Color color;

    private int xCord, yCord;
    private int xSize = 50, ySize = 50;


    /**
     * constructor with parameters
     *
     * @param i info string
     * @param t task string
     * @param d damage int
     */
    public Tool(String n, String i, ArrayList t, int d, Color c, int x, int y) {
        name = n;
        info = i;
        task = t;
        damage = d;
        color = c;
        xCord = x;
        yCord = y;
    }

    /**
     * get xCord
     * used to draw the shape
     *
     * @return xCord as int
     */
    public int getxCord() {
        return xCord;
    }

    /**
     * get yCord
     * used to draw the shape
     *
     * @return yCord as int
     */
    public int getyCord() {
        return yCord;
    }

    /**
     * get color
     * will be replaced with image
     *
     * @return color as Color
     */
    public Color getColor() {
        return color;
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
    public ArrayList<String> getTask() {
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

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }


}
