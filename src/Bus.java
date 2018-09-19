import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Bus extends MovableObject{


    private static int speed = 15/100;

    public Bus(String imageSrc, float x, float y, boolean direction) throws SlickException {
        super.setImageSrc(imageSrc);
        super.setImage(imageSrc);

        Position position = new Position((int) x, (int) y);

        super.setPosition(position);

        setDirection(direction);
    }

    public Bus(String imageSrc, Position position, boolean direction) throws SlickException {
        super.setImageSrc(imageSrc);
        super.setImage(imageSrc);
        super.setPosition(position);

        setDirection(direction);
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

    /* setters */


}
