import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class World {
	public static final int TILE_SIZE = 48;
	private static final int GRASS_Y_1 =  672;
	private static final int GRASS_Y_2 =  384;
	private static final int WATER_START = 336;
	private static final int WATER_END = 48;
	private static final int ENEMY_START = 432;
	private static final float ENEMY_1_STEP = 6.5f;
	private static final float ENEMY_2_STEP = 5f;
	private static final float ENEMY_3_STEP = 12f;
	private static final int ENEMY_OFFSET_1 = 128;
	private static final int ENEMY_OFFSET_2 = 48;
	private static final int ENEMY_OFFSET_3 = 250;
	private static final int ENEMY_OFFSET_4 = 64;

	private static int PLAYER_LIVES = 3;
	private static String LIVE_SRC = "assets/lives.png";
	
	private ArrayList<Sprite> sprites = new ArrayList<>();
	
	public World() {
		// create tiles
		for (int x = 0; x < App.SCREEN_WIDTH; x += TILE_SIZE) {
			sprites.add(Tile.createGrassTile(x, GRASS_Y_1));
			sprites.add(Tile.createGrassTile(x, GRASS_Y_2));
			for (int y = WATER_START; y > WATER_END; y -= TILE_SIZE) {
				sprites.add(Tile.createWaterTile(x, y));
			}
		}

		// create vehicles
		for (int x = 0; x < App.SCREEN_WIDTH - TILE_SIZE; x += (int)(TILE_SIZE * ENEMY_1_STEP)) {
			sprites.add(new Bike(x + ENEMY_OFFSET_2, ENEMY_START, false));
			sprites.add(new Bus(x + ENEMY_OFFSET_3, ENEMY_START + TILE_SIZE * 4, false));
		}
		for (int x = 0; x < App.SCREEN_WIDTH - TILE_SIZE; x += (int)(TILE_SIZE * ENEMY_2_STEP)) {
			sprites.add(new LongLog(x, ENEMY_START + TILE_SIZE, true));
			sprites.add(new Turtle(x + ENEMY_OFFSET_1, ENEMY_START + TILE_SIZE * 3, true));
		}
		for (int x = 0; x < App.SCREEN_WIDTH - TILE_SIZE; x += (int)(TILE_SIZE * ENEMY_3_STEP)) {
			sprites.add(new Bulldozer(x + ENEMY_OFFSET_4, ENEMY_START + TILE_SIZE * 2, false));
		}

        // create player
        sprites.add(new Player(App.SCREEN_WIDTH / 2, App.SCREEN_HEIGHT - TILE_SIZE));

    }
	
	public void update(Input input, int delta) {
		for (Sprite sprite : sprites) {
			sprite.update(input, delta);
		}
		
		// loop over all pairs of sprites and test for intersection
		for (Sprite sprite1: sprites) {
			for (Sprite sprite2: sprites) {
				if (sprite1 != sprite2
						&& sprite1.collides(sprite2)) {
					sprite1.onCollision(sprite2, delta);
				}

			}
		}
	}
	
	public void render(Graphics g) throws SlickException {
		for (Sprite sprite : sprites) {
			sprite.render();
		}

		Image lives = new Image(LIVE_SRC);

		for (int i = 0; i < PLAYER_LIVES; i++) {
		    lives.drawCentered(24 + i*32, 744);

        }
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
