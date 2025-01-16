package software.ulpgc.io;

import software.ulpgc.model.Pokemon;

public interface PokemonDeserializer {
    Pokemon deserialize(String line);
}
