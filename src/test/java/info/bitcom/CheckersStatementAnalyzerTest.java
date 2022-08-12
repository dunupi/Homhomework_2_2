package info.bitcom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CheckersStatementAnalyzerTest {
    @Test
    public void oneVariable() throws Exception{
        CheckersStatementAnalyzer analyzer = new CheckersStatementAnalyzer("a1");
        analyzer.set("a1");
        assertEquals("a1", analyzer.evaluate());

    }

    @Test
    public void differentValue() throws Exception {
        CheckersStatementAnalyzer analyzer = new CheckersStatementAnalyzer("a3");
        analyzer.set("a3");
        assertEquals("a3", analyzer.evaluate());
    }
}
