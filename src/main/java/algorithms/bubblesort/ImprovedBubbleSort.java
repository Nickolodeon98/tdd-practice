package algorithms.bubblesort;

public class ImprovedBubbleSort {
    private int[] arrToSort;

    public ImprovedBubbleSort(int[] arrToSort) {
        this.arrToSort = arrToSort;
    }

    public int findSorted() {
        boolean swapped = false;
        int ret = 0;

        for (int i = 0; i < arrToSort.length; i++) {
            for (int j = 1; j < arrToSort.length; j++) {
                if (arrToSort[j] < arrToSort[j-1]) {
                    int temp = arrToSort[j - 1];
                    arrToSort[j - 1] = arrToSort[j];
                    arrToSort[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
//                System.out.println(i);
                ret = i;
                break;
            }
            swapped =false;
        }

        return ret;
    }
}
