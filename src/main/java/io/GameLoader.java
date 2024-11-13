package io;

import model.Game;

import java.io.IOException;
import java.util.List;

public interface GameLoader {
    List<Game> loads() throws IOException;
}
