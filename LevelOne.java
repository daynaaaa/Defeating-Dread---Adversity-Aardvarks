import java.util.*;

public class LevelOne {

	private ArrayList<String> lesson;

	public LevelOne() {
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
