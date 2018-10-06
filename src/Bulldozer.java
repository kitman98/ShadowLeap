import org.newdawn.slick.Input;

/**
 * This class is a moving solid vehicle. Players cannot move into the Bulldozer and will be pushed in the same
 * direction of movement as the Bulldozer if the player stands in the way of the Bulldozer. If the player is pushed off
 * the screen, the Player loses a life and resets position.
 */
public class Bulldozer extends Vehicle {

    private static final String ASSET_PATH = "assets/bulldozer.png";
    private static final float SPEED = 0.05f;


    /**
     * Constructor for Bulldozer
     * @param x             X coordinate of the Bulldozer
     * @param y             Y coordinate of the Bulldozer
     * @param moveRight     Direction of Bulldozer movement
     */
    public Bulldozer(float x, float y, boolean moveRight) {
        super(ASSET_PATH, x, y, moveRight, new String[] {Sprite.PUSHES, Sprite.SOLID});
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
    public final float getSpeed() {
        return SPEED;
    }
}
