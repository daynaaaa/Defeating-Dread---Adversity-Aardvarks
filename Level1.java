/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: June 10, 2022
 * Desc: "Level1" class that will run the first level when called
 * <p>
 * Version #2 May 16 - May 20 - [0.5 hrs]:
 * Sulagna - created preliminary Level1 class with some methods
 * Does not draw anything
 *
 * Version #3 May 30 - June 3
 *  * Sulagna - Did the preliminary graphics and figured out mouse input
 *
 * Final (#4) June 6 - June 10
 * Sulagna - fixed the graphics, finished the logic and input
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Level1 extends JPanel {

    /**
     * Keeps track of which text to show on the screen; changes with user input
     */
    private int count = 0;
    /**
     * Contains text for the lesson
     */
    private ArrayList<String> lesson;
    /**
     * X-coordinates for the lesson text
     */
    private ArrayList<Integer> lessonX;
    /**
     * Y-coordinates for the lesson text
     */
    private ArrayList<Integer> lessonY;
    /**
     * Font sizes for the lesson text
     */
    private ArrayList<Integer> lessonFont;
    /**
     * If the level has ended
     */
    private volatile boolean end;

    /**
     * Constructs Level 1 and takes keyboard input
     */
    public Level1() {
        end = false;
        lesson = new ArrayList<>();
        lessonX = new ArrayList<>();
        lessonY = new ArrayList<>();
        lessonFont = new ArrayList<>();

        fillArrayList();
        repaint();

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count<lesson.size()-1)
                    count++;
                else if(count==lesson.size()-1)
                    end = true;
                repaint();
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
        getActionMap().put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count>0)
                    count--;
                repaint();
            }
        });
    }
    /**
     * Draw the graphics
     *
     * @param g the graphics to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("background1revised.jpg");
        g.drawImage(i, 0, 0, this);
        Image ps = t.getImage("PlayerSadFlipped.png");
        g.drawImage(ps, 410, 200, this);

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(25, 25, 750, 100, 25, 25);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g.setFont(new Font("Courier", Font.BOLD, lessonFont.get(count)));
        g.drawString(lesson.get(count), lessonX.get(count), lessonY.get(count));
    }

    /**
     * Fills all the ArrayLists
     */
    private void fillArrayList() {
        lesson.add("Hi there, little sibling! It's me, your older sibling, talking to you from a walkie-talkie.");
        lessonX.add(80);
        lessonY.add(79);
        lessonFont.add(12);

        lesson.add("How's camp going? Oh- what happened? You ran away and you're feeling anxious now?");
        lessonX.add(75);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("Lucky for you, I'm here to help!");
        lessonX.add(260);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("Sometimes anxiety can feel like a battle, but with the right tools, you'll be able to win.");
        lessonX.add(83);
        lessonY.add(80);
        lessonFont.add(12);

        lesson.add("First, let's take some time for you to learn all about anxiety.");
        lessonX.add(144);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("We'll start with what anxiety even is.");
        lessonX.add(225);
        lessonY.add(80);
        lessonFont.add(15);

        lesson.add("Anxiety is \"an emotion characterized by feelings of tension," +
                " worried thoughts and physical changes\".\n");
        lessonX.add(50);
        lessonY.add(80);
        lessonFont.add(11);

        lesson.add("Anxiety disorders in general make people frightened, distressed, or uneasy.\n");
        lessonX.add(100);
        lessonY.add(80);
        lessonFont.add(13);

        lesson.add("They feel this way even in situations where people without anxiety disorders would not feel that way.");
        lessonX.add(48);
        lessonY.add(80);
        lessonFont.add(11);

        lesson.add("There are many causes of anxiety.");
        lessonX.add(250);
        lessonY.add(80);
        lessonFont.add(15);

        lesson.add("Genetic: Children can inherit the tendency to constantly worry from parents.\n");
        lessonX.add(95);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("Learned: If your caregivers or peers are anxious, you likely will be too.\n");
        lessonX.add(107);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("Environmental: This is anxiety after a stressful event occurs.");
        lessonX.add(147);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("Some examples are death, sickness, frequent moving, being bullied, and being abused.");
        lessonX.add(67);
        lessonY.add(80);
        lessonFont.add(13);

        lesson.add("Co-occurring conditions can worsen it (e.g. depression, ADHD, autism, eating disorders).");
        lessonX.add(49);
        lessonY.add(80);
        lessonFont.add(13);

        lesson.add("Biological: Neurotransmitters communicate with our body on how we're supposed to feel.");
        lessonX.add(57);
        lessonY.add(80);
        lessonFont.add(13);

        lesson.add("If the wrong neurotransmitters are sent at the wrong time, people are prone to being more anxious.");
        lessonX.add(58);
        lessonY.add(80);
        lessonFont.add(12);

        lesson.add("Here are two very common, specific reasons.");
        lessonX.add(210);
        lessonY.add(80);
        lessonFont.add(15);

        lesson.add("Workload: The increase in workload is the most common source of anxiety in upper elementary and middle schoolers.");
        lessonX.add(60);
        lessonY.add(80);
        lessonFont.add(10);

        lesson.add("Homework, exams, and large projects come in heavier loads and mean more than they did before.");
        lessonX.add(75);
        lessonY.add(80);
        lessonFont.add(11);

        lesson.add("Self-discovery: Upper elementary and middle school is the time to find who you are and change it as you see fit.");
        lessonX.add(60);
        lessonY.add(80);
        lessonFont.add(10);

        lesson.add("While you may feel more independence, feelings of uncertainty and growing pains may be causing you anxiety.");
        lessonX.add(78);
        lessonY.add(80);
        lessonFont.add(10);

        lesson.add("Losing some friends, meeting people, exploring, and being unsure about your choices make this a challenging time.");
        lessonX.add(63);
        lessonY.add(80);
        lessonFont.add(10);

        lesson.add("Anxiety presents itself through physical and emotional symptoms. Here are some examples of both.");
        lessonX.add(65);
        lessonY.add(80);
        lessonFont.add(12);
//-------------------------
        lesson.add("Physical: consistent stomach aches, headaches, rapid heartbeat");
        lessonX.add(148);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("shortness of breath, nausea, irritability, sleeplessness");
        lessonX.add(170);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("nightmares, low energy, inability to sit still, and tantrums.");
        lessonX.add(155);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("Emotional: constantly discussing fears and worries");
        lessonX.add(190);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("spending excessive time alone, avoiding socialization");
        lessonX.add(185);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("worsening educational performance, and truancy.");
        lessonX.add(212);
        lessonY.add(80);
        lessonFont.add(14);

        lesson.add("Now that you understand a bit more about your anxiety, it's time to fight the monsters lurking in the forest.");
        lessonX.add(73);
        lessonY.add(80);
        lessonFont.add(10);

        lesson.add("But don't worry; they're nothing but your own anxiety.");
        lessonX.add(156);
        lessonY.add(80);
        lessonFont.add(15);

        lesson.add("They might look scary, but you'll be a master of defeating your dread in no time at all!");
        lessonX.add(48);
        lessonY.add(80);
        lessonFont.add(13);

        lesson.add("You have completed Level 1! Press continue or quit on the next screen.");
        lessonX.add(117);
        lessonY.add(80);
        lessonFont.add(13);
    }

    /**
     * Update the graphics
     */
    public void start1() {
        revalidate();
        repaint();
        while (!end) ;
    }
}
