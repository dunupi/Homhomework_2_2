package info.bitcom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CheckersStatementAnalyzerTest {


    @Test
    public void multipleVariables() throws Exception {
        CheckersStatementAnalyzer analyzer = new CheckersStatementAnalyzer("${one}, ${two}, ${three}");
        analyzer.set("one", "a1");
        analyzer.set("two", "a3");
        analyzer.set("three", "b1");
        assertEquals("a1, a3, b1", analyzer.evaluate());

    }
}
