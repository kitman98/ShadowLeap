import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player extends Sprite implements Moveable, Bounded {

    private static int speed = 1;

    /* constructors */
    public Player(String imageSrc, float x, float y) throws SlickException {
        super.setImageSrc(imageSrc);
        super.setImage(imageSrc);

        Position position = new Position((int) x, (int) y);

        super.setPosition(position);
    }

    public Player(String imageSrc, Position position) throws SlickException {
        super.setImageSrc(imageSrc);
        super.setImage(imageSrc);
        super.setPosition(position);
    }

    /* updates player position */
    public void update(Input input, int delta) {

        Position current = super.getPosition();

        if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {

            current.setyPos(current.getyPos() - speed*delta);

            super.setPosition(current);

        }

        if (input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S)) {

            current.setyPos(current.getyPos() + speed*delta);

            super.setPosition(current);

        }

        if (input.isKeyDown((Input.KEY_LEFT)) || input.isKeyDown(Input.KEY_A)) {

            current.setxPos(current.getxPos() - speed*delta );

            super.setPosition(current);
        }

        if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {

            current.setxPos(current.getxPos() + speed*delta);

            super.setPosition(current);
        }
    }

    /* getter */
    public int getSpeed() {
        return speed;
    }
}
