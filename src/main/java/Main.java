import io.CsvGameDeserializer;
import io.FileGameLoader;
import model.Game;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("vgchartz-11_7_2024.csv");
        List<Game> games = new FileGameLoader(file, new CsvGameDeserializer()).loads();
        Map<String, Integer> stats = new HashMap<>();
        for (Game game : games){
            stats.put(game.getConsole(), stats.getOrDefault(game.getConsole(), 0)+1);
        }
        for (String console : stats.keySet()) {
            System.out.println(console + "\t" + stats.get(console));
        }
    }
}
