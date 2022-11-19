package algorithms.caesar;

import algorithms.programmers.P12926;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarTest {
    P12926 caesar;
    String testCode;

    @BeforeEach
    void setUp() {
        caesar = new P12926();
        testCode = "A B C";
    }

    @Test
    @DisplayName("주어진 문자열에 시저 암호를 적용한다.")
    void applyCaesar() {
        assertEquals("E F G", caesar.solution(testCode, 4));
    }
}