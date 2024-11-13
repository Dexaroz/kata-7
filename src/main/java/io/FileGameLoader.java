package io;

import model.Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileGameLoader implements GameLoader{

    private final File file;
    private final GameDeserializer gameDeserializer;

    public FileGameLoader(File file, GameDeserializer gameDeserializer) {
        this.file = file;
        this.gameDeserializer = gameDeserializer;
    }

    @Override
    public List<Game> loads() throws IOException {
        List<Game> games = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null){
                games.add(gameDeserializer.deserialize(line));
            }
        }
        return games;
    }
}
