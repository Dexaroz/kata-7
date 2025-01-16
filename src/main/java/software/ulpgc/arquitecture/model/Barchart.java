package software.ulpgc.arquitecture.model;

import java.util.HashMap;
import java.util.Map;

public record Barchart(String title, String xAxis, String yAxis, Map<String, Integer> data) {

    public Barchart(String title, String xAxis, String yAxis) {
        this(title, xAxis, yAxis, new HashMap<>());
    }

    public void put(String category, int value){
        data.put(category, value);
    }
}
