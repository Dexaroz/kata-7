package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Pokemon;

public interface PokemonDeserializer {
    Pokemon deserialize(String line);
}
