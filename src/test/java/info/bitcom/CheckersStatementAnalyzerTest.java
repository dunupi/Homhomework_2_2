package info.bitcom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckersStatementAnalyzerTest {
    @Test
    public void oneVariable() throws Exception{
        CheckersStatementAnalyzer analyzer = new CheckersStatementAnalyzer("a1");
        analyzer.set("a1");
        assertEquals("a1", analyzer.evaluate());

    }
}
