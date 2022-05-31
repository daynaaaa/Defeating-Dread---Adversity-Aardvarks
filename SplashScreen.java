/**
 * Authors: Danya C, Mya E, Sulagna N
 * Teacher: Ms. Krasteva
 * Date: May 25, 2022
 * Desc: "SplashScreen" class that will run the splash screen when called
 *
 * Version #1 May 25 - May 27 - [30 mins]:
 *    Danya - framework
 *
 */

//import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SplashScreen extends JPanel implements ActionListener{

    private volatile boolean a;
    Timer tm;
    int x=0, speed=2;
    @Override
    public void actionPerformed(ActionEvent arg){
       x+=speed;
       repaint();
    }

    public SplashScreen(){
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
           @Override
           public void actionPerformed(ActionEvent e) {
               a=true;
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
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color backgroundColour = new Color(46, 23, 110);
        setBackground(backgroundColour);
        g.setColor(new Color(159, 84, 43)); //brown like an aardvark hehe
        g.fillRect(x, 30, 50, 50);
        tm=new Timer(100, this);
        tm.start();
        if(x<750) {
            x++;
            //System.out.println("x is less than 800");
        }
        
        //System.out.println(x);
    }
    
    /**
     * update the graphics/start
     */
    public void start() {
        revalidate();
        repaint();
        while (!a);
    }

    
}
