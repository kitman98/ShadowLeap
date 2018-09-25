import org.newdawn.slick.Input;

public class Turtle extends Vehicle {

    private static final String ASSET_PATH = "assets/turtles.png";
    private static final float SPEED = 0.085f;
    private static boolean SUBMERGED = false;

    public Turtle(float x, float y, boolean moveRight) {
        super(ASSET_PATH, x, y, moveRight, new String[] {Sprite.DRAGS, Sprite.SUBMERGES});
    }

    public void update(Input input, int delta) {
        move(SPEED * delta * (getMoveRight() ? 1 : -1), 0);

        // check if the vehicle has moved off the screen
        if (getX() > App.SCREEN_WIDTH + getImage().getWidth() || getX() < -getImage().getWidth()
                || getY() > App.SCREEN_HEIGHT + World.TILE_SIZE / 2 || getY() < -World.TILE_SIZE / 2) {
            setX(getInitialX());
        }
    }

    public final void changeState() {
        SUBMERGED = !SUBMERGED;
    }

    public final boolean getState() {
        return this.SUBMERGED;
    }

    public final float getSpeed() {
        return SPEED;
    }
}
