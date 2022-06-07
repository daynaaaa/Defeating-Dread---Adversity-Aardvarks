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

    public Level1() {
        lesson = new ArrayList<>();
        lessonX = new ArrayList<>();
        lessonY = new ArrayList<>();
        lessonFont = new ArrayList<>();

        fillArrayList();
        repaint();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 0 && e.getX() < 800 && e.getY() > 0 && e.getY() < 500) {
                    repaint();
                    count++;
                    System.out.println(count);
                }
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
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("aa background 1_00_00.jpg");
        g.drawImage(i, 120,100,this);

        Color backgroundColour = new Color(6, 115, 113);
        setBackground(backgroundColour);
        g.setColor(new Color(0, 22, 0));
        g.fillOval(50, 50, 50, 100);
        g.fillRect(25, 25, 750, 100);
        g.setFont(new Font("Courier", Font.BOLD, 33));
        g.setColor(Color.white);
        g.drawString(lesson.get(count), 25, 25);
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
        lesson.add("First, it's time for you to learn all about anxiety.");
        lessonX.add(25);
        lessonY.add(25);

        lesson.add("We'll start with what anxiety even is.");
        lessonX.add(25);
        lessonY.add(25);

        lesson.add("Anxiety is \"an emotion characterized by feelings of tension," +
                " worried thoughts and physical changes like increased blood pressure\".\n");
        lessonX.add(25);
        lessonY.add(25);

        lesson.add("Anxiety disorders in general make people frightened, distressed, or uneasy.\n");
        lessonX.add(25);
        lessonY.add(25);

        lesson.add("They feel this way even in situations where people without anxiety disorders would not feel that way.");
        lessonX.add(25);
        lessonY.add(25);

        lesson.add("There are many causes of anxiety.");
        lessonX.add(25);
        lessonY.add(25);

        lesson.add("Genetic: Children can inherit the tendency to constantly worry from parents.\n");
        lessonX.add(25);
        lessonY.add(25);

        lesson.add("Genetic: Children can inherit the tendency to constantly worry from parents.\n");
        lessonX.add(25);
        lessonY.add(25);

        lesson.add("Learned: Kids mimic behaviour around them.\nIf caregivers or many peers around them are anxious, they likely will be too.\n");
        lessonX.add(25);
        lessonY.add(25);

        lesson.add("Environmental: This is anxiety after a stressful event occurs. " +
                "Some examples are death, sickness, frequent moving, being bullied, and being abused.\n" +
                "Co-occurring conditions can worsen it (i.e. depression, ADHD, autism spectrum disorders, eating disorders, etc.).\n");
        lessonX.add(25);
        lessonY.add(25);


    }


}
