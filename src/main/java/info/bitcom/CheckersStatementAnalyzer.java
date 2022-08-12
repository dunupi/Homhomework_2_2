package info.bitcom;

public class CheckersStatementAnalyzer {

    private String variableValue;
    public CheckersStatementAnalyzer(String inputText){
    }
    public void set(String value) {
        this.variableValue = value;
    }

    public String evaluate() {
        return variableValue;
    }
}
