import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
The class button just makes the Frame, sets the title, makes it visible, and
sets the close operation to exit the program when the frame is closed.
**/
public class Button{
    public static void main(String[] args){
        MyFrame f = new MyFrame();
        f.setTitle("Print Letter");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
/**
The MyFrame class extends JFrame in order to make a Frame. Inside this frame,
a panel object is intialized, the size is set to 500 by 500, and the size is
not allowed to be changed. Then a keylisterner is created along with a
MouseListener.
**/
class MyFrame extends JFrame{
    public MyPanel p = new MyPanel();
    public MyFrame(){
        add(p);
        setSize(500, 500);
        setResizable(false);
        addKeyListener(new KeyAdapter(){
            /**
            Every time a key is pressed this keylistener gets that key, gets
            the string representaion of the key, then puts it into the addTo
            method of the panel.

            @param e a KeyEvent
            **/
            public void keyPressed(KeyEvent e){
                String c = e.getKeyText(e.getKeyCode());
                p.addTo(c);
            }
        });
        addMouseListener(new MouseAdapter() {
            /**
            This mouselistener gets what button is clicked and then puts the
            button into the panel's reset method.

            @param e a MouseEvent
            **/
            public void mouseClicked(MouseEvent e){
                    p.reset(e.getButton());
                    repaint();
                }
        });


    }
}
/**
The MyPanel class extends JPanel in order to create a panel that can be used
to paint the characters. It paints the characters at a randomly generated point.
**/
class MyPanel extends JPanel{
    private ArrayList<String> charArray = new ArrayList<String>();
    private ArrayList<Integer> xArray = new ArrayList<Integer>();
    private ArrayList<Integer> yArray = new ArrayList<Integer>();
    public int i = 0;
    /**
    The addTo method is used to add the characters and a number to an array in
    a certain place. The same is done with the randomly generated points so that
    way the points are kept with their character counterparts. The panel is
    repainted and i increases by 1 for the next char inputed.

    @param s a string representaion of the char
    **/
    public void addTo(String s){
        charArray.add(i, s);
        xArray.add(i, (int) (Math.random() * 450));
        yArray.add(i, (int) (Math.random() * 450));
        i++;
        repaint();
    }
    /**
    Adds the string char to the char array.

    @param c the string representaion of the char
    **/
    public void addChar(String c){
        charArray.add(c);
    }
    /**
    Adds the x coordinate to the X array.

    @param x the x coordinate
    **/
    public void addPointX(int x){
        xArray.add(x);
    }
    /**
    Adds the y coordinate to the Y array.

    @param y the y coordinate
    **/
    public void addPointY(int y){
        yArray.add(y);
    }
    /**
    This method is used to reset the panel. If the mouse button clicked is
    the right click or "3" then it will clear all the arrays, set i back to 0,
    and then repaint the panel.

    @param button the button pressed on the mouse expressed as an integer.
    **/
    public void reset(int button){
        if(button == 3){
            charArray.clear();
            xArray.clear();
            yArray.clear();
            i = 0;
            repaint();
        }
    }
    /**
    This is the method that actually draws the characters on the panel. It has
    counter which is used in the while loop to just draw everything in the arrays
    until there is nothing left. It uses the drawString method to do this. It takes
    the string and the coordinates from the arrays. 

    @param g the graphics
    **/
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int counter = 0;
        Graphics2D g2 = (Graphics2D) g;
        while(counter < charArray.size()){
            g2.drawString(charArray.get(counter), xArray.get(counter), yArray.get(counter));
            counter++;
        }
    }
}
