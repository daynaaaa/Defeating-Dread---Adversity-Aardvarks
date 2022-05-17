import java.util.ArrayList;

public abstract class Level {
    //health starting at the level
    private int health = 100;

    /**
     * temporary constructor - will be developed as game is made
     *
     * might take health as parameter to keep health between rounds
     * other parameters available
     */
    public Level() {
    }

    /**
     * prints out text from given arraylist
     * can be used in all levels by calling the super with any parameter
     *
     * @param text text slides
     */
    public void talk(ArrayList<String> text) {
        for (String s : text)
            System.out.println(s);
    }

    /**
     * takes the arraylist given and returns the first item
     * will eventually take user input to add chosen tools
     * can be used in level 2
     * and overridden in 1/3 with an empty method so it cannot be called as part of either level
     *
     * @param allTools will be an arraylist of type tool
     *                 each tool will be made with the tool class and added to an arraylist passed as a parameter here
     * @return the three tools needed for the next step
     */
    public ArrayList<Tools> collectTools(ArrayList<Tools> allTools) {
        ArrayList<Tools> collected = new ArrayList<>(1);
        int indexAdded = 0;
        collected.add(allTools.remove(indexAdded));
        return collected;
    }

    /**
     * fight the monster
     * can be used in level 2/3 with diff parameters
     * can be overridden with an empty method so it cannot be called as a part of this level
     *
     * @param tools the chosen 3 from collectTools
     * @param monster an initialized monster object for each battle
     * @return if the mc is able to continue
     */
    public boolean fight(ArrayList<Tools> tools, Monster monster) {
        health -= monster.damage;
        monster.decrease(5);
        if (getAlive()) return true;
        return false;
    }

    /**
     * checks if health is bigger than 0
     *
     * @return true if alive
     */
    public boolean getAlive() {
        return health > 0;
    }
}
