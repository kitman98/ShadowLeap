import org.newdawn.slick.Input;

public class Bulldozer extends MovableObject implements Pushes{

    private final static int speed = 5/100;

    public Bulldozer() {

    }

    /* inherited methods and methods from interfaces */

    public void update(Input input, int delta) {
        super.getPosition().setxPos(super.getPosition().getxPos() + delta* this.getSpeed() *this.getDirection());
    }

    public void push(Player player) {

    }

    /* getters */
    public int getSpeed() {
        return this.speed;
    }
}
