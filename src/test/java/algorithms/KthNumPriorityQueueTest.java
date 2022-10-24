package algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KthNumPriorityQueueTest {
    int[] testArr = {1, 5, 2, 6, 3, 7, 4};
    int[][] testCommands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    @DisplayName("Sort using priority queue")
    @Test
    void sortUsingQueue() {
        KthNumPriorityQueue kthNumPriorityQueue = new KthNumPriorityQueue();

        assertEquals(Arrays.toString(new int[]{5, 6, 3}), Arrays.toString(kthNumPriorityQueue.solution(testArr, testCommands)));
    }

}