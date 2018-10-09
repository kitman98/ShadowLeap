public class Lamp extends Sprite {
    /**
     *  This class represents the Lamp that Moths chase.
     *  Moth class must be created together with a Lamp.
     */

    private static String ASSET_PATH = "assets/lamp.png";

    /**
     * Default constructor for Lamp class
     * @param x X position of Lamp
     * @param y Y position of Lamp
     */
    public Lamp(float x, float y) {
        super(ASSET_PATH, x, y);
    }

    @Override
    public void onCollision(Sprite other, int delta) {
        if (other instanceof Moth) {
            changePosition();
            ((Moth) other).setxPosLamp(getX());
            ((Moth) other).setyPosLamp(getY());
        }
    }

    private void changePosition() {
        setX(WorldReader.randomPosition(App.SCREEN_WIDTH));
        setY(WorldReader.randomPosition(App.SCREEN_HEIGHT));
    }
}
