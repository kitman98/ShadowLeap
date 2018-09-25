import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player extends Sprite {
	private static final String ASSET_PATH = "assets/frog.png";
    private static int PLAYER_LIVES = 3;
    private static String LIVE_SRC = "assets/lives.png";


    public Player(float x, float y) {
		super(ASSET_PATH, x, y);
	}

	@Override
	public void update(Input input, int delta) {
		int dx = 0,
			dy = 0;
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			dx -= World.TILE_SIZE;
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			dx += World.TILE_SIZE;
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			dy += World.TILE_SIZE;
		}
		if (input.isKeyPressed(Input.KEY_UP)) {
			dy -= World.TILE_SIZE;
		}
		
		// make sure the frog stays on screen
		if (getX() + dx - World.TILE_SIZE / 2 < 0 || getX() + dx + World.TILE_SIZE / 2 	> App.SCREEN_WIDTH) {
			dx = 0;
		}
		if (getY() + dy - World.TILE_SIZE / 2 < 0 || getY() + dy + World.TILE_SIZE / 2 > App.SCREEN_HEIGHT) {
			dy = 0;
		}

		move(dx, dy);
	}

	@Override
    public void render() throws SlickException {
        super.render();

        Image lives = new Image(LIVE_SRC);

        for (int i = 0; i < PLAYER_LIVES; i++) {
            lives.drawCentered(24 + i*32, 744);

        }
    }

	@Override
	public void onCollision(Sprite other, int delta) {
		if (other.hasTag(Sprite.HAZARD)) {
			reduceLives();
			resetPlayer();
		}

		if (other.hasTag(Sprite.DRAGS) ) {
		    float dx = other.getSpeed() * (((Vehicle) other).getMoveRight()? 1: -1) * delta;

            if (getX() + dx - World.TILE_SIZE / 2 < 0 || getX() + dx + World.TILE_SIZE / 2 	> App.SCREEN_WIDTH) {
                dx = 0;
            }

		    move(dx, 0);
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

    public static void checkLives() {
        if (PLAYER_LIVES < 0) {
            System.exit(0);
        }
    }
}
