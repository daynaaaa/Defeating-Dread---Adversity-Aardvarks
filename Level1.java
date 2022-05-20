/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Level1" class that will run the second level when called
 *
 * Version #2 May 16 - May 20 - [0.5 hrs]:
 *    Sulagna - created preliminary Level1 class with some methods
 *    Does not draw anything
 *    Calls Talk(ArrayList<String>)
 *
 */


import java.util.*;

public class Level1 {

	private ArrayList<String> lesson;

	public Level1() {
		lesson = new ArrayList<String>();
		fillArrayList();
	}

	private void fillArrayList() {
		lesson.add("");
		lesson.add("");
		lesson.add("");

		lesson.add("");
		lesson.add("");
		lesson.add("");

		lesson.add("");
		lesson.add("");
		lesson.add("");
	}

	public void graphics() {
		
	}

	public void showAllText() {
		Talk t = new Talk(lesson);
		t.talking();
	}

	public static void main(String[] args) {

	}
}
