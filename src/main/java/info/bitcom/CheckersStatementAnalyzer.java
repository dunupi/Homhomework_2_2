package info.bitcom;

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class CheckersStatementAnalyzer {

    private final Map<String, String> coordinates;
    private String inputText;


    public CheckersStatementAnalyzer(String inputText) {
        this.coordinates = new HashMap<>();
        this.inputText = inputText;

    }

    public void set(String inputText, String value) {
        this.coordinates.put(inputText,value);
    }

    public String evaluate() {
        String result = inputText;
        for (Entry<String,String> entry : coordinates.entrySet()){
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }
}
