package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Barchart;
import software.ulpgc.arquitecture.model.Pokemon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonBarchartLoader implements BarchartLoader {
    @Override
    public Barchart loads(int id) throws IOException {
        return switch (id){
            case 0 -> barchart0();
            case 1 -> barchart1();
            default -> null;
        };
    }

    private Barchart barchart0() throws IOException {
        Barchart barchart = new Barchart("Pokemon Generation", "Generation", "Number");
        File file = new File("pokedex_(Update.04.20).csv");
        List<Pokemon> pokemons = new FilePokemonLoader(file, new CsvPokemonDeserializer()).loads();
        Map<Integer, Integer> stats = new HashMap<>();

        for (Pokemon pokemon : pokemons){
            stats.put(pokemon.generation(), stats.getOrDefault(pokemon.generation(), 0) + 1);
        }

        for (int i = 1; i < stats.size(); i++){
            barchart.put("Generation" + i, stats.get(i));
        }

        return barchart;
    }

    private Barchart barchart1() throws IOException {
        Barchart barchart = new Barchart("Pokemon Geneartion", "Abilities", "Number");
        File file = new File("pokedex_(Update.04.20).csv");
        List<Pokemon> pokemons = new FilePokemonLoader(file, new CsvPokemonDeserializer()).loads();
        Map<Integer, Integer> stats = new HashMap<>();

        for (Pokemon pokemon : pokemons){
            stats.put(pokemon.numAbilities(), stats.getOrDefault(pokemon.numAbilities(), 0) + 1);
        }

        for (int i = 1; i < stats.size(); i++){
            barchart.put("Abilities" + i, stats.get(i));
        }

        return barchart;
    }
}
