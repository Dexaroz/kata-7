package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePokemonLoader implements PokemonLoader {
    private final File file;
    private final PokemonDeserializer deserializer;

    public FilePokemonLoader(File file, PokemonDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Pokemon> loads() throws IOException {
        List<Pokemon> pokemons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            reader.readLine();
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                pokemons.add(deserializer.deserialize(line));
            }
        }
        return pokemons;
    }
}
