import org.newdawn.slick.Input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ExtraLife extends Sprite {



    private static final String ASSET_PATH = "assets/extralife.png";
    private static final float SPEED = 48f;

    private static final float MOVE_DELAY = 2f;
    private static final float DESPAWN_DELAY = 14f;

    static Random random = new Random();

    private static float SPAWN_DELAY = random.nextInt(11) + 25;

    public ExtraLife(float x, float y, boolean moveRight) {
        super(ASSET_PATH, x, y, new String[] {Sprite.PICKUP});
    }

    public void update(Input input, int delta) {

    }

    public void pickRandomLog(ArrayList<Sprite> list) {
        Iterator<Sprite> itr = list.iterator();

        while(itr.hasNext()) {

            Sprite sprite = itr.next();


        }
    }

    public void onCollision(Sprite other, int delta) {
        if (other instanceof Player) {
            World.increaseLives();
        }

    }
}
