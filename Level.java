import java.util.ArrayList;

public abstract class Level {
    //health starting at the level
    private int health = 100;
    ArrayList <String> text;


    /**
     * constructor
     * @param textP text for talking
     */
    public Level(ArrayList<String> textP) {
        text=textP;
        talk(text);
    }

    /**
     * prints out text from given arraylist
     *
     * @param text text slides
     */
    public void talk(ArrayList<String> text) {
        System.out.println("talking:\n");
        for (String s : text)
            System.out.println(s);
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
