import org.newdawn.slick.SlickException;

public class Tile extends Sprite {

    boolean isSafe;

    public Tile() {}

    public Tile(String imageSrc, Position position, boolean isSafe) throws SlickException {
        super.setPosition(position);
        super.setImage(imageSrc);
        super.setImageSrc(imageSrc);
        this.isSafe(isSafe);

    }

    public Tile(String imageSrc, int x, int y, boolean isSafe) throws SlickException {
        Position position = new Position(x, y);
        super.setPosition(position);
        super.setImage(imageSrc);
        super.setImageSrc(imageSrc);
        this.isSafe(isSafe);

    }

    /* getters */
    public boolean isSafe() {
        return this.isSafe;
    }

    /* setters */
    public void isSafe(boolean safe) {
        this.isSafe = safe;
    }

    public void setTile(String imageSrc, int x, int y) throws SlickException{
        Position position = new Position(x, y);
        super.setPosition(position);
        super.setImage(imageSrc);
        super.setImageSrc(imageSrc);
    }
}
