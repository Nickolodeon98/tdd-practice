package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackImplementationTest {

    @DisplayName("push")
    @Test
    void pushTest() {
        StackImplementation stackImplementation = new StackImplementation(10000);
        stackImplementation.push(10);
        stackImplementation.push(20);

        int[] stack = stackImplementation.getStack();
//        Assertions.assertEquals(10, stackImplementation.getStack()[0]);

        Assertions.assertEquals(20, stack[1]);
    }

    @DisplayName("push and pop")
    @Test
    void pushAndPop() {
        StackImplementation stackImplementation = new StackImplementation();
        stackImplementation.push(10);
        stackImplementation.push(20);

        stackImplementation.push(30);

        Assertions.assertEquals(30, stackImplementation.pop());
        Assertions.assertEquals(20, stackImplementation.pop());
        Assertions.assertEquals(10, stackImplementation.pop());
    }
}