import java.lang.reflect.Array;
import java.util.ArrayList;

public class Talk {
    private ArrayList <String> message;

    public Talk(ArrayList <String> messageP){
        message=messageP;
    }

    /**
     * prints out text from given arraylist
     *
     */
    public void talking() {
        System.out.println("talking:\n");
        for (String s : message)
            System.out.println(s);
    }
}
