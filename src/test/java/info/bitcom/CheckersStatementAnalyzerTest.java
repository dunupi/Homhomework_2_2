package info.bitcom;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckersStatementAnalyzerTest {

    private CheckersStatementAnalyzer analyzer;

    @Before
    public void setUp() throws Exception {
        analyzer = new CheckersStatementAnalyzer("${one}, ${two}, ${three}");
        analyzer.set("one", "a1");
        analyzer.set("two", "a3");
        analyzer.set("three", "b1");

    }


    @Test
    public void multipleVariables() throws Exception {

        assertAnalyzerEvaluatesTo("a1, a3, b1");
    }

    @Test
    public void whenUnknowmVariablesAreNotIgnoredThenException() throws Exception {
        analyzer.set("doesnotexist", "whatever");
        assertAnalyzerEvaluatesTo("a1, a3, b1");
    }

    private void assertAnalyzerEvaluatesTo(String expected) {
        assertEquals(expected, analyzer.evaluate());
    }

}
