public class Tile extends Sprite {
	private static final String GRASS_PATH = "assets/grass.png";
	private static final String WATER_PATH = "assets/water.png";
	private static final String TREE_PATH = "assets/tree.png";
	
	public static Tile createGrassTile(float x, float y) {
		return new Tile(GRASS_PATH, x, y);
	}
	public static Tile createWaterTile(float x, float y) {
		return new Tile(WATER_PATH, x, y, new String[] { Sprite.HAZARD });
	}

	public static Tile createTreeTile(float x, float y) {
		return new Tile(TREE_PATH, x, y, new String[] {Sprite.SOLID});
	}
	
	private Tile(String imageSrc, float x, float y) {		
		super(imageSrc, x, y);
	}
	private Tile(String imageSrc, float x, float y, String[] tags) {		
		super(imageSrc, x, y, tags);
	}
}