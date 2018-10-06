/**
 * This class represents the tile that players need to fill in order to move on to the next level or finish the game.
 */
public class Hole extends Tile{

    private boolean playerIn = false;

    private final static String PLAYER_ASSET = "assets/frog.png";

    /**
     * Constructor for the holes that spawn in the world.
     * @param x X position of the hole
     * @param y Y position of the hole
     */
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
