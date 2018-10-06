import org.newdawn.slick.Input;

/**
 * This class represents a pickup-able extra life item. If the player comes into contact with it, the ExtraLife
 * disappears and the player gains a life. ExtraLife can also move on the log it is assigned to.
 */

public class ExtraLife extends Sprite {

    private Vehicle log;

    private boolean moveRight;

    private static final String ASSET_PATH = "assets/extralife.png";
    private static final float SPEED = 48f;

    private static final long MOVE_DELAY = 2000;
    public static final long DESPAWN_DELAY = 14000;

    private static long MOVE_CLOCK = World.clock + MOVE_DELAY;

    /**
     * Constructor for the Log class.
     * @param log   The log that the ExtraLife object will spawn on, chosen by WorldReader class
     */
    public ExtraLife(Vehicle log) {
        super(ASSET_PATH, log.getX(), log.getY(), new String[] {Sprite.PICKUP});
        this.log = log;
        this.moveRight = true;
    }

    // moves ExtraLife at the same speed and direction as the log it is on,
    // also moves the ExtraLife to the left and right of the log
    public void update(Input input, int delta) {

        move(log.getSpeed() * delta * (log.getMoveRight() ? 1 : -1), 0);

        if (getX() > App.SCREEN_WIDTH + log.getImage().getWidth() || getX() < -log.getImage().getWidth()) {
            setX(log.getX());
            setY(log.getY());
        }

        if (World.clock >= MOVE_CLOCK) {
            checkNextMove();
            move(SPEED* (getMoveRight()? 1:-1), 0);
            MOVE_CLOCK = World.clock + MOVE_DELAY;
        }
    }

    // predicts the next move of ExtraLife and decides whether to change direction
    private final void checkNextMove() {
        if (getX() + SPEED*(getMoveRight()? 1: -1) > log.getX() + log.getImage().getWidth()/2||
                getX() + getImage().getWidth() + SPEED*(getMoveRight()? 1: -1) < log.getX() - log.getImage().getWidth()/4) {
            changeDirection();
        }
    }

    private final void changeDirection() {
        this.moveRight = !getMoveRight();
    }

    private final boolean getMoveRight() {return this.moveRight;}
}
