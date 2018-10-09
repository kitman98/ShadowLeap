import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Class used to read .lvl file and create instances of Sprites. Also feeds event times to World
 */
public class WorldReader {

    private static Random random = new Random();

    /**
     * Reads .lvl file and creates Sprites
     * @param currentLevel  filename of level to be generated
     * @return              ArrayList containing all of the Sprites that are specified in the .lvl file
     * @throws IOException  if there is no .lvl file in the folder with the filename specified
     */

    public static ArrayList<Sprite> readLevel(String currentLevel) throws IOException {

        ArrayList<Sprite> spriteList = new ArrayList<>();
        String[] line;
        String text;

        try (BufferedReader reader = new BufferedReader(new FileReader(currentLevel))) {


            while((text = reader.readLine()) != null) {

                line = text.split(",");

                switch (line[0]) {
                    case "water":
                        spriteList.add(Tile.createWaterTile(Float.parseFloat(line[1]), Float.parseFloat(line[2])));
                        break;

                    case "grass":
                        spriteList.add(Tile.createGrassTile(Float.parseFloat(line[1]), Float.parseFloat(line[2])));
                        break;

                    case "tree":
                        spriteList.add(Tile.createTreeTile(Float.parseFloat(line[1]), Float.parseFloat(line[2])));
                        break;

                    case "bus":
                        spriteList.add(new Bus(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Boolean.parseBoolean(line[3])));
                        break;

                    case "bulldozer":
                        spriteList.add(new Bulldozer(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Boolean.parseBoolean(line[3])));
                        break;

                    case "log":
                        spriteList.add(new Log(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Boolean.parseBoolean(line[3])));
                        break;

                    case "longLog":
                        spriteList.add(new LongLog(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Boolean.parseBoolean(line[3])));
                        break;

                    case "racecar":
                        spriteList.add(new Racecar(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Boolean.parseBoolean(line[3])));
                        break;

                    case "turtle":
                        spriteList.add(new Turtle(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Boolean.parseBoolean(line[3])));
                        break;

                    case "bike":
                        spriteList.add(new Bike(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Boolean.parseBoolean(line[3])));
                        break;
                }
            }
        }
        return spriteList;
    }

    /**
     * Picks a random Log or LongLog from the list of Sprites and returns the position of the chosen Log or LongLog in
     * the ArrayList
     * @param list  ArrayList containing all the generated Sprites
     * @return      Chosen Log or LongLog position
     */
    public static int pickRandomLog(ArrayList<Sprite> list) {

        Iterator<Sprite> itr = list.iterator();

        int logs = 0;

        while(itr.hasNext()) {

            Sprite sprite = itr.next();

            if (sprite instanceof Log || sprite instanceof LongLog) {
                logs++;
            }


        }

        return random.nextInt(logs);
    }

    /**
     * Returns a shallow copy of the chosen vehicle
     * @param list              ArrayList to pick Vehicle out of
     * @param chosenLogNumber   Log or LongLog position in the list of Logs and longLogs
     * @return                  shallow copy of chosen Log or LongLog
     */
    public static Vehicle returnChosenLog(ArrayList<Sprite> list, int chosenLogNumber) {
        int n = 0;
        Vehicle spriteReturn = null;


        for (Sprite sprite: list) {
            if (sprite instanceof Log || sprite instanceof LongLog) {
                if (chosenLogNumber == n) {
                    spriteReturn = (Vehicle)(sprite);
                }

                n++;
            }
        }
        return spriteReturn;
    }

    // picks a random time for the extraLife to spawn
    public static long randomTime(int start,int interval) {
        return (random.nextInt(start) + interval)*1000;
    }

    // picks a random position for Lamp
    public static float randomPosition(int maxPosition) {
        return (random.nextInt(maxPosition) - World.TILE_SIZE);
    }

}
