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
        if (isVariable(segment)){
            evaluateVariable(segment,result);
        } else {
            result.append(segment);
        }
    }

    private boolean isVariable(String segment) {
        return segment.startsWith("${") && segment.endsWith("}");
    }

    private void evaluateVariable(String segment, StringBuilder result) {
        String var = segment.substring(2, segment.length()-1);
        if(!variables.containsKey(var)) {
            throw new MissingValueException("No value for " + segment);
        }
        result.append(variables.get(var));
    }

}


