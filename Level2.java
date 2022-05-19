import java.util.ArrayList;

public class Level2 {
    /**monster*/
    Monster monster;
    //all tools - made from constructor
    ArrayList <Tools> allTools;
    //chosen tools - made from collectTools method
    ArrayList <Tools> chosenTools;
    //Text message
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
        monster.Fight(chosenTools.get(0));
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
