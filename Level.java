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
     *
     *
     * @param text text slides
     */
    public void talk(ArrayList<String> text) {
        for (String s : text)
            System.out.println(s);
    }

    public ArrayList<Tools> collectTools(ArrayList<Tools> allTools) {
        ArrayList<Tools> collected = new ArrayList<>(1);
        int indexAdded = 0;
        collected.add(allTools.remove(indexAdded));
        return collected;
    }

    public boolean fight(ArrayList<Tools> tools, Monster monster) {
        health -= monster.damage;
        monster.decrease(5);
        if (getAlive()) return true;
        return false;
    }

    public boolean getAlive() {
        return health > 0;
    }
}
