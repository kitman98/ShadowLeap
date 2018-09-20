public class Tile extends Sprite {
	private static final String GRASS_PATH = "assets/grass.png";
	private static final String WATER_PATH = "assets/water.png";
	
	public static Tile createGrassTile(float x, float y) {
		return new Tile(GRASS_PATH, x, y);
	}
	public static Tile createWaterTile(float x, float y) {
		return new Tile(WATER_PATH, x, y, new String[] { Sprite.HAZARD });
	}
	
	private Tile(String imageSrc, float x, float y) {		
		super(imageSrc, x, y);
	}
	private Tile(String imageSrc, float x, float y, String[] tags) {		
		super(imageSrc, x, y, tags);
	}
}