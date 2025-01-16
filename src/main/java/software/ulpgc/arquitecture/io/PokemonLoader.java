package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Pokemon;

import java.io.IOException;
import java.util.List;

public interface PokemonLoader {
    List<Pokemon> loads() throws IOException;
}
