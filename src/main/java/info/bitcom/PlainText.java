package info.bitcom;

import java.util.Map;
import java.util.Objects;

public class PlainText implements Segment {
    private String text;
    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlainText)) return false;
        PlainText plainText = (PlainText) o;
        return Objects.equals(text, plainText.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        return null;
    }

    @Override
    public void appendTo(StringBuilder result, Map<String, String> variables) {

    }
}
