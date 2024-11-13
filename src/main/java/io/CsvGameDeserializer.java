package io;

import model.Game;

public class CsvGameDeserializer implements GameDeserializer{

    private static int TITTLE = 1;
    private static int CONSOLE = 2;
    private static int TOTAL_SALE = 10;


    @Override
    public Game deserialize(String line) {
        return deserialize(line.split(","));
    }

    private Game deserialize(String[] fields){
        return new Game(fields[TITTLE], fields[CONSOLE], toInt(fields[TOTAL_SALE]));
    }

    private int toInt(String value) {
        if (value.isEmpty()) return 0;
        return (int) Double.parseDouble(value);
    }
}
