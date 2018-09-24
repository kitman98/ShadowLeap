import org.newdawn.slick.Input;

public class LongLog extends Vehicle {

    private final static String ASSET_PATH = "assets/longlog.png";
    private final static float SPEED = 0.07f;

    public LongLog(float x, float y, boolean moveRight) {
        super(ASSET_PATH, x, y, moveRight, new String[] {Sprite.DRAGS});
    }

    @Override
    public void update(Input input, int delta) {
        move(SPEED * delta * (getMoveRight() ? 1 : -1), 0);

        // check if the vehicle has moved off the screen
        if (getX() > App.SCREEN_WIDTH + getImage().getWidth() || getX() < -World.TILE_SIZE / 2
                || getY() > App.SCREEN_HEIGHT + World.TILE_SIZE / 2 || getY() < -World.TILE_SIZE / 2) {
            setX(getInitialX());
        }
    }

    @Override
    public float getSpeed() {return SPEED;}
}
