package algorithms.stack;

import java.util.*;

public class P12906WithDeque {
    public int[] solution(int[] arr) {
        Deque<Integer> remainder = new LinkedList<>();
        for (int i : arr) {
            try {
                if (remainder.getLast() == i) continue;
            } catch (Exception e) {
            }
            remainder.offer(i);
        }


        int[] answer = new int[remainder.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = remainder.pollFirst();
        }

        return answer;
    }

    public static void main(String[] args) {
        P12906WithDeque p12906WithQueue = new P12906WithDeque();
        int[] test = {1,1,3,3,0,1,1};
        int[] testArr = p12906WithQueue.solution(test);

        System.out.println(Arrays.toString(testArr));
    }
}
