package info.bitcom;

import java.util.Map;
import java.util.Objects;

public class Variable implements Segment {
    private String name;
    public Variable(String name) {
        this.name = name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variable)) return false;
        Variable variable = (Variable) o;
        return Objects.equals(name, variable.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        return null;
    }

    @Override
    public void appendTo(StringBuilder result, Map<String, String> variables) {

    }
}
