package algorithms.book.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
  public void merge(List<Integer> target, int startIdx, int midIdx, int endIdx) {
    int n1 = midIdx - startIdx + 1;
    int n2 = endIdx - midIdx;

    int i;
    List<Integer> left = new ArrayList<>();
    for (i = 0; i < n1; i++) {
      left.add(target.get(startIdx + i));
    }
    int j;
    List<Integer> right = new ArrayList<>();
    for (j = 0; j < n2; j++) {
      right.add(target.get(midIdx + 1 + j));
    }

    i = 0;
    j = 0;
    int k = startIdx;

    while (i < n1 && j < n2) {
      if (left.get(i) <= right.get(j)) {
        target.set(k, left.get(i));
        i++;
      } else {
        target.set(k, right.get(j));
        j++;
      }
      k++;
    }

    while (i < n1) {
      target.set(k, left.get(i));
      i++;
      k++;
    }

    while (j < n2) {
      target.set(k, right.get(j));
      j++;
      k++;
    }
  }

  public void mergeSort(List<Integer> target, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;

      mergeSort(target, left, mid);
      mergeSort(target, mid + 1, right);

      merge(target, left, mid, right);
    }
  }

  public static void main(String[] args) {
    MergeSort test = new MergeSort();
    List<Integer> testNums = new ArrayList<>(List.of(23,14,2,4,1,62,40,30));

    test.mergeSort(testNums, 0, testNums.size() - 1);
    System.out.println(testNums);
  }
}
