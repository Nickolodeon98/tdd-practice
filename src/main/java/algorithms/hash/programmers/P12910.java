package algorithms.hash.programmers;

import java.util.*;

public class P12910 {
    public int[] divisibleNumbersArray(int[] arr, int divisor) {
        int[] answer = {};
        Queue<Integer> moduloZero = new PriorityQueue<>();
        for (int i : arr) {
            if (i % divisor == 0) moduloZero.add(i);
        }
        if (moduloZero.size() == 0) moduloZero.add(-1);
        answer = moduloZero.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        P12910 p12910 = new P12910();
        int[] testArr = {5, 9, 7, 10};
        System.out.println(Arrays.toString(p12910.divisibleNumbersArray(testArr, 5)));
    }
}
