import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FroggerMain extends JPanel {

    //instance fields for the general environment
    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;
    private Timer timer;
    private boolean[] keys;

    //instance fields for frogger.
    private Sprite frog;
    private ArrayList<Sprite> obstacles;

    public FroggerMain(){

        keys = new boolean[512]; //should be enough to hold any key code.
        //TODO: initialize the instance fields.

        frog = new Frog();
        //TODO: init obstacles arraylist
        //TODO: add obstacles - cars and stuff


        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //move the frog
                if(keys[KeyEvent.VK_W]){
                    frog.setDir(Sprite.NORTH);
                    frog.update();
                    keys[KeyEvent.VK_W] = false; //probably.  Makes 1 move per button press.
                }
                if(keys[KeyEvent.VK_A]){
                    frog.setDir(Sprite.WEST);
                    frog.update();
                    keys[KeyEvent.VK_A] = false; //probably.  Makes 1 move per button press.
                }
                //TODO: implement other directions

                //TODO: update each obstacle

                //TODO: check for collisions - frog vs obstacles


                repaint(); //always the last line.  after updating, refresh the graphics.
            }
        });
        timer.start();

        /*
        You probably don't need to modify this keyListener code.
         */
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {/*intentionally left blank*/ }

            //when a key is pressed, its boolean is switch to true.
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = true;
            }

            //when a key is released, its boolean is switched to false.
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = false;
            }
        });

    }

    //Our paint method.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        frog.draw(g2);


        //TODO: draw all the obstacles.

    }

    //sets ups the panel and frame.  Probably not much to modify here.
    public static void main(String[] args) {
        JFrame window = new JFrame("Frogger!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 22 due to title bar.

        FroggerMain panel = new FroggerMain();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}