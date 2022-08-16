package info.bitcom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.Entry;

public class CheckersStatementAnalyzer {

    private final Map<String,String> variables;
    private final String inputText;
    public CheckersStatementAnalyzer(String inputText){
        this.variables = new HashMap<>();
        this.inputText = inputText;
    }
    public void set(String coord, String value) {
        this.variables.put(coord,value);
    }


    public String evaluate(){
        CheckersStatementParse parser = new CheckersStatementParse();
        List<String> segments = parser.parse(inputText);
        return concatenateSegments(segments);
    }

    private String concatenateSegments(List<String> segments) {
        StringBuilder result = new StringBuilder();
        for(String segment : segments) {
            append(segment, result);
        }
        return result.toString();
    }


    private void append(String segment, StringBuilder result) {
        if (segment.startsWith("${") && segment.endsWith("}")) {
            String var = segment.substring(2, segment.length()-1);
            if (!variables.containsKey(var)) {
                throw new MissingValueException("No value for " + segment);
            }
            result.append(variables.get(var));
        } else {
            result.append(segment);
        }
    }

    private String replaceVariables() {
        String result = inputText;
        for (Entry<String,String> entry : variables.entrySet()) {

            String regex = "\\$\\{" + entry.getKey() + "}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }

    private void checkForMissingValues(String result){
        Matcher m = Pattern.compile(".*\\$\\{.*}").matcher(result);
        if (m.find()){
            throw new MissingValueException("No value for " + m.group());
        }

    }
}


