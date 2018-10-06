/**
 * This class represents the ground which the other Sprites such as Vehicles and Player will walk on
 */

public class Tile extends Sprite {
	private static final String GRASS_PATH = "assets/grass.png";
	private static final String WATER_PATH = "assets/water.png";
	private static final String TREE_PATH = "assets/tree.png";

	/**
	 * Creates a Grass Tile
	 * @param x	X position of the created grass tile
	 * @param y Y position of the created grass tile
	 * @return	created Tile with the attributes of a Grass Tile
	 */
	public static Tile createGrassTile(float x, float y) {
		return new Tile(GRASS_PATH, x, y);
	}

	/**
	 * Creates a Water Tile
	 * @param x	X position of the created water tile
	 * @param y	Y position of the created water tile
	 * @return	created Tile with the attributes of a Water Tile
	 */
	public static Tile createWaterTile(float x, float y) {
		return new Tile(WATER_PATH, x, y, new String[] { Sprite.HAZARD });
	}

	/**
	 * Creates a Tree Tile
	 * @param x	X position of the created tree tile
	 * @param y	Y position of the created tree tile
	 * @return	created Tile with the attributes of a Tree Tile
	 */
	public static Tile createTreeTile(float x, float y) {
		return new Tile(TREE_PATH, x, y, new String[] {Sprite.SOLID});
	}

	/**
	 * Constructor for a Tile without any tags
	 * @param imageSrc	Image that will be rendered
	 * @param x			X position of the Tile
	 * @param y			Y position of the Tile
	 */
	public Tile(String imageSrc, float x, float y) {
		super(imageSrc, x, y);
	}

	/**
	 * Constructor for a Tile with tag(s)
	 * @param imageSrc	Image that will be rendered
	 * @param x			X position of the Tile
	 * @param y			Y position of the Tile
	 * @param tags		Predefined tags that determines behaviour of the Tile
	 */
	public Tile(String imageSrc, float x, float y, String[] tags) {
		super(imageSrc, x, y, tags);
	}
}