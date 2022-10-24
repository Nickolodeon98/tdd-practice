package algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareToTest {
    int givenNum = 3;
    @DisplayName("compareTo() method returns as expected")
    @Test
    void dictSort() {
        CompareTo compareTo = new CompareTo();

        assertEquals(givenNum, compareTo.dictSort());
    }

}