import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class World {

	public static final int TILE_SIZE = 48;

    private static final float[] holeX =
            new float[] {96, 288, 480 , 672, 864};
    private static final float holeY = 48;

    // list containing all the sprites
	private static ArrayList<Sprite> sprites;

	// victory condition
	private static int holesReached = 0;

	// number of extra lives generated
    private static int livesGenerated;

	// internal game clock
    public static long clock = System.currentTimeMillis();

    // when extra life will be spawned
    public static long lifeSpawnTime;
    public static long lifeDestroyTime;
    public static int  lifeLog;
	
	public World(String currentLevel) throws IOException {
		// create tiles and sprites
		sprites = WorldReader.readLevel(currentLevel);

        // create player at the front of list so when list is reversed sprite is at the last position so the player is rendered last
        sprites.add(0,new Player(App.SCREEN_WIDTH / 2, App.SCREEN_HEIGHT - TILE_SIZE));

        // reverses sprite list to ensure that player is tested with vehicles first then only tile hazards (water)
        Collections.reverse(sprites);

        // create holes
        for (float x: holeX) {
            sprites.add(new Hole(x, holeY));
        }

        // initialise world state
        holesReached = 0;

        // set timers for extra life
        lifeSpawnTime = clock + WorldReader.randomTime();
        lifeDestroyTime = lifeSpawnTime + ExtraLife.DESPAWN_DELAY;
        lifeLog = WorldReader.pickRandomLog(sprites);
        livesGenerated = 0;

    }
	
	public void update(Input input, int delta) {

	    clock = System.currentTimeMillis();

	    if (clock >= lifeSpawnTime && livesGenerated == 0) {
            sprites.add(sprites.size(), new  ExtraLife(WorldReader.returnChosenLog(sprites,lifeLog)));
            livesGenerated++;
        }

        if (clock >= lifeDestroyTime && livesGenerated == 1) {
	        sprites.remove(sprites.size() - 1);
	        livesGenerated++;
        }


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

				if (sprite1 != sprite2 && sprite1 instanceof Player) {
				    if (((Player)sprite1).nextTo(sprite2)) {
				        sprite1.push(sprite2, delta);
                    }
                }

			}

		}

		if (input.isKeyPressed(Input.KEY_E)) {
	        holesReached = 5;
        }
	}
	
	public void render(Graphics g) throws SlickException {

	    // render tiles first
		for (Sprite sprite : sprites) {
			if (sprite instanceof Tile) {
			    sprite.render();
            }
		}

		// then render sprites
		for (Sprite sprite: sprites) {
		    if (!(sprite instanceof Tile)) {
		        sprite.render();
            }
        }

	}

	public static void reachedHole() {
	    holesReached++;
    }

    public static int getHolesReached() {
	    return holesReached;
    }

}
