import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/**
The class circle has the main method which creates the Frame, sets the title
and visiblity, and adds the default close operation of exiting when the Frame
is closed.

@author Heath S
**/
public class Circle{
    public static void main(String[] args){
        MyFrame f = new MyFrame();
        f.setTitle("Circle Game");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
/**
The myFrame class just creates a panel inside of it and then adds the panel to
the frame, sets the size to be 500 by 500, and does not allow the user to resize
panel.
**/
class MyFrame extends JFrame{
    MyPanel p;
    public MyFrame(){
        p = new MyPanel();
        add(p);
        setSize(500, 500);
        setResizable(false);
    }
}

/**
The MyPanel class draws a circle with the height and width of 30 and location of
x and y. These values are determined randomly everytime the mouse gets close to
the circle.
**/
class MyPanel extends JPanel{
    public int x = (int) (Math.random() * 400);
    public int y = (int) (Math.random() * 400);

    public MyPanel(){
        addMouseMotionListener(new MouseMotionAdapter() {
            /**
            This method gets the pointerinfo of the mouse then gets the exact
            location of it. Then in the if statement, the distance formula is
            performed with some modifications to the values of the circle. This
            is because the circle is drawn from the point in the top right corner
            of the box that contains it. Then the circle is repainted.

            @param e a mouse event
            **/
            public void mouseMoved(MouseEvent e){
                PointerInfo a = MouseInfo.getPointerInfo();
                Point b = a.getLocation();
                int mx = (int) b.getX();
                int my = (int) b.getY();
                if (Math.sqrt(Math.pow(mx - (x + 30), 2) + Math.pow(my - (y + 30), 2)) < 30){
                    repaint();
                }
            }

        });
    }
    /**
    This is the method that paints the circle. It uses graphics and 2d Graphics
    in order to accomplish this. A new random point for the circle is also
    generated each time it is drawn. The method is draw oval.

    @param g the graphics
    **/
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        x = (int) (Math.random() * 450);
        y = (int) (Math.random() * 450);
        g2.fillOval(x,y,30,30);
    }
}
