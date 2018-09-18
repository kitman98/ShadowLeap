import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.io.*;
import java.util.ArrayList;

public class World implements Bounded{

    private static String levelName;

	private TileList Tiles = new TileList();

	public World(String levelName) throws IOException, SlickException {

	    try (BufferedReader br = new BufferedReader(new FileReader(levelName))){

	        String sprite;
	        DetailsArray details = new DetailsArray();
	        Tile tile = new Tile();

	        while (((sprite = br.readLine()) != null)) {

	            details.setDetails(sprite.split(","));

	            if (details.isTile()) {

                    tile.setTile(details.getDetails()[0], Integer.parseInt(details.getDetails()[1]),
                            Integer.parseInt(details.getDetails()[2]));

                    Tiles.add(tile);
                }

                else if (details.isMovingObject()) {


                }
            }
        }
	}
	
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
	}
	
	public void render(Graphics g) {
		// Draw all of the sprites in the game
	}

	/* setters */
    private void setLevelName(String levelName) {
        this.levelName = levelName;
    }

}
