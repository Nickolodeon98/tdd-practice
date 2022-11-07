package algorithms.hash.programmers;

import java.util.*;

public class P12910 {
    public int[] divisibleNumbersArray(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> moduloZero = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) moduloZero.add(i);
        }
        if (moduloZero.size() == 0) moduloZero.add(-1);
        Collections.sort(moduloZero);
        answer = moduloZero.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        P12910 p12910 = new P12910();
        int[] testArr = {2, 36, 1, 3};
        System.out.println(Arrays.toString(p12910.divisibleNumbersArray(testArr, 1)));
    }
}
