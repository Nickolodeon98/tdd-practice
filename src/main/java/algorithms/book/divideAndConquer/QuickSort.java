package algorithms.book.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

  public List<Integer> merge(List<Integer> left, List<Integer> centre, List<Integer> right) {
    List<Integer> sorted = new ArrayList<>();

    sorted.addAll(divide(left));
    sorted.addAll(divide(centre));
    sorted.addAll(divide(right));

    return sorted;
  }


  public List<Integer> divide(List<Integer> nums) {
    if (nums.size() == 1 || nums.isEmpty()) return nums;

    int pivot = nums.get(nums.size() / 2);
    List<Integer> right = new ArrayList<>();
    List<Integer> left = new ArrayList<>();
    List<Integer> centre = new ArrayList<>();

    for (int num : nums) {
      if (pivot < num) {
        right.add(num);
        continue;
      }
      if (pivot > num) {
        left.add(num);
        continue;
      }
        centre.add(num);
    }

    return merge(left, centre, right);
  }

  public static void main(String[] args) {
    QuickSort test = new QuickSort();
    List<Integer> testNums = List.of(23,14,2,4,1,62,40,30);
    System.out.println(test.divide(testNums));
  }
}

