import org.newdawn.slick.Input;

/**
 * This class represents a vehicle that the Player can ride. Standing on a Log protects the player from hazards. Player
 * is also dragged along with the Log when standing on the Log.
 */
public class Log extends Vehicle {

    private static final String ASSET_PATH = "assets/log.png";
    private static final float SPEED = 0.1f;

    /**
     * Constructor for Log class
     * @param x             X position of the Log
     * @param y             Y position of the Log
     * @param moveRight     Direction of movement of the Log
     */
    public Log(float x, float y, boolean moveRight) {
        super(ASSET_PATH, x, y, moveRight,new String[] {Sprite.DRAGS});
    }

    @Override
    public void update(Input input, int delta) {
        move(SPEED * delta * (getMoveRight() ? 1 : -1), 0);

        // check if the vehicle has moved off the screen
        if (getX() > App.SCREEN_WIDTH + getImage().getWidth() || getX() < -getImage().getWidth()
                || getY() > App.SCREEN_HEIGHT + World.TILE_SIZE / 2 || getY() < -World.TILE_SIZE / 2) {
            setX(getInitialX());
        }
    }

    @Override
    public final float getSpeed() { return SPEED;}
}
