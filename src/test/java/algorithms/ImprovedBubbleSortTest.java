package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImprovedBubbleSortTest {
    int expectedResult = 2;
    int[] testArr = new int[]{10,50,30,20,40};

    @Test
    @DisplayName("정렬을 정상적으로 멈춤")
    void findSorted() {
        ImprovedBubbleSort improvedBubbleSort = new ImprovedBubbleSort(testArr);

        Assertions.assertEquals(expectedResult, improvedBubbleSort.findSorted());
    }

//    @Test
//    @DisplayName("테스트 케이스")
//    void test() {
//        Assertions.assertAll(
//                () -> assertFalse(true, "Exception!"),
//
//                () -> {
//                    ImprovedBubbleSort testObj = null;
//                    assertNotNull(testObj, "Object is null!");
//                }
//        );
//    }
}