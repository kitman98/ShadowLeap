import org.newdawn.slick.Input;

/**
 * This class is the same as a Log, but this Log is long. This makes it a LongLog.
 */
public class LongLog extends Vehicle {

    private final static String ASSET_PATH = "assets/longlog.png";
    private final static float SPEED = 0.07f;

    /**
     * Constructor for LongLog
     * @param x             X position of the LongLog
     * @param y             Y position of the LongLog
     * @param moveRight     Direction of movement of the LongLog
     */
    public LongLog(float x, float y, boolean moveRight) {
        super(ASSET_PATH, x, y, moveRight, new String[] {Sprite.DRAGS});
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
    public float getSpeed() {return SPEED;}
}
