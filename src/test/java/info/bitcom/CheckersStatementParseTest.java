package info.bitcom;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CheckersStatementParseTest {

    private List<String> parse(String template) {
        return new CheckersStatementParse().parse(template);
    }

    @Test
    public void emptyTemplateRendersAsEmptyString() throws Exception {
        List<String> segments = parse("");
        assertEquals("Number of segments", 1, segments.size());
        assertEquals("", segments.get(0));
    }

    @Test
    public void templateWithOnlyPlainText() throws Exception {
        List<String> segments = parse("plain text only");
        assertEquals("Number of segments ",1, segments.size());
        assertEquals("plain text only", segments.get(0));
    }


}
