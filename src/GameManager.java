import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.io.IOException;

public class GameManager {

    private final static int MAX_LEVELS = 1;

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

        if (currentLevel > MAX_LEVELS) {
            System.exit(0);
        }
    }

    public void update(Input input, int delta) {
        world.update(input, delta);

        if (world.getHolesReached() == 5) {
            nextLevel();
            world.resetWorld();
            try {
                world = new World(levelDirectory + currentLevel + levelSuffix);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void render(Graphics g) throws SlickException {
        world.render(g);
    }

}
