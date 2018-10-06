import org.newdawn.slick.Input;

/**
 * This class represents a generic hazard sprite. If the Player moves into a Bus, the player loses a life and the
 * position of the player is reset. Buses travel in a single direction and their position is reset if the bus moves off
 * the screen.
 */
public class Bus extends Vehicle {

    private static final String ASSET_PATH = "assets/bus.png";
    private static final float SPEED = 0.15f;

    /**
     * Constructor for Bus
     * @param x             X coordinate of the Bus
     * @param y             Y coordinate of the Bus
     * @param moveRight     Direction of Bus movement
     */
    public Bus(float x, float y, boolean moveRight) {
        super( ASSET_PATH,x, y, moveRight, new String[] {Sprite.HAZARD});
    }


    @Override
    public void update(Input input, int delta) {
        move(SPEED * delta * (getMoveRight() ? 1 : -1), 0);

        // check if the vehicle has moved off the screen
        if (getX() > App.SCREEN_WIDTH + getImage().getWidth()|| getX() < -getImage().getWidth()
                || getY() > App.SCREEN_HEIGHT + World.TILE_SIZE / 2 || getY() < -World.TILE_SIZE / 2) {
            setX(getInitialX());
        }
    }



}
