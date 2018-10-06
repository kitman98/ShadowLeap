import org.newdawn.slick.Input;

/**
 * This class represents the second most basic Vehicle. The same interactions as the Bus. But Racecar moves faster
 * (Surprising).
 */
public class Racecar extends Vehicle {

    private static final String ASSET_PATH = "assets/racecar.png";
    private static final float SPEED = 0.50f;

    /**
     * Constructor for the Racecar class
     * @param x             X position of the Racecar
     * @param y             Y position of the Racecar
     * @param moveRight     Direction of movement of Racecar
     */
    public Racecar(float x, float y, boolean moveRight) {
        super( ASSET_PATH,x, y, moveRight, new String[] {Sprite.HAZARD});
    }

    @Override
    public void update(Input input, int delta) {
        move(SPEED * delta * (getMoveRight() ? 1 : -1), 0);

        // check if the vehicle has moved off the screen
        if (!onScreen(getX(),getY())) {
            setX(getInitialX());
        }
    }

}
