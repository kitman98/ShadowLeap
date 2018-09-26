import org.newdawn.slick.Input;

public class Bike extends Vehicle{


    private static final String ASSET_PATH = "assets/bike.png";
    private static final float SPEED = 0.2f;

    private static final float LEFT_BOUND = 24f;
    private static final float RIGHT_BOUND = 1000f;

    public Bike(float x, float y, boolean moveRight) {
        super( ASSET_PATH,x, y, moveRight, new String[] {Sprite.HAZARD});
    }

    @Override
    public void update(Input input, int delta) {
        move(SPEED * delta * (getMoveRight() ? 1 : -1), 0);

        // check if the bike has reached the turn around point
        if (getX() < LEFT_BOUND + getImage().getWidth() && !getMoveRight()
                || getX() > RIGHT_BOUND -getImage().getWidth() && getMoveRight() ) {
           changeDirection();
        }
    }


}
