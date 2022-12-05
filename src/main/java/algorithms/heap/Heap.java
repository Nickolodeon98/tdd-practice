package algorithms.heap;

public class Heap {

    public static void biggerParent(int[] unsorted, int parentIdx) {
//        int[] sorted = new int[unsorted.length];


        int leftIdx = (2 * parentIdx) + 1; // 부모 노드의 왼쪽 자식 노드
        int rightIdx = (2 * parentIdx) + 2; // 부모 노드의 오른쪽 자식 노드

        // 자식이 있으면 부모 로 사용해서 더 자식이 있는지 탐색한다.
        if (leftIdx < unsorted.length) { // 왼쪽 자식이 있을 때 바로 재귀를 태우는 것이 아니라 먼저 왼쪽 자식 노드와 부모 노드를 비교한다.

            biggerParent(unsorted, leftIdx);
            if (rightIdx < unsorted.length) {

                biggerParent(unsorted, rightIdx);
            }
            return;
        }

        System.out.println(unsorted[parentIdx]); // 만약 자식이 없다면 부모 노드의 값을 알려준다.
        // 맨 마지막 leaf nodes 에 도달했다.

    }

    public static void main(String[] args) {
        int[] test = {6,7,5,8};
        biggerParent(test, 0);
    }
}
