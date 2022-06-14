/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: June 10, 2022
 * Desc: "Level2Quiz" class that will run the quiz in Level 2 when called
 * <p>
 * <p>
 * Version #3 May 30 - June 3 [5 hrs]
 * Sulagna - Did some of the logic, input, and graphics for this quiz
 * <p>
 * Final (#4) June 6 - June 10 [7 hrs]
 * Sulagna - Worked on cleaning up the graphics, changed the input from mouse to keyboard, and debugging
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Level2Quiz extends JPanel {
    /**
     * Holds all five questions; Question objects hold details about the question
     */
    private ArrayList<Question> qs;
    /**
     * Used to determine what is displayed on the screen; changes with keyboard and mouse input
     */
    private int count;
    /**
     * Whether the user has chosen an option
     */
    private int optionChosen;
    /**
     * Whether the user has clicked their mouse on a button
     */
    private boolean mousePressed;
    /**
     * Holds which of the 5 were answered wrong or right
     */
    private boolean[] correctOrNot;
    /**
     * Set to true when the game ends
     * It is important for this to be declared volatile so the while loop will to notice when the value changes
     */
    private volatile boolean end = false;


    /**
     * Green displayed when the correct option is clicked
     */
    Color optionCorrect = new Color(27, 160, 82);
    /**
     * Red displayed when the incorrect option is clicked
     */
    Color optionIncorrect = new Color(201, 24, 19);

    /**
     * Constructs the quiz; includes keyboard and mouse input and calls repaint()
     */
    public Level2Quiz() {
        qs = new ArrayList<>();
        fillArrayLists();
        count = -1;
        correctOrNot = new boolean[5];
        repaint();

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < 0 || (count == qs.size() && !allAnswersCorrect()))
                    count++;
                else if(count == qs.size() && allAnswersCorrect())
                    end = true;
                repaint();
                System.out.println(count);
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (!(count < 0 || (count == qs.size() && !allAnswersCorrect()))) {
                    if (x >= 25 && x <= 25 + 750) {
                        if (y >= 150 && y <= 150 + 75 && count != -1) {
                            mousePressed = true;
                            optionChosen = 0;
                            repaint();
                        }
                        if (y >= 250 && y <= 250 + 75 && count != -1) {
                            mousePressed = true;
                            optionChosen = 1;
                            repaint();
                        }
                        if (y >= 350 && y <= 350 + 75 && count != -1) {
                            mousePressed = true;
                            optionChosen = 2;
                            repaint();
                        }
                    } else if (count >= 0 && count < qs.size())
                        count--;
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (count < qs.size() && mousePressed && !(count < 0 || (count == qs.size() && !allAnswersCorrect()))) {
                    count++;
                    repaint();
                }
                mousePressed = false;
            }
        });
    }

    /**
     * Fills qs with Question objects
     */
    public void fillArrayLists() {
        String q = "What exactly is anxiety?";
        int qx = 230;
        int qy = 82;
        int qf = 20;
        String[] o = {"An emotion characterized by feelings of tension and worried thoughts.",
                "Extreme anger at and jealously of someone.",
                "A persistent feeling of sadness and loss of interest."};
        int[] ox = {125, 225, 181};
        int[] oy = {194, 294, 394};
        int[] of = {14, 14, 14};
        int a = 0;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));

        q = "Which of the following is not a symptom of anxiety?";
        qx = 75;
        qy = 80;
        qf = 20;
        o = new String[]{"Irritability.",
                "Little sleep.",
                "Steady breathing."};
        ox = new int[]{340, 340, 325};
        oy = new int[]{194, 294, 394};
        of = new int[]{15, 15, 15};
        a = 2;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));


        q = "Middle schoolers may have the hardest time with anxiety because…";
        qx = 65;
        qy = 80;
        qf = 16;
        o = new String[]{"They have a lighter workload.",
                "They are going through a period of self-discovery.",
                "They are more likely to throw tantrums."};
        ox = new int[]{270, 175, 220};
        oy = new int[]{194, 294, 394};
        of = new int[]{15, 15, 15};
        a = 1;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));


        q = "What is environmental anxiety?";
        qx = 200;
        qy = 82;
        qf = 20;
        o = new String[]{"The worry that climate change is taking over sooner than we thought.",
                "Learned anxiety from peers and caregivers around you.",
                "Anxiety after a stressful or traumatic event occurs."};
        ox = new int[]{128, 188, 192};
        oy = new int[]{194, 294, 394};
        of = new int[]{14, 14, 14};
        a = 2;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));


        q = "Which is true about a person with an anxiety disorder?";
        qx = 85;
        qy = 82;
        qf = 19;
        o = new String[]{"They feel anxious even in situations where there's nothing to anxious about.",
                "They absolutely need medication to treat their anxiety.",
                "Their anxiety disorder is their own fault and they need to get over it."};
        ox = new int[]{100, 180, 120};
        oy = new int[]{194, 294, 394};
        of = new int[]{14, 14, 14};
        a = 0;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));
    }

    /**
     * Inner class used to make questions and hold info about them
     */
    public class Question {
        /**
         * Holds the index in options[] of the answer
         */
        public int answerIndex;
        /**
         * Holds the actual question
         */
        public String question;
        /**
         * X-position for the question text
         */
        public int questionX;
        /**
         * Y-position for the question text
         */
        public int questionY;
        /**
         * Question's font size
         */
        public int questionF;
        /**
         * Holds the options text
         */
        public String[] options;
        /**
         * The options' X-positions
         */
        public int[] optionsX;
        /**
         * The options' Y-positions
         */
        public int[] optionsY;
        /**
         * The options' font sizes
         */
        public int[] optionsF;

        /**
         * Constructs a question
         *
         * @param q  the question
         * @param qx question x-coordinate
         * @param qy question y-coordinate
         * @param qf question font size
         * @param o  the options
         * @param ox options' x-coordinates
         * @param oy options' y-coordinates
         * @param of options' font sizes
         * @param a  answer index
         */
        public Question(String q, int qx, int qy, int qf, String[] o, int[] ox, int[] oy, int[] of, int a) {
            question = q;
            questionX = qx;
            questionY = qy;
            questionF = qf;
            options = o;
            optionsX = ox;
            optionsY = oy;
            optionsF = of;
            answerIndex = a;
        }
    }

    /**
     * Draw the graphics
     *
     * @param g the graphics to be drawn
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit t = Toolkit.getDefaultToolkit();
        Image bg = t.getImage("background2revised.jpg");
        g.drawImage(bg, 0, 0, this);
        Image ps = t.getImage("PlayerSadFlipped.png");


        Color gray = new Color(110, 110, 110);
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(25, 25, 750, 100, 25, 25);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", Font.BOLD, 13));

        if (count == -1) {
            g.drawString("You'll have to get 5/5 to move on, but you can retry as many times as needed.", 96, 80);
            g.drawImage(ps, 410, 200, this);
        } else if (count < qs.size()) {
            g.drawImage(bg, 0, 0, this);
            g.setColor(Color.DARK_GRAY);
            g.fillRoundRect(25, 25, 750, 100, 25, 25);
            g.setColor(Color.DARK_GRAY);
            if (mousePressed && optionChosen == qs.get(count).answerIndex && optionChosen == 0) {
                g.setColor(optionCorrect);
                correctOrNot[count] = true;
            } else if (mousePressed && optionChosen != qs.get(count).answerIndex && optionChosen == 0) {
                correctOrNot[count] = false;
                g.setColor(optionIncorrect);
            }
            g.fillRoundRect(25, 150, 750, 75, 50, 50);

            g.setColor(Color.DARK_GRAY);
            if (mousePressed && optionChosen == qs.get(count).answerIndex && optionChosen == 1) {
                g.setColor(optionCorrect);
                correctOrNot[count] = true;
            } else if (mousePressed && optionChosen != qs.get(count).answerIndex && optionChosen == 1) {
                correctOrNot[count] = false;
                g.setColor(optionIncorrect);
            }
            g.fillRoundRect(25, 150 + 100, 750, 75, 50, 50);

            g.setColor(Color.DARK_GRAY);
            if (mousePressed && optionChosen == qs.get(count).answerIndex && optionChosen == 2) {
                g.setColor(optionCorrect);
                correctOrNot[count] = true;
            } else if (mousePressed && optionChosen != qs.get(count).answerIndex && optionChosen == 2) {
                correctOrNot[count] = false;
                g.setColor(optionIncorrect);
            }
            g.fillRoundRect(25, 150 + 200, 750, 75, 50, 50);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier", Font.BOLD, qs.get(count).questionF));
            g.drawString(count + 1 + ". " + qs.get(count).question, qs.get(count).questionX, qs.get(count).questionY);
            g.setFont(new Font("Courier", Font.BOLD, qs.get(count).optionsF[0]));
            g.drawString(qs.get(count).options[0], qs.get(count).optionsX[0], qs.get(count).optionsY[0]);
            g.setFont(new Font("Courier", Font.BOLD, qs.get(count).optionsF[1]));
            g.drawString(qs.get(count).options[1], qs.get(count).optionsX[1], qs.get(count).optionsY[1]);
            g.setFont(new Font("Courier", Font.BOLD, qs.get(count).optionsF[2]));
            g.drawString(qs.get(count).options[2], qs.get(count).optionsX[2], qs.get(count).optionsY[2]);

        }

        g.setFont(new Font("Courier", Font.BOLD, 15));
        if (count == qs.size() && !allAnswersCorrect()) {
            g.drawString("Great try, but let's try one more time and make sure we get them all right!", 60, 65);
            g.drawString("Press space to try again.", 280, 100);
            count = -1;
            correctOrNot = new boolean[5];
            g.drawImage(ps, 410, 200, this);
        } else if (count == qs.size() && allAnswersCorrect()) {
            g.drawString("Amazing job! Looks you know your stuff, little sibling.", 160, 65);
            g.drawString("Let's start fighting those monsters!", 225, 100);
            g.drawImage(ps, 410, 200, this);
        }
        optionChosen = -1;
    }

    /**
     * Checks if all the answers are correct
     *
     * @return true if all values in correctOrNot[] are true, false otherwise
     */
    private boolean allAnswersCorrect() {
        for (boolean cn : correctOrNot) {
            if (!cn)
                return false;
        }
        return true;
    }

    /**
     * Checks if the level is over
     *
     * @return if the level is over as a boolean
     */
    public boolean isEnd() {
        return end;
    }

    /**
     * run the level 2 quiz
     */
    public void startQuiz() {
        revalidate();
        repaint();
        while (!end) ;
    }
}
