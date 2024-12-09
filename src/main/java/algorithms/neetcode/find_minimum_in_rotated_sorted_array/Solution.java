package algorithms.neetcode.find_minimum_in_rotated_sorted_array;

public class Solution {
  public int findMin(int[] nums) {
    int midIdx = nums.length / 2;

    int first = 0;
    int last = nums.length - 1;

    while (last - first > 1) {
      if (nums[midIdx - 1] < nums[midIdx + 1] && nums[midIdx-1] < nums[last]) {
        last = midIdx;
        midIdx = (midIdx - first) / 2;
      } else {
        first = midIdx;
        midIdx = midIdx + ((last - midIdx) / 2);
      }
    }

    return Math.min(nums[last], nums[first]);
  }
}

