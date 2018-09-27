import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
The class Menu takes the class MyFrame and actually displayes what the class
is, which is a frame and a panel. This frame has a Quit menu, that can quit the
program, and a Color menu which can change the background to three different colors.
It sets the title and makes the frame visible.

@author Heath S
**/
public class Menu{
    public static void main(String[] args){
        MyFrame f = new MyFrame();
        f.setTitle("Background Changer");
        f.setVisible(false);
    }
}
/**
The class MyFrame is an extension of the JFrame which is the frame that contains
the panel. The frame is needed because it contains the method and classes needed
for making the menu bar and adding the panel.
**/

class MyFrame extends JFrame{
    public MyPanel p = new MyPanel();
    public static final int HEIGHT = 500;
    public static final int WIDTH = 500;
    public static final int X = 100;
    public static final int Y = 100;

/**
This is the enum for the BackGround Color. It has the three colors Red, Blue,
and Green. It has a color attribute and a constructor for the color, and finally
a method in order change the background color to a color.
**/
    private enum BackgroundColor{
        Red(Color.RED), Blue(Color.BLUE), Green(Color.GREEN);
        private Color color;

        BackgroundColor(Color color){
            this.color = color;
        }
        /**
        @return the color
        **/
        Color color(){
            return color;
        }
    }

    public MyFrame(){
        setLocation(X,Y);
        setSize(WIDTH, HEIGHT);
        p.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayMenu();
        setSize(WIDTH, HEIGHT);
        add(p);
        setResizable(false);
    }
    /**
    This is the method that displays the menu. It creates a JMenuBar object
    and adds the Quit and Color menu too it.
    **/
    public void displayMenu(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new QuitMenu());
        menuBar.add(new ColorMenu());
        setJMenuBar(menuBar);
    }
    /**
    This is the class that creates the quitmenu. The super just takes the name
    for the menu and then a JMenuItem is created that has the name of the item.
    After that the action listener just says when the quit is selected then the
    program quits.
    **/
    private class QuitMenu extends JMenu{
        public QuitMenu() {
            super("Quit");
            JMenuItem quitMI = new JMenuItem("Quit");
            quitMI.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
            add(quitMI);
        }
    }
    /**
    This is the class that creates the color menu. The super again just takes the
    name for the menu and then a for loop is ran that runs for the colors that
    are in the length of the colors inside of the Background colors. It creates
    a menu item for each different color then adds it to the menu.
    **/
    private class ColorMenu extends JMenu{
        public ColorMenu(){
            super("Background Color");
            for(BackgroundColor color : BackgroundColor.values()){
                JMenuItem menuItem = new JMenuItem(color.name() + " Background");
                menuItem.addActionListener(new BackgroundColorListener(color));
                add(menuItem);
            }
        }
    }
    /**
    BackgroundColorListener implements ActionListener so it can be used to do
    an action when the color is selected in the menu. This action that it does
    is it sets the background color to the selected color. The constructor is there
    to construct the onject to be used in other code.
    **/
    private class BackgroundColorListener implements ActionListener{
        private BackgroundColor color;
        /**
        @param e an action event
        **/
        public void actionPerformed(ActionEvent e){
            p.setBackground(color.color());
        }
        /**
        @param color the color of the background
        **/
        public BackColorListener(BackgroundColor color){
            this.color = color;
        }
    }

}
/**
A panel is created so that the background can be changed. A frame can not do this
so that is why a panel is needed.
**/
class MyPanel extends JPanel{
}
