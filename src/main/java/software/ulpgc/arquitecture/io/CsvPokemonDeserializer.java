package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Pokemon;

public class CsvPokemonDeserializer implements PokemonDeserializer {
    @Override
    public Pokemon deserialize(String line){
        return deserialize(line.split(";"));
    }

    private Pokemon deserialize(String[] fields){
        return new Pokemon(toInt(fields[1]), fields[2], toInt(fields[5]), toInt(fields[15]));
    }

    private int toInt(String field) {
        if(field.isEmpty()) return 0;
        return Integer.parseInt(field);
    }
}
