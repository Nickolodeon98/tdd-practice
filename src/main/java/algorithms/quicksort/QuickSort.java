package algorithms.quicksort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    /* 1. 배열의 중간(크기 / 2)에 있는 원소를 기준 값으로 잡는다.
     * 2. 모든 원소들과 비교하면서 기준 값보다 작은 값들은 left 에, 큰 값들은 right 에 넣는다.
     * 3. 정렬해야 하는 배열의 크기는 계속해서 반으로 줄게 된다. (재귀 또는 List 내 원소 교환) */

    public void divideIntoThree(int[] arrToBeSorted) {
        int pivotIdx = arrToBeSorted.length / 2;
        int pivot = arrToBeSorted[pivotIdx];
        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> centre = new ArrayList<>();

        for (int i : arrToBeSorted) {
            if (pivot < i) right.add(i);
            else if (pivot > i) left.add(i);
            else centre.add(i);
        }

        System.out.print(left + "\n" + centre + "\n" + right);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] testArr = {20, 18, 5, 19, 40, 50, 5, 25};
        quickSort.divideIntoThree(testArr);
    }
}
