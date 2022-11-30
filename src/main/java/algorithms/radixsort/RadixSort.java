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

        return sorted.stream().mapToInt(i -> i).toArray();
    }

    /* 배열의 각 숫자의 자릿수 구하는 메서드 */
    public int[] getDigits(int[] arr) {
        HashSet<Integer> digits = new HashSet<>();
        for (int num : arr) {
            if (num == 0) {
                digits.add(0);
                continue;
            }
            int digit = (int) Math.log10(num);
            digits.add(digit);
        }
        int[] uniqueElements = digits.stream().mapToInt(i -> i).toArray();
        Arrays.sort(uniqueElements);
        return uniqueElements;
    }

    public int[] sort(int[] toSort, int[] digitTypes, int digitIdx) {
        if (digitIdx == digitTypes.length) return toSort;
        Queue<Integer>[] sortTool = new Queue[toSort.length];

        for (int i = 0; i < sortTool.length; i++) {
            sortTool[i] = new LinkedList<>();
        }

        for (int element : toSort) {
            sortTool[Math.floorDiv(element, (int) Math.pow(10, digitTypes[digitIdx])) % 10].add(element);
        }

        List<Integer> sorted = new ArrayList<>();

        for (Queue<Integer> queue : sortTool) {
            sorted.addAll(queue);
        }
        return sort(sorted.stream().mapToInt(i->i).toArray(), digitTypes, ++digitIdx);
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] test = {203, 0, 1, 2, 7, 7, 8, 13, 14, 16, 18};
//        System.out.println(Arrays.toString(radixSort.forDecimals(test)));
//        System.out.println(Arrays.toString(radixSort.getDigits(test)));
        System.out.println(Arrays.toString(radixSort.sort(test, radixSort.getDigits(test), 0)));
    }
}
