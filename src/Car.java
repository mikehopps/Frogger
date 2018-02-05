import java.awt.*;

/**
 * Created by michael_hopps on 2/5/18.
 */
public class Car extends Sprite {

    public Car(int x, int y, int direction) {
        super(x, y, direction);
        setPic("car1.png", WEST);
        setSpeed(10); //GUESS?!

    }

    @Override
    public void update() {
        super.update();
        if (getLoc().x > FroggerMain.FRAMEWIDTH)
            setLoc(new Point(0, getLoc().y));
        Point loc = getLoc();
        Point newLoc = new Point(200, 400);
        System.out.println(loc.x);
    }
}
