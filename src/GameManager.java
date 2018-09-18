import java.io.IOException;

public class GameManager {

    private static final int FINAL_LEVEL = 1;

    private static final String LEVELS = "assets/levels";

    private static final String LEVEL_SUFFIX = ".lvl";

    private static int current_level;

    private static Player player;

    private static World world;

    private static String levelName;

    public static void newGame() throws IOException {
        current_level = 0;
        levelName = LEVELS + current_level + LEVEL_SUFFIX;
        loadLevel(levelName);
    }

    public static void loadLevel(String levelName) throws IOException {
        world = new World(levelName);
    }
}
