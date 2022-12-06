package algorithms.heap;

import java.util.Arrays;

public class Heap {

    public static int[] makeHeap(int[] unsorted, int parentIdx) {
        int[] sorted = unsorted;

        int greaterIdx = parentIdx;

        int leftIdx = (2 * parentIdx) + 1; // 부모 노드의 왼쪽 자식 노드
        int rightIdx = (2 * parentIdx) + 2; // 부모 노드의 오른쪽 자식 노드

        // 자식이 있으면 부모 로 사용해서 더 자식이 있는지 탐색한다.
        // 없으면 맨 밑까지 아무 조건에 걸리지 않아서 바로 리턴된다.
        if (leftIdx < unsorted.length) { // 왼쪽 자식이 있을 때 바로 재귀를 태우는 것이 아니라 먼저 왼쪽 자식 노드와 부모 노드를 비교한다.
            if (unsorted[leftIdx] > unsorted[greaterIdx]) {
                greaterIdx = leftIdx;
            }

            if (rightIdx < unsorted.length) {
                if (unsorted[rightIdx] > unsorted[greaterIdx]) {
                    greaterIdx = rightIdx;
                }
            }
        }

        if (parentIdx != greaterIdx) { // 부모 노드가 자식 노드보다 커서 변동사항이 있었을 때, 두 노드를 바꾸어준다.
            int temp = unsorted[parentIdx];
            unsorted[parentIdx] = unsorted[greaterIdx];
            unsorted[greaterIdx] = temp;
            // 바꾼 후에는 더 컸던 자식 노드의 자리에서 한 번 더 재귀적으로 makeHeap 을 해야 한다.
            // 바뀐 뒤에는 greaterIdx 가 있는 노드가 자식들보다 크리라는 보장이 없기 때문이다.
            sorted = makeHeap(unsorted, greaterIdx);
        }
        return sorted;
//        System.out.println(unsorted[parentIdx]); // 만약 자식이 없다면 부모 노드의 값을 알려준다.
//         맨 마지막 leaf nodes 에 도달했다.

    }

    public static void main(String[] args) {
        int[] test = {6,5,7,8};
//        System.out.println(Arrays.toString(makeHeap(test, (test.length-2) / 2)));
        // 자식이 있는 가장 마지막 부모 노드 (= 마지막 자식의 위 층 = 왼쪽 자식 위치 / 2 또는 자기 옆 부모의 오른쪽 자식의 위치 / 2
        // 또는 자기 바로 옆 노드 위치 / 2 == 배열의 길이 - 2 (즉 맨 뒤에서 두번째) / 2)...
        // 를 시작으로 맨 위 루트 노드까지 모든 노드들을 탐색하며 반복해야 한다.

        for (int i = (test.length-2) / 2; i >= 0; i--) {
            System.out.println(Arrays.toString(makeHeap(test, i)));
        }

        /*

          6
         5 7
        8

         6
        8 7
       5
        */
    }
}
