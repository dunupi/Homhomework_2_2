package info.bitcom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckersStatementAnalyzerTest {



    @Test
    public void multipleVariables() throws Exception {
        CheckersStatementAnalyzer analyzer = new CheckersStatementAnalyzer("${one}, ${two}, ${three}");
        analyzer.set("one", "a1");
        analyzer.set("two", "a3");
        analyzer.set("three", "b2");
        assertEquals("a1, a3, b2",analyzer.evaluate());
    }
}
