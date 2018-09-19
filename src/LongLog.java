import org.newdawn.slick.Input;

public class LongLog extends RideableObject {

    private final static boolean rideable = true;

    public LongLog() {

    }

    /* inherited methods and methods from interfaces */
    public void update(Input input, int delta) {

    }

    public void push(Player player) {

    }

    public void render() {
        if  (this.isRideable()) {
            super.getImage().draw(super.getPosition().getxPos(), super.getPosition().getyPos());
        }
    }

    /* getters */

    public boolean isRideable() {
        return this.rideable;
    }
}
