import org.newdawn.slick.Input;

public class Log extends Vehicle {

    private static final String ASSET_PATH = "assets/log.png";
    private static final float SPEED = 0.1f;

    public Log(float x, float y, boolean moveRight) {
        super(ASSET_PATH, x, y, moveRight,new String[] {Sprite.DRAGS});
    }

    @Override
    public void update(Input input, int delta) {
        move(SPEED * delta * (getMoveRight() ? 1 : -1), 0);

        // check if the vehicle has moved off the screen
        if (getX() > App.SCREEN_WIDTH + World.TILE_SIZE / 2 || getX() < -World.TILE_SIZE / 2
                || getY() > App.SCREEN_HEIGHT + World.TILE_SIZE / 2 || getY() < -World.TILE_SIZE / 2) {
            setX(getInitialX());
        }
    }

    @Override
    public final float getSpeed() { return SPEED;}
}
