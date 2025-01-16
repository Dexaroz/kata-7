package software.ulpgc;

import software.ulpgc.io.CsvPokemonDeserializer;
import software.ulpgc.io.FilePokemonLoader;
import software.ulpgc.model.Pokemon;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static software.ulpgc.io.CsvDownloader.downloadCsv;

public class Main {
    public static void main(String[] args) throws IOException {
        File path = new File("");
        String Path = path.getAbsolutePath();
        String urlInput = "https://raw.githubusercontent.com/Carlosqchao/Resources/refs/heads/main/pokedex_(Update.04.20).csv";
        String outputPath = Path + "\\pokedex_(Update.04.20).csv";
        downloadCsv(urlInput,outputPath);
        File file = new File("pokedex_(Update.04.20).csv");
        List<Pokemon> pokemons = new FilePokemonLoader(file, new CsvPokemonDeserializer()).loads();
        Map<Integer,Integer> stats = new HashMap<>();
        for(Pokemon pokemon : pokemons){
            stats.put(pokemon.generation(), stats.getOrDefault(pokemon.generation(),0)+1);
        }
        for (int generation: stats.keySet()) {
            System.out.println("Generation " + generation + "\t" + stats.get(generation));
        }
    }
}
