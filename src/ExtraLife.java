import org.newdawn.slick.Input;
import java.util.Random;

public class ExtraLife extends Sprite {

    private Vehicle log;

    private boolean moveRight;

    private static final String ASSET_PATH = "assets/extralife.png";
    private static final float SPEED = 48f;

    private static final long MOVE_DELAY = 2000;
    public static final long DESPAWN_DELAY = 14000;

    private static long MOVE_CLOCK = World.clock + MOVE_DELAY;
    private static long DESPAWN_CLOCK = World.clock + DESPAWN_DELAY;

    static Random random = new Random();

    public ExtraLife(Vehicle log) {
        super(ASSET_PATH, log.getX(), log.getY(), new String[] {Sprite.PICKUP});
        this.log = log;
        this.moveRight = true;
    }

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


    private final void checkNextMove() {
        if (getX() + SPEED*(getMoveRight()? 1: -1) > log.getX() + log.getImage().getWidth()/2||
                getX() + getImage().getWidth() + SPEED*(getMoveRight()? 1: -1) < log.getX()) {
            changeDirection();
        }
    }

    private final void changeDirection() {
        this.moveRight = !getMoveRight();
    }

    private final boolean getMoveRight() {return this.moveRight;}
}
