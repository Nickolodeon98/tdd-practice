package algorithms.gcd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreatestCommonDivisorTest {

    GreatestCommonDivisor greatestCommonDivisor;

    @BeforeEach
    void setUp() {
        greatestCommonDivisor = new GreatestCommonDivisor();
    }

    @Test
    @DisplayName("최대공약수를 찾는다.")
    void findGcd() {
        assertEquals(64, greatestCommonDivisor.computeDivisor(64, 128));
        assertEquals(14, greatestCommonDivisor.computeDivisor(196, 42));
    }

}