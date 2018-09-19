import org.newdawn.slick.Input;

public class Racecar extends MovableObject{

    private static final int speed = 1/2;

    public Racecar() {

    }

    public void update(Input input, int delta) {
        super.getPosition().setxPos(super.getPosition().getxPos() + delta* this.getSpeed() *this.getDirection());

    }

    /* getters */
    public int getSpeed() {
        return this.speed;
    }


}
