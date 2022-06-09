import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class Level2Quiz extends JPanel {
    private ArrayList<Question> qs;
    private int count;
    private int optionChosen;
    private boolean mousePressed;
    private int score;
    Color optionCorrect = new Color(27, 160, 82);
    Color optionIncorrect = new Color(201, 24, 19);

    public Level2Quiz() {
        qs = new ArrayList<>();
        fillArrayLists();
        count = -1;
        score = 0;
        repaint();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (x >= 25 && x <= 25 + 300) {
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

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(count<qs.size())
                    count++;
                repaint();
                mousePressed = false;
            }
        });
    }

    public void fillArrayLists() {
        String q = "What exactly is anxiety?";
        int qx = 100;
        int qy = 100;
        int qf = 20;
        String[] o = {"An emotion characterized by feelings of tension and worried thoughts.",
                "Extreme anger at and jealously of someone.",
                "A persistent feeling of sadness and loss of interest."};
        int[] ox = {10, 100, 100};
        int[] oy = {23, 434, 34};
        int[] of = {20, 20, 20};
        int a = 2;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));

        q = "Which of the following is not a symptom of anxiety?";
        qx = 100;
        qy = 100;
        qf = 20;
        o = new String[]{"Irritability.",
                "Little sleep.",
                "Steady breathing."};
        ox = new int[]{10, 100, 100};
        oy = new int[]{23, 434, 34};
        of = new int[]{20, 20, 20};
        a = 2;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));


        q = "Out of children below 14, middle schoolers may have the hardest time with anxiety because…";
        qx = 100;
        qy = 100;
        qf = 20;
        o = new String[]{"They have a lighter workload.",
                "They are going through a period of self-discovery.",
                "They are more likely to throw tantrums."};
        ox = new int[]{10, 100, 100};
        oy = new int[]{23, 434, 34};
        of = new int[]{20, 20, 20};
        a = 2;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));


        q = "Environmental anxiety is…";
        qx = 100;
        qy = 100;
        qf = 20;
        o = new String[]{"The worry that climate change is taking over sooner than we thought.",
                "Learned anxiety from peers and caregivers around you.",
                "Anxiety after a stressful or traumatic event occurs."};
        ox = new int[]{10, 100, 100};
        oy = new int[]{23, 434, 34};
        of = new int[]{20, 20, 20};
        a = 2;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));


        q = "In situations where there is nothing to be anxious about, people who have an anxiety disorder feel the same as people without one.";
        qx = 100;
        qy = 100;
        qf = 20;
        o = new String[]{"True.",
                "False.",
                "I don't know."};
        ox = new int[]{10, 100, 100};
        oy = new int[]{23, 434, 34};
        of = new int[]{20, 20, 20};
        a = 2;
        qs.add(new Question(q, qx, qy, qf, o, ox, oy, of, a));
    }

    private class Question {
        public int answerIndex;
        public String question;
        public int questionX;
        public int questionY;
        public int questionF;
        public String[] options;
        public int[] optionsX;
        public int[] optionsY;
        public int[] optionsF;

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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit t = Toolkit.getDefaultToolkit();
        Image bg = t.getImage("background2revised.jpeg");
        g.drawImage(bg, 0, 0, this);
        Image ps = t.getImage("PlayerSad.png");
        g.drawImage(ps, 410, 200, this);

        Color gray = new Color(110, 110, 110);
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(25, 25, 750, 100, 25, 25);
        g.setColor(Color.WHITE);

        if (count == -1) {
            g.drawString("Now, before you choose your three favourite tools, I will quiz you to make sure you understood everything I explained in Level 1." +
                    "You'll have to get 5/5 to move on, but you can retry as many times as needed.", 20, 20);
        } else if (count < qs.size()) {

            g.setColor(Color.DARK_GRAY);
            if (mousePressed && optionChosen == qs.get(count).answerIndex && optionChosen == 0) {
                g.setColor(optionCorrect);
                score++;
            } else if (mousePressed && optionChosen != qs.get(count).answerIndex && optionChosen == 0) {
                g.drawImage(ps, 410, 200, this);
                g.setColor(optionIncorrect);
            }
            g.fillRoundRect(25, 150, 300, 75, 50, 50);

            g.setColor(Color.DARK_GRAY);
            if (mousePressed && optionChosen == qs.get(count).answerIndex && optionChosen == 1) {
                g.setColor(optionCorrect);
                score++;
            } else if (mousePressed && optionChosen != qs.get(count).answerIndex && optionChosen == 1)
                g.setColor(optionIncorrect);
            g.fillRoundRect(25, 150 + 100, 300, 75, 50, 50);

            g.setColor(Color.DARK_GRAY);
            if (mousePressed && optionChosen == qs.get(count).answerIndex && optionChosen == 2) {
                g.setColor(optionCorrect);
                score++;
            } else if (mousePressed && optionChosen != qs.get(count).answerIndex && optionChosen == 2)
                g.setColor(optionIncorrect);
            g.fillRoundRect(25, 150 + 200, 300, 75, 50, 50);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier", Font.BOLD, qs.get(count).questionF));
            g.drawString(qs.get(count).question, 75, 75);
            g.drawString(qs.get(count).options[0],30,150);
            g.drawString(qs.get(count).options[1],30,250);
            g.drawString(qs.get(count).options[2],30,350);

        }

        if (count == qs.size() && score < 5) {
            g.drawString("Great try, but let's try one more time and make sure we get them all right!", 20, 20);
            count = -1;
            score  = 0;
        } else if (count == qs.size() && score == 5) {
            System.out.println("GOT 100%");
            g.drawString("Amazing job! Looks you know your stuff, little sibling.\nLet's start fighting those monsters!", 20, 20);
        }
        optionChosen = -1;
    }

    public static void main(String[] args) {
        Level2Quiz l2q = new Level2Quiz();
        JFrame f = new JFrame("hallooo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l2q);
        f.pack();
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
