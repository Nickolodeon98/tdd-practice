package algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketTestTest {

    @Test
    @DisplayName("Correction of brackets")
    void brackets() {
        BracketTest bracketTest = new BracketTest();
        String str1 = "()()()";
        String str2 = "(()()(()";
        String str3 = "()()())";
        String str4 = "((((((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))";
        assertTrue(bracketTest.correctBrackets(str1));
        assertFalse(bracketTest.correctBrackets(str2));
        assertFalse(bracketTest.correctBrackets(str3));
        assertFalse(bracketTest.correctBrackets(str4));
    }
}