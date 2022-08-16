package info.bitcom;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CheckersStatementParseTest {

    @Test
    public void emptyTemplateRendersAsEmptyString() throws Exception {
        CheckersStatementParse parse = new CheckersStatementParse();
        List<String> segments = parse.parse("");
        assertEquals("Number of segments", 1, segments.size());
        assertEquals("", segments.get(0));
    }
}
