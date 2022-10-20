package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackVerTwoTest {
    StackVerTwo stackVerTwo = new StackVerTwo();

    @BeforeEach
    void setUp() {
        stackVerTwo.push(10);
        stackVerTwo.push(20);
    }

    @DisplayName("push an element")
    @Test
    void push() {
//        stackVerTwo.push(10);
//        stackVerTwo.push(20);
        Integer[] arr = stackVerTwo.getArr();

        assertEquals(20, arr[1]);
        assertEquals(10, arr[0]);
    }

    @DisplayName("pop an element")
    @Test
    void pushAndPop() {
//        stackVerTwo.push(10);
//        stackVerTwo.push(20);
        int poppedElement = stackVerTwo.pop();
        assertEquals(20, poppedElement);
    }
}