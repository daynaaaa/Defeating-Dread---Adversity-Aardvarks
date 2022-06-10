/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 16, 2022
 * Desc: "Level1" class that will run the first level when called
 * <p>
 * Version #2 May 16 - May 20 - [0.5 hrs]:
 * Sulagna - created preliminary Level1 class with some methods
 * Does not draw anything
 * Calls Talk(ArrayList<String>)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Level1 extends JPanel {

    private int count = 0;
    private ArrayList<String> lesson;
    private ArrayList<Integer> lessonX;
    private ArrayList<Integer> lessonY;
    private ArrayList<Integer> lessonFont;
    /**
     * If the level has ended
     */
    private volatile boolean end;

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
                if (count < lesson.size() - 1)
                    count++;
                repaint();
                System.out.println(count);
                if (count < lesson.size() - 1) count++;
                else end = true;
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
        getActionMap().put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count > 0)
                    count--;
                repaint();
                System.out.println("ITS WORKS ASLKDFJ");
            }
        });


//        addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                if (e.getX() > 0 && e.getX() < 800 && e.getY() > 0 && e.getY() < 500) {
//                    repaint();
//                    if (count < lesson.size() - 1)
//                        count++;
//                    else end = true;
//                }
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
//            }
//        });
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
//        g.fillRoundRect(25, 175, 300, 75, 50, 50);
//        g.fillRoundRect(25, 275, 300, 75, 50, 50);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", Font.BOLD, 20));
//        g.drawString("Continue", 125, 220);
//        g.drawString("Go Back", 128, 321);
        g.setFont(new Font("Courier", Font.BOLD, lessonFont.get(count)));
        g.drawString(lesson.get(count), lessonX.get(count), lessonY.get(count));
    }

    public static void main(String[] hallo) {
        Level1 l1 = new Level1();
        JFrame f = new JFrame("hallooo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l1);
        f.pack();
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

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
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("First, let's take some time for you to learn all about anxiety.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("We'll start with what anxiety even is.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Anxiety is \"an emotion characterized by feelings of tension," +
                " worried thoughts and physical changes\".\n");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Anxiety disorders in general make people frightened, distressed, or uneasy.\n");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("They feel this way even in situations where people without anxiety disorders would not feel that way.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("There are many causes of anxiety.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Genetic: Children can inherit the tendency to constantly worry from parents.\n");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Learned: Kids mimic behaviour around them.\nIf caregivers or many peers around them are anxious, they likely will be too.\n");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Environmental: This is anxiety after a stressful event occurs. " +
                "Some examples are death, sickness, frequent moving, being bullied, and being abused.\n" +
                "Co-occurring conditions can worsen it (i.e. depression, ADHD, autism spectrum disorders, eating disorders, etc.).\n");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Some examples are death, sickness, frequent moving, being bullied, and being abused.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Co-occurring conditions can worsen it (i.e. depression, ADHD, autism spectrum disorders, eating disorders, etc.).");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Biological: Neurotransmitters communicate with our body on how we're supposed to feel.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("If the wrong neurotransmitters are sent at the wrong time, people are prone to being more anxious and will feel physically worse on top of that.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Here are two very common, specific reasons.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Workload: The increase in workload is arguably the most common source of anxiety in upper elementary and middle school kids. " +
                "Homework, exams, and large projects come in heavier loads and mean more than they did in lower elementary school.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Self-discovery: Upper elementary and middle school is time to find who you are and what you care about and change it as you see fit." +
                "While you may feel more independence, feelings of uncertainty and growing pains may be causing you anxiety.\n" +
                "Losing some friends, meeting new people, exploring things you've never heard of, and being unsure about what you want to do all play a role in making this a challenging time.\n");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Anxiety presents itself through physical and emotional symptoms. Continue for some examples of both.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Physical: consistent stomach aches, headaches, rapid heartbeat, shortness of breath, nausea, irritability, sleeplessness" +
                "nightmares, low energy, inability to sit still, and tantrums.\n");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Emotional: constantly discussing fears and worries, spending excessive time alone, avoiding socialization, " +
                "worsening educational performance, and truancy.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("Now that you understand a bit more about your anxiety, it's time to fight the monsters lurking in the forest.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("But don't worry; they're nothing but your own anxiety. They might look scary, but you'll be a master of defeating your dread in no time at all!");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("The monsters you see lurking around the forest are nothing more than your anxiety.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);

        lesson.add("You have completed Level 1! Press Q to quit or any other key to continue.");
        lessonX.add(25);
        lessonY.add(25);
        lessonFont.add(20);
    }

    /**
     * update the graphics
     */
    public void start1() {
        revalidate();
        repaint();
        while (!end) ;
    }
}