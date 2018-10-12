import org.newdawn.slick.Input;

/**
 * Moth is a hazard that will stop at nothing to reach Lamp. Kills player if player gets in the way of Moth.
 *
 * <IMG SRC ="doc-files/moth.jpeg">
 *
 * <h1> I don't have issues at all :)</h1>
 */
public class Moth extends Vehicle {

    private static final String ASSET_PATH = "assets/moth.png";
    private static final float SPEED = 0.2f;

    private float xPosLamp;
    private float yPosLamp;

    /**
     * Constructor for moth class
     * @param x         Current x position of Moth
     * @param y         Current y position of Moth
     * @param xPosLamp  Current x position of Lamp that Moth is chasing
     * @param yPosLamp  Current y position of Lamp that Moth is chasing
     */
    public Moth(float x, float y, float xPosLamp,float  yPosLamp) {
        super(ASSET_PATH, x, y, true, new String[]{Sprite.HAZARD});
        setxPosLamp(xPosLamp);
        setyPosLamp(yPosLamp);

    }

    @Override
    public void update(Input input, int delta) {
        float dx;
        float dy;

        if (getX() > getxPosLamp()) {
            dx = -SPEED*delta;
        } else if (getX() < getxPosLamp()) {
            dx = SPEED*delta;
        } else {
            dx = 0;
        }

        if (getY() > getyPosLamp()) {
            dy = -SPEED*delta;
        } else if (getY() < getyPosLamp()) {
            dy = SPEED*delta;
        } else {
            dy = 0;
        }

        move(dx,dy);

    }

    public void setxPosLamp(float xPosLamp) {
        this.xPosLamp = xPosLamp;
    }

    public void setyPosLamp(float yPosLamp) {
        this.yPosLamp = yPosLamp;
    }

    private float getxPosLamp() {
        return this.xPosLamp;
    }

    private float getyPosLamp() {
        return this.yPosLamp;
    }

    public void changePosition() {
        setX(WorldReader.randomPosition(App.SCREEN_WIDTH));
        setY(WorldReader.randomPosition(App.SCREEN_HEIGHT));
    }

}
