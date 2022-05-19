/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Level2" class that will run the second level when called
 *
 * Version #1 May 16 - May 20 - [0.5 hrs]:
 *    Mya - created preliminary Level2 class with some methods
 *    Does not draw anything
 *    Calls Tools(String, String, String, int), Monster(int, int), and Talk(ArrayList <String>)
 *
 */

import java.util.ArrayList;

public class Level2 {
    /**
     * monster
     */
    Monster monster;
    /**
     * all tools - made from constructor
     */
    ArrayList <Tools> allTools;
    /**
     * chosen tools - made from collectTools method
     */
    ArrayList <Tools> chosenTools;
    /**
     * Text message
     */
    ArrayList <String> message;

    /**
     * constructor
     *
     * @param messageP calls super with text
     * @param allToolsP all tools stored
     * @param monsterP chosen tools stored
     */
    public Level2(ArrayList<String> messageP, ArrayList<Tools> allToolsP, Monster monsterP) {
        message=messageP;
        allTools=allToolsP;
        chosenTools=collectTools();
        monster=monsterP;
        monster.fight(chosenTools.get(0));
    }

    /**
     * takes the arraylist given and returns the first item
     * will eventually take user input to add chosen tools
     *
     * @return the three tools needed for the next step
     */
    public ArrayList<Tools> collectTools() {
        System.out.println("collecting tools:\n");
        ArrayList<Tools> collected = new ArrayList<>();
        collected.add(allTools.remove(0));
        return collected;
    }
}
