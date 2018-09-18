import org.newdawn.slick.Input;

public abstract class MoveableObject extends Sprite implements Moveable{


    private int direction;

    /* getters */
    public int getDirection() {
        return this.direction;
    }

    /* setters */
    public void setDirection(boolean direction) {
        if (direction == true) {
            this.direction = 1;
        }

        else {
            this.direction = -1;
        }

    }

}
