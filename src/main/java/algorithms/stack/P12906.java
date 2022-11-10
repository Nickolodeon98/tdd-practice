package algorithms.stack;

import algorithms.programmers.P12910;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* arr 를 반복문으로 탐색하면서 현재 원소를 추가한다.
 * 그 다음에 나온 원소의 값이 같지 않다면 리스트에 추가한다.
 * 같다면 추가하지 않는다. */
public class P12906 {
    public int[] solution(int[] arr) {
        int current = -1; // 매번 현재 원소를 기억, 초기값은 같을 리 없는 숫자 -1
        List<Integer> remainder = new ArrayList<>();

        for (int i : arr) {
            if (current == i) continue; // 이전 숫자와 같으면 넘어간다.
            remainder.add(i);
            current = i;
        }

        return remainder.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        P12906 p12906 = new P12906();
        int[] test = {4, 4, 4, 3, 3};
        int[] testAns = p12906.solution(test);

        System.out.println(Arrays.toString(testAns));

    }
}
