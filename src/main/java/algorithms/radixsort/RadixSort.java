package algorithms.radixsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] test = {7,4,5,9,1,0};
        System.out.println(Arrays.toString(radixSort.forDecimals(test)));
    }
}
