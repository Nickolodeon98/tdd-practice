package algorithms.selectionsort;

public class SelectionSort {
    public void sort(int[] toSort) {
        /* 1단계: i = 0일 때 0 ~ arr.length-1 의 범위 내 최솟값의 인덱스 찾기 */
        int minIdx = 0;
        int min = toSort[minIdx];

        for (int i = 0; i < toSort.length; i++) {
            if (toSort[i] < min) {
                minIdx = i;
                min = toSort[minIdx];
            }
        }
        System.out.printf("minIdx: %d\nmin: %d\n", minIdx, min);
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
    }
}
