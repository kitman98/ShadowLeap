import org.newdawn.slick.Input;

public class Turtle extends Vehicle {

    private static final String ASSET_PATH = "assets/turtles.png";
    private static final float SPEED = 0.085f;
    private static boolean SUBMERGED = false;

    // time submerged and time not submerged in ms
    private static final long TIME_SUBMERGED = 7000;
    private static final long TIME_NOT_SUBMERGED = 2000;

    // internal clock for all turtles
    private static long SUBMERGED_CLOCK = World.clock + TIME_SUBMERGED;
    private static long OUTOFWATER_CLOCK = SUBMERGED_CLOCK + TIME_NOT_SUBMERGED;

    public Turtle(float x, float y, boolean moveRight) {
        super(ASSET_PATH, x, y, moveRight, new String[] {Sprite.DRAGS, Sprite.SUBMERGES});
    }

    public void render() {
        if (!SUBMERGED) {
            super.render();
        }

        else {

        }
    }

    public void update(Input input, int delta) {

        // changes state of all the turtles based on the delay specified
        if (World.clock >= SUBMERGED_CLOCK) {
            changeState();
            SUBMERGED_CLOCK = OUTOFWATER_CLOCK + TIME_SUBMERGED;
        }

        if (World.clock >= OUTOFWATER_CLOCK) {
            changeState();
            OUTOFWATER_CLOCK = SUBMERGED_CLOCK + TIME_NOT_SUBMERGED;
        }


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
