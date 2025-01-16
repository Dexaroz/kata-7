package software.ulpgc.io;

import software.ulpgc.model.Pokemon;

import java.io.IOException;
import java.util.List;

public interface PokemonLoader {
    List<Pokemon> loads() throws IOException;
}
