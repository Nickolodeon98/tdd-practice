package algorithms.radixsort;

import java.util.*;

public class RadixSort {
    /* 숫자가 몇진수인지에 따라 생성하는 배열 내의 원소 개수가 정해진다.
     * 10진수는 사이즈 10의 배열을 만든다. */

    public int[] forDecimals(int[] toSort) {
        /* 사이즈 10의 배열을 만든다. */
        int[] arr = new int[10];
        Arrays.fill(arr, -1);

        for (int element : toSort) {
            arr[element] = element;
        }

        List<Integer> sorted = new ArrayList<>();
        for (int sortedElem : arr) {
            if (sortedElem != -1) sorted.add(sortedElem);
        }

        return sorted.stream().mapToInt(i->i).toArray();
    }

    /* 배열의 각 숫자의 자릿수 구하는 메서드 */
    public int[] getDigits(int[] arr) {
//        List<Integer> digits = new ArrayList<>();
        HashSet<Integer> digits = new HashSet<>();
        for (int num : arr) {
            if (num == 0) {
                digits.add(1);
                continue;
            }
            int digit = (int)Math.log10(num)+1;
            digits.add(digit);
        }
        return digits.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] test = {0, 1, 2, 7, 7, 8, 13, 14, 16, 18, 203};
//        System.out.println(Arrays.toString(radixSort.forDecimals(test)));
        System.out.println(Arrays.toString(radixSort.getDigits(test)));
    }
}
