package algorithms.selectionsort;

import java.util.Arrays;

public class SelectionSort {
    public void sort(int[] toSort) {
        /* 1단계: i = 0일 때 0 ~ arr.length-1 의 범위 내 최솟값의 인덱스 찾기 */
        int minIdx = 0; // 시작할 때는 0이지만 계속 1씩 증가한다.
        int min = toSort[minIdx];

        for (int i = 0; i < toSort.length; i++) { //범위가 계속 줄기 때문에 i의 시작 값도 인덱스에 맞춰서 증가한다.
            if (toSort[i] < min) {
                minIdx = i;
                min = toSort[minIdx];
            }
        }

        int tmp = toSort[minIdx];
        toSort[minIdx] = toSort[0];
        toSort[0] = tmp;

        System.out.printf("minIdx: %d\nmin: %d\n", minIdx, min);
        System.out.println(Arrays.toString(toSort));
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
    }
}
