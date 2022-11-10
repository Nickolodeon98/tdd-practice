package algorithms.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class P12906WithStack {
    public int[] solution(int[] arr) {
        Stack<Integer> remainder = new Stack<>();
        for (int i : arr) {
            try {
                if (remainder.peek() == i) continue;
            } catch (EmptyStackException e) {
            }
            remainder.push(i);
        }

        Collections.reverse(remainder);

        int[] answer = new int[remainder.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = remainder.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        P12906WithStack p12906WithStack = new P12906WithStack();
        int[] test = {1,1,3,3,0,1,1};
        int[] testArr = p12906WithStack.solution(test);

        System.out.println(Arrays.toString(testArr));
    }
}
