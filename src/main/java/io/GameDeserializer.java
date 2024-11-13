package io;

import model.Game;

public interface GameDeserializer {
    Game deserialize(String line);
}
