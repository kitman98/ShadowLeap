

import org.newdawn.slick.*;

/*
* Main class for the game.
* Handle initialisation, input and rendering
*
* Project 2B: SWEN20003 by Kit Man Soo 916429
* using Eleanor McMurtry's sample code
*
*/

public class App extends BasicGame {
    /** screen width, in pixels */
    public static final int SCREEN_WIDTH = 1024;
    /** screen height, in pixels */
    public static final int SCREEN_HEIGHT = 768;

    private GameManager gameManager;
    public static Music music;

    public App() {
        super("Shadow Leap");
    }

    @Override
    public void init(GameContainer gc) {

        /*try {
            music = new Music("assets/plsh1.ogg");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        gameManager = new GameManager();
        gameManager.newGame();


    }

    /** Update the game state for a frame.
     * @param gc The Slick game container object.
     * @param delta Time passed since last frame (milliseconds).
     */
    @Override
    public void update(GameContainer gc, int delta) {
        // Get data about the current input (keyboard state).
        Input input = gc.getInput();
        gameManager.update(input, delta);
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param gc The Slick game container object.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(GameContainer gc, Graphics g)
            throws SlickException {
        gameManager.render(g);
    }

    /** Start-up method. Creates the game and runs it.
     * @param args Command-line arguments (ignored).
     */
    public static void main(String[] args)
            throws SlickException {
        AppGameContainer app = new AppGameContainer(new App());
        app.setShowFPS(false);
        app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
        app.start();
    }

}