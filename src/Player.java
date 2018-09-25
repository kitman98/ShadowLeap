import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.Iterator;

public class Player extends Sprite {
	private static final String ASSET_PATH = "assets/frog.png";

	// stuff for lives
	private static int PLAYER_LIVES = 3;
    private static String LIVE_SRC = "assets/lives.png";
    private static int LIVES_START_X = 24;
    private static int LIVES_START_Y = 744;
    private static int LIVES_GAP = 32;

    // player is only safe from hazards when on an object that "drags" the player along
    private static boolean safeState = false;

    // to store the last move made by the player
    private static String echo;

    // constants used for echo
    private static final String LEFT = "left";
    private static final String RIGHT = "right";
    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String NULL = "null";

    // timer for delay when echo is set to null
    private static final long delay = 100;
    private static long nextReset = World.clock + delay;

    public Player(float x, float y) {
		super(ASSET_PATH, x, y);
	}

	@Override
	public void update(Input input, int delta) {
		int dx = 0,
			dy = 0;

		// used to store the last move of the player to move player back if the player makes an illegal move
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			dx -= World.TILE_SIZE;
			echo = LEFT;
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			dx += World.TILE_SIZE;
			echo = RIGHT;
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			dy += World.TILE_SIZE;
			echo = DOWN;
		}
		if (input.isKeyPressed(Input.KEY_UP)) {
			dy -= World.TILE_SIZE;
			echo = UP;
		}
		
		// make sure the frog stays on screen
		if (getX() + dx - World.TILE_SIZE / 2 < 0 || getX() + dx + World.TILE_SIZE / 2 	> App.SCREEN_WIDTH) {
			dx = 0;
		}
		if (getY() + dy - World.TILE_SIZE / 2 < 0 || getY() + dy + World.TILE_SIZE / 2 > App.SCREEN_HEIGHT) {
			dy = 0;
		}

		move(dx, dy);

		safeState = false;

		if (World.clock >= nextReset) {
		    echo = NULL;
		    nextReset = World.clock + delay;
        }
	}

	@Override
    public void render() throws SlickException {
        super.render();

        Image lives = new Image(LIVE_SRC);

        for (int i = 0; i < PLAYER_LIVES; i++) {
            lives.drawCentered(LIVES_START_X + i*LIVES_GAP, LIVES_START_Y);

        }
    }

	@Override
	public void onCollision(Sprite other, int delta) {

        if (other.hasTag(Sprite.DRAGS) && !(other instanceof Turtle)) {

            safeState = true;

            float dx = other.getSpeed() * (((Vehicle) other).getMoveRight()? 1: -1) * delta;

            if (getX() + dx - World.TILE_SIZE / 2 < 0 || getX() + dx + World.TILE_SIZE / 2 	> App.SCREEN_WIDTH) {
                dx = 0;
            }

            move(dx, 0);
        }

        if (other.hasTag(Sprite.DRAGS) && other instanceof Turtle) {

            if (((Turtle) other).getState()) {
                // do nothing
            }

            else {

                safeState = true;

                float dx = other.getSpeed() * (((Vehicle) other).getMoveRight()? 1: -1) * delta;

                if (getX() + dx - World.TILE_SIZE / 2 < 0 || getX() + dx + World.TILE_SIZE / 2 	> App.SCREEN_WIDTH) {
                    dx = 0;
                }

                move(dx, 0);

            }

        }

		if (other.hasTag(Sprite.HAZARD) && !safeState) {
            reduceLives();
            resetPlayer();
		}

		if (other.hasTag(Sprite.SOLID)) {
            solidHit(other);
        }

        if (other.hasTag(Sprite.HOLE)) {
            if (((Hole)other).isPlayerIn()) {
                reduceLives();
            }

            else {
                ((Hole) other).playerReaches();
                World.reachedHole();
            }

            resetPlayer();

        }
	}


    @Override
	public void push(Sprite other, int delta) {
		if (other.hasTag(Sprite.PUSHES) && other instanceof Bulldozer) {
			move( other.getSpeed() * (((Vehicle) other).getMoveRight()? 1: -1) * delta, 0);
		}
	}

	public void resetPlayer() {
	    setX(App.SCREEN_WIDTH / 2);
	    setY( App.SCREEN_HEIGHT - World.TILE_SIZE);
    }

    public static void increaseLives() {
        PLAYER_LIVES++;
    }

    public static void reduceLives() {
        PLAYER_LIVES--;

        checkLives();
    }

    public static int livesLeft() {
        return PLAYER_LIVES;
    }

    public static void checkLives() {
        if (livesLeft() < 1) {
            System.exit(0);
        }
    }


    public void solidHit(Sprite other) {

        nextReset = World.clock + delay;

        switch(echo) {
            case RIGHT:
                setX(other.getX() - getImage().getWidth());
                break;
            case LEFT:
                setX(other.getX() + other.getImage().getWidth());
                break;
            case UP:
                setY(other.getY() + other.getImage().getHeight());
                break;
            case DOWN:
                setY(other.getY() - getImage().getHeight());

            // do nothing
            case NULL:
                break;
        }

        // to ensure that player does not die when hitting a wall
        safeState = true;

    }



}
