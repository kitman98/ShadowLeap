import org.newdawn.slick.Input;

/**
 * This class is a hazard to the Player. If the Player comes into contact with a Bike, the Player loses a life and the
 * position of the player is reset. The bike also turns around instead of going in a single direction.
 */
public class Bike extends Vehicle{


    private static final String ASSET_PATH = "assets/bike.png";
    private static final float SPEED = 0.2f;

    private static final float LEFT_BOUND = 24f;
    private static final float RIGHT_BOUND = 1000f;

    /**
     * This is the constructor for Bike
     * @param x             X coordinate of the Bike
     * @param y             Y coordinate of the Bike
     * @param moveRight     Direction of Bike movement
     */
    public Bike(float x, float y, boolean moveRight) {
        super( ASSET_PATH,x, y, moveRight, new String[] {Sprite.HAZARD});
    }

    @Override
    public void update(Input input, int delta) {
        move(SPEED * delta * (getMoveRight() ? 1 : -1), 0);

        // check if the bike has reached the turn around point
        if (getX() < LEFT_BOUND + getImage().getWidth() && !getMoveRight()
                || getX() > RIGHT_BOUND -getImage().getWidth() && getMoveRight() ) {
           changeDirection();
        }
    }


}
