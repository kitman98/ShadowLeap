import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import utilities.BoundingBox;

public class Hole{

    private float x, y;
    private BoundingBox boundingBox;
    private boolean playerIn = false;

    private final static String PLAYER_ASSET = "assets/frog.png";


    public Hole(float x, float y) {
        setupHole(x,y);
    }

    private void setupHole(float x, float y) {
        this.x = x;
        this.y = y;

        boundingBox = new BoundingBox(x, x+ World.TILE_SIZE*2, y, y + World.TILE_SIZE);

    }

    public void playerReaches(Sprite player) {
        playerIn = true;

        ((Player) player).resetPlayer();
    }

    public void render(Graphics g) throws SlickException {

        Image PLAYER = new Image(PLAYER_ASSET);

        if (playerIn) {
            PLAYER.draw(x + 24, y);
        }
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

}
