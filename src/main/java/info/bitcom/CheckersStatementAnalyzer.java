package info.bitcom;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.Entry;

public class CheckersStatementAnalyzer {

    private Map<String,String> variables;
    private String inputText;
    public CheckersStatementAnalyzer(String inputText){
        this.variables = new HashMap<>();
        this.inputText = inputText;
    }
    public void set(String coord, String value) {
        this.variables.put(coord,value);
    }

    public String evaluate() {
        String result = replaceVariables();
        checkForMissingValues(result);
        return result;
    }
    private String replaceVariables() {
        String result = inputText;
        for (Entry<String,String> entry : variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }

    private void checkForMissingValues(String result){
        if (result.matches(".*\\$\\{.+\\}.*")){
            throw new MissingValueException();
        }

    }
}


