import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class WorldReader {

    private static Random random = new Random();

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

    // picks a random log from the sprite list for the extra life to spawn on
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

    // returns a shallow copy of the log that the extraLife will spawn on
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
    public static long randomTime() {
        return (random.nextInt(11) + 25)*1000;
    }

}
