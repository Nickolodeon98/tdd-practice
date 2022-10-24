package algorithms.kthnum;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthNumPriorityQueue {
    public int[] solution(int[] arr, int[][] commands) {
        int[] answer = new int[commands.length];
        Queue<Integer> sortingQueue = new PriorityQueue<>();

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
                sortingQueue.add(arr[j]);
            }
            for (int k = 0; k < commands[i][2]; k++) {
                answer[i] = sortingQueue.poll();
            }
        }

        return answer;
    }
}
