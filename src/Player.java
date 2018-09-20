import org.newdawn.slick.Input;

public class Player extends Sprite {
	private static final String ASSET_PATH = "assets/frog.png";
	
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
	public void onCollision(Sprite other, int delta) {
		if (other.hasTag(Sprite.HAZARD)) {
			System.exit(0);
		}

		if (this instanceof Player && other.hasTag(Sprite.PUSHES) && other instanceof Bulldozer) {
		    move(((Bulldozer) other).getSpeed() * (((Vehicle) other).getMoveRight()? 1: -1) * delta, 0);
        }
	}
}
