package algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketTestTest {

    @Test
    @DisplayName("Correction of brackets")
    void brackets() {
        BracketTest bracketTest = new BracketTest();
        String trueSmallBrackets = "()()()";
        String falseSmallBrackets1 = "(()()(()";
        String falseSmallBrackets2 = "()()())";
        String falseSmallBrackets3 = "((((((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))";
        String falseVariousBrackets = "{}()[](({))";
        String trueVariousBrackets = "{}()[](({}))";

        assertTrue(bracketTest.correctBrackets(trueSmallBrackets));
        assertFalse(bracketTest.correctBrackets(falseSmallBrackets1));
        assertFalse(bracketTest.correctBrackets(falseSmallBrackets2));
        assertFalse(bracketTest.correctBrackets(falseSmallBrackets3));
        assertFalse(bracketTest.correctBrackets(falseVariousBrackets));
        assertTrue(bracketTest.correctBrackets(trueVariousBrackets));
    }
}