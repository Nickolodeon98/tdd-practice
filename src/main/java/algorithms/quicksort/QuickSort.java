package algorithms.quicksort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    /* 1. 배열의 중간(크기 / 2)에 있는 원소를 기준 값으로 잡는다.
     * 2. 모든 원소들과 비교하면서 기준 값보다 작은 값들은 left 에, 큰 값들은 right 에 넣는다.
     * 3. 정렬해야 하는 배열의 크기는 계속해서 반으로 줄게 된다. (재귀 또는 List 내 원소 교환)
     * 질문: 만약 중복되는 수가 기준값이 되었다면 분류할 수 없는데 어떤 방법을 써서 정렬할 수 있을까?
     *  답: 어차피 중복되는 수 두개는 붙어있어야 하므로 두 개가 한 곳에 같이 있어도 상관 없다. */

    public List<Integer> divideIntoThree(List<Integer> arrToBeSorted) {
        if (arrToBeSorted.size() <= 1 || arrToBeSorted.stream().distinct().count() == 1)
            return arrToBeSorted; // 더 이상 쪼갤 수 없을 때 현재 리스트를 리턴한다.

        int pivotIdx = arrToBeSorted.size() / 2;
        int pivot = arrToBeSorted.get(pivotIdx);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> centre = new ArrayList<>();

        for (int i : arrToBeSorted) {
            if (pivot < i) right.add(i);
            else if (pivot > i) left.add(i);
            else centre.add(i);
        }

        // 리턴할 때 재귀적으로 나누어진 배열들을 더 쪼개고, 마지막에 병합함으로서 정렬한다.
        List<Integer> processed = divideIntoThree(left); // 결국 원소 하나의 리스트가 될 때까지 쪼개고 병합한 후에 processed 에 결과가 할당된다.
        System.out.println("left:\n" + processed);
        processed.addAll(divideIntoThree(centre)); // 정렬된 중간 리스트를 더한다.
        System.out.println("centre:\n" + processed);
        processed.addAll(divideIntoThree(right)); // 정렬된 오른쪽 리스트를 더한다.
        System.out.println("right:\n" + processed);
        System.out.println("--------------------");
        return processed;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        List<Integer> testArr = List.of(20, 18, 5, 19, 40, 50, 5, 25);
        System.out.println(quickSort.divideIntoThree(testArr));
    }
}
