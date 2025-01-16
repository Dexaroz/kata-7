package software.ulpgc.io;

import software.ulpgc.model.Pokemon;

public class CsvPokemonDeserializer implements PokemonDeserializer {
    @Override
    public Pokemon deserialize(String line){
        return deserialize(line.split(";"));
    }

    private Pokemon deserialize(String[] fields){
        return new Pokemon(toInt(fields[1]), fields[2], toInt(fields[5]));
    }

    private int toInt(String field) {
        if(field.isEmpty()) return 0;
        return Integer.parseInt(field);
    }
}
