import utilities.BoundingBox;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Abstract class that contains the basic building blocks of everything in the game
 */
public abstract class Sprite {
	// this is a defined constant to avoid typos
	public final static String HAZARD = "hazard";
	public final static String SOLID = "solid";
	public final static String PUSHES = "pushes";
	public final static String DRAGS = "drags";
	public final static String SUBMERGES = "submerges";
	public final static String PICKUP = "pickup";
	public final static String HOLE = "hole";
	
	private BoundingBox bounds;
	private Image image;
	private float x;
	private float y;
	
	private String[] tags;

	/**
	 * Constructor for a Sprite that does not have a tag
	 * @param imageSrc	Image that will be rendered
	 * @param x			X position of the Sprite
	 * @param y			Y position of the Sprite
	 */
	public Sprite(String imageSrc, float x, float y) {
		setupSprite(imageSrc, x, y);
	}

	/**
	 * Constructor for a Sprite that has a tag(s)
	 * @param imageSrc	Image that will be rendered
	 * @param x			X position of the Sprite
	 * @param y			Y position of the Sprite
	 * @param tags		Predefined tags that define how Sprites interact with each other
	 */
	public Sprite(String imageSrc, float x, float y, String[] tags) {
		setupSprite(imageSrc, x, y);
		this.tags = tags;
	}

	
	private void setupSprite(String imageSrc, float x, float y) {
		try {
			image = new Image(imageSrc);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		this.x = x;
		this.y = y;
		
		bounds = new BoundingBox(image, (int)x, (int)y);
		
		tags = new String[0];
	}

	/**
	 * Sets the x position of the sprite.
	 * @param x	 the target x position
	 */
	public final void setX(float x) { this.x = x; bounds.setX((int)x); }
	/**
	 * Sets the y position of the sprite.
	 * @param y	 the target y position
	 */
	public final void setY(float y) { this.y = y; bounds.setY((int)y); }
	/**
	 * Accesses the x position of the sprite.
	 * @return	the x position of the sprite
	 */
	public final float getX() { return x; }
	/**
	 * Accesses the y position of the sprite.
	 * @return	the y position of the sprite
	 */
	public final float getY() { return y; }

	/**
	 * Moves the Sprite by increasing the X and Y position of the Player
	 * @param dx	increment in x
	 * @param dy	increment in y
	 */
	public final void move(float dx, float dy) {
		setX(x + dx);
		setY(y + dy);
	}

	/**
	 * Checks if the Sprite is on the screen
	 * @param x		Current x position of the Sprite
	 * @param y		Current y position of the Sprite
	 * @return		true if Sprite is in the screen, and returns false if otherwise
	 */
	public final boolean onScreen(float x, float y) {
		return !(x > App.SCREEN_WIDTH + getImage().getWidth() || x < -getImage().getWidth()
				|| y > App.SCREEN_HEIGHT + World.TILE_SIZE / 2 || y < -World.TILE_SIZE / 2);
	}

	/**
	 * Uses BoundingBoxes to check if a Sprite collides with another
	 * @param other	other Sprite to check
	 * @return		true if the Sprites collide, false otherwise
	 */
	public final boolean collides(Sprite other) {
		return bounds.intersects(other.bounds);
	}
	
	public void update(Input input, int delta) { }
	
	public void onCollision(Sprite other, int delta) { }

	public void push(Sprite other, int delta) { }

	public float getSpeed() {return 0f;}
	
	public void render() throws SlickException {
		image.drawCentered(x, y);
	}
	
	public boolean hasTag(String tag) {
		for (String test : tags) {
			if (tag.equals(test)) {
				return true;
			}
		}
		return false;
	}

	public Image getImage() {
	    return image;
    }
}
