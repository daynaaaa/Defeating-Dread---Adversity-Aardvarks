import java.util.ArrayList;

/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Main" class that runs the game
 *
 * Variables:
 *
 * Version #1 May 16 - May 20 - [time spent]:
 *    [author] - [modification] 
 *    
 */
public class Main {
    public static void main(String [] args){
        //create message for level
        ArrayList<String> text=new ArrayList<>();
        text.add("message 1");
        text.add("message 2");
        text.add("message 3");
        //make all tools
        ArrayList<Tools>tools=new ArrayList<>();
        tools.add(new Tools("dagger", "info", "task", 5));
        //make monster
        Monster monster = new Monster(5, 100);
        //call level 2
        Level2 lvl2= new Level2(text, tools, monster);
    }

}