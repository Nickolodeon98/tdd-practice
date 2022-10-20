package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

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
        assertEquals(10, stackVerTwo.pop());
        assertThrows(EmptyStackException.class, () -> {stackVerTwo.pop();});
        // 이 구간을 인터페이스라고 생각하면 된다. 익명 클래스를 사용하면 된다
        // 람다식의 (모던 자바의) 표현에서는 소괄호는 인터페이스 이름을 생략하긴 했지만 어떠한 인터페이스를 구현하는 구현체라는 뜻이고,
        // 이후 화살표와 중괄호를 이용해 어떠한 메소드를 구현하는 구현체인지를 나타내면 된다. 아래의 형식과 비슷하다.
        /*new interfaceEx() {
        *   interfaceMethod();
        * }*/
    }
    @DisplayName("check if empty")
    @Test
    void isEmpty() {
        boolean isEmpty = stackVerTwo.isEmpty();
        assertFalse(isEmpty);
        stackVerTwo.pop();
        stackVerTwo.pop();
        isEmpty = stackVerTwo.isEmpty();
        assertTrue(isEmpty);
    }

    @Test
    void realStack() {
        Stack<Integer> st = new Stack<>();
        assertThrows(EmptyStackException.class, () -> {st.pop();});
    }
}