import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class World {
	public static final int TILE_SIZE = 48;

	private ArrayList<Sprite> sprites;

	// internal game clock
    public static long clock = System.currentTimeMillis();
	
	public World(String currentLevel) throws IOException {
		// create tiles
		sprites = WorldReader.readLevel(currentLevel);

        // create player at the front of list so when list is reversed sprite is at the last position so the player is rendered last
        sprites.add(0,new Player(App.SCREEN_WIDTH / 2, App.SCREEN_HEIGHT - TILE_SIZE));

        // reverses sprite list
        Collections.reverse(sprites);

        // create holes

    }
	
	public void update(Input input, int delta) {

	    clock = System.currentTimeMillis();

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

}
