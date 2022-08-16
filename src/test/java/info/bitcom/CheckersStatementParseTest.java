package info.bitcom;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CheckersStatementParseTest {

    private List<String> parse(String template) {
        return new CheckersStatementParse().parse(template);
    }

    private void assertSegments(List<? extends Object> actual,
                                Object... expected){
        assertEquals("Number of segments does not match.",
                expected.length, actual.size());
        assertEquals(Arrays.asList(expected),actual);
    }

    @Test
    public void emptyTemplateRendersAsEmptyString() throws Exception {
        List<String> segments = parse("");
        assertSegments(segments,"");
    }

    @Test
    public void templateWithOnlyPlainText() throws Exception {
        List<String> segments = parse("plain text only");
        assertSegments(segments,"plain text only");
    }

    @Test
    public void parsingMultipleVariables() throws Exception {
        List<String> segments = parse("${a1}:${b3} ${c1}-${d4}");
        assertSegments(segments,"${a1}", ":", "${b3}"," ", "${c1}", "-", "${d4}");
    }

}
