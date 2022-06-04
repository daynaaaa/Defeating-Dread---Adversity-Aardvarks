/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Talk" class that will be used for the sibling to talk to the mc
 * <p>
 * Version #1 May 16 - May 20 - [0.5 hrs]:
 * Mya - created preliminary Talk class with some methods
 * Version #2 May 20 - May 27 - [0.5 hrs]:
 * Mya - changed some parameters for easier use
 */

import java.util.ArrayList;

public class Talk {
    /**
     * message for typing
     */
    private ArrayList<String> message;

    /**
     * constructor
     *
     * @param messageP message to print
     */
    public Talk(ArrayList<String> messageP) {
        message = messageP;
    }

    /**
     * prints out text from given arraylist
     */
    public void talking() {
        System.out.println("talking:\n");
        for (String s : message)
            System.out.println(s);
    }
}
