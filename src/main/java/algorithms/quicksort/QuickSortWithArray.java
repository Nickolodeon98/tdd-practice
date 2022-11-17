package algorithms.quicksort;

import java.util.Arrays;

/* 결국 동시에 rightIdx 와 leftIdx 를 계속해서 확인하면서 pivot 과 비교하고,
 * swap 여부를 결정한다. 모든 swap 과정 (1 증가, 1 감소 여부 포함) 이 완료된 후에
 * rightIdx -= 1 과 leftIdx += 1 을 해준다. */
public class QuickSortWithArray {
    private int[] arr;

    public QuickSortWithArray(int[] arr) {
        this.arr = arr;
    }

    public void swap(int candidate1, int candidate2) {
        int tmp = arr[candidate1];
        arr[candidate1] = arr[candidate2];
        arr[candidate2] = tmp;
    }

    public void switchOrStay() {
        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        int pivotIdx = arr.length/2;
        int pivot = arr[pivotIdx];
        /* 우선 while 문 조건을 처음부터 leftIdx 가 rightIdx 보다 작거나 같은 한 으로 설정해야 하는지,
         * 아니면 우선 직관적으로 leftIdx 를 pivotIdx 에 도달할 때까지 증가시키면서 교환한 후에
         * rightIdx 를 감소시키면서 교환하는 논리를 코드로 그대로 구현할 것인지 결정해야 한다.
         * 지금은 첫 구현이므로 후자로 하기로 한다. */
        while (leftIdx < rightIdx) {
            if (arr[leftIdx] < pivot) { // 작거나 같으면 안되는 이유는 pivot 에 도달했을 때 이 조건문을 빠져나와서 밑으로 들어가야 하기 때문이다.
                leftIdx += 1; // 이미 작으면 포인터만 증가시킨다.
                continue;
            }
            if (arr[rightIdx] > pivot) {
                rightIdx -= 1;
                continue;
            }
            swap(leftIdx, rightIdx); // 이건가?
            leftIdx += 1;
            rightIdx -= 1;
            System.out.println("left: " + leftIdx + " right: " + rightIdx);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] testArr = {20, 18, 5, 19, 40, 50, 5, 25};
        QuickSortWithArray quickSortWithArray = new QuickSortWithArray(testArr);
        quickSortWithArray.switchOrStay();
    }
}
