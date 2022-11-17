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

    public int[] getArr() {
        return arr;
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
        while (leftIdx <= rightIdx) { // 같을 때 (leftIdx == rightIdx) 에도 교환은 일어난다는 뜻이다. 같은지 확인하는 비용이 더 많이 들기 때문에 교환한다.
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

    public void sort(int startIdx, int endIdx) { // 최초의 start 와 end 는 각각 arr 의 가장 첫 인덱스와 가장 마지막 인덱스이다.

        if (startIdx == endIdx) return;

        int oldPivotIdx = arr.length / 2; // 지금까지의 기준값 인덱스 선정 방식
        int pivotIdx = (endIdx + startIdx + 1) / 2; // 변경된 선정 방식

        int pivot = arr[pivotIdx]; // pivot 값 선정

        /* 우선 편의를 위해 식별이 쉬운 이름을 가진 변수에 할당한다. */
        int leftIdx = startIdx;
        int rightIdx = endIdx;

        while (rightIdx >= leftIdx) { // 두 지점이 교차될 때까지 반복한다.
            if (arr[leftIdx] < pivot) { // pivot 보다 왼쪽에 있는 값이 자기 자리에 잘 있을 때
                leftIdx++;
                continue;
            }
            if (arr[rightIdx] > pivot) { // 왼쪽에 있는 값이 교환이 필요한데, pivot 보다 오른쪽에 있는 값이 자기 자리에 잘 있을 때
                rightIdx--; // 새로운 교환 대상을 찾기 위해 한 칸 왼쪽으로 움직여 탐색을 이어나간다.
                continue;
            }
            /* 만약 위 두 개의 조건문을 통과하고 여기까지 왔으면, 교환을 해야 되는 상황에 적절한 교환 대상도 찾았다는 뜻이다. */
            swap(leftIdx, rightIdx); // 교환해주자
            /* 교환 후에는 이번 phase 에서는 자기 자리를 찾아갔다. 이 자리 이후 자리들을 교환하자. */
            leftIdx++;
            rightIdx--;
        }
        /* 여기로 나왔을 떄는 이미 교차되어서 rightIdx < leftIdx 인 상황이다.
         * 그러므로, rightIdx 가 첫 번째 분할의 endIdx, leftIdx 가 두 번째 분할의 startIdx 가 되어서 재귀 호출시킨다. */
        sort(startIdx, rightIdx);
        sort(leftIdx, endIdx);
    }



    public static void main(String[] args) {
        int[] testArr = {20, 18, 5, 19, 40, 50, 5, 25};
        QuickSortWithArray quickSortWithArray = new QuickSortWithArray(testArr);
//        quickSortWithArray.switchOrStay();
        quickSortWithArray.sort(0, 7);
        System.out.println(Arrays.toString(quickSortWithArray.getArr()));
    }
}
