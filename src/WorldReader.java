import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WorldReader {

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
}
