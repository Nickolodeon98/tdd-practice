package algorithms.selectionsort;

import java.util.Arrays;
import java.util.function.BiFunction;

public class SelectionSort {
    interface SortStrategy extends BiFunction<Integer, Integer, Boolean> {

    }
    public int[] sort(int[] toSort, int current, SortStrategy sortStrategy) {
        /* 1단계: i = 0일 때 0 ~ arr.length-1 의 범위 내 최솟값의 인덱스 찾기
         * 2단계: i = current 로 놓고 계속 1씩 증가시키면서 만든 메서드를 재귀적으로 호출해 활용하기 */
        if (current == toSort.length-1) return toSort;

        int swapIdx = current; // 시작할 때는 0이지만 계속 1씩 증가한다.
        int min = toSort[swapIdx];

        for (int i = current; i < toSort.length; i++) { //범위가 계속 줄기 때문에 i의 시작 값도 인덱스에 맞춰서 증가한다.
            if (sortStrategy.apply(toSort[i], min)) {
                swapIdx = i;
                min = toSort[swapIdx];
            }
        }

        int tmp = toSort[swapIdx];
        toSort[swapIdx] = toSort[current]; // swap 해주는 원소의 위치도 1씩 증가한다.
        toSort[current] = tmp;

        return sort(toSort, current+1, sortStrategy);
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.sort(arr, 0, (a, b) -> a < b)));
        System.out.println(Arrays.toString(selectionSort.sort(arr, 0, (a, b) -> a > b)));
    }
}
