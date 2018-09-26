import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hole extends Tile{

    private final static String ASSET_PATH = "assets/hole.png";
    private boolean playerIn = false;

    private final static String PLAYER_ASSET = "assets/frog.png";
    private static Image PLAYER;

    static {
        try {
            PLAYER = new Image(PLAYER_ASSET);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


    public Hole(float x, float y) {
        super(ASSET_PATH, x, y, new String[] {Sprite.HOLE});
    }

    public void playerReaches() {
        playerIn = true;
    }

    public void render(){

        if (playerIn) {
            PLAYER.drawCentered(getX() + World.TILE_SIZE/2, getY());
        }

    }

    public boolean isPlayerIn() {
        return playerIn;
    }



}
