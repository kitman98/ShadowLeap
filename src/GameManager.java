import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class GameManager {

    private final static String levelDirectory = "assets/levels/";
    private final static String levelSuffix = ".lvl";

    private static int currentLevel;

    private static World world;

    public GameManager() {

    }

    public void newGame() {
        currentLevel = 0;

        try {
            world = new World(levelDirectory + currentLevel + levelSuffix);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void nextLevel() {
        currentLevel++;
    }

    public void update(Input input, int delta) {
        world.update(input, delta);
    }

    public void render(Graphics g) throws SlickException {
        world.render(g);
    }

}
