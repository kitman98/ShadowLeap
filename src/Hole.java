import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hole extends Tile{

    private boolean playerIn = false;

    private final static String PLAYER_ASSET = "assets/frog.png";


    public Hole(float x, float y) {
        super(PLAYER_ASSET, x, y, new String[] {Sprite.HOLE});
    }

    public void playerReaches() {
        playerIn = true;
    }

    // if Player reaches Hole, renders a frog in hole
    public void render(){

        if (playerIn) {
            getImage().drawCentered(getX() + World.TILE_SIZE/2, getY());
        }

    }

    public boolean isPlayerIn() {
        return playerIn;
    }



}
