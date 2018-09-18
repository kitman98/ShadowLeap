import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Bus extends Sprite implements Moveable{

    private static int speed = 15/100;
    private int direction;

    public Bus(String imageSrc, float x, float y, boolean direction) throws SlickException {
        super.setImageSrc(imageSrc);
        super.setImage(imageSrc);

        Position position = new Position((int) x, (int) y);

        super.setPosition(position);
    }

    public Bus(String imageSrc, Position position, boolean direction) throws SlickException {
        super.setImageSrc(imageSrc);
        super.setImage(imageSrc);
        super.setPosition(position);
    }

    /* updater */
    public void update(Input input,int delta) {
        Position current = super.getPosition();
        current.setxPos(current.getxPos() + delta* this.getSpeed() *this.getDirection());
    }

    /* getters */
    public int getSpeed() {
        return this.speed;
    }

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
