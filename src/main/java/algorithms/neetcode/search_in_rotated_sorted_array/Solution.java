package algorithms.neetcode.search_in_rotated_sorted_array;

public class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    int midIdx = (right + left) / 2;
    System.out.println(nums[midIdx]);
    if (nums.length == 2) {
      if (nums[0] == target) {
        return 0;
      } else if (nums[1] == target) {
        return 1;
      }
      return -1;
    }

    while (midIdx > 0 && midIdx < nums.length - 1 &&
        right >= 0 && left < nums.length && !(nums[midIdx] == target)) {
      if (nums[left] == target) {
        return left;
      } else if (nums[right] == target) {
        return right;
      }

      int leftDiff = Math.abs(nums[midIdx - 1] - target);
      int rightDiff = Math.abs(nums[midIdx + 1] - target);

      int leftExtreme = Math.abs(nums[left] - target);
      int rightExtreme = Math.abs(nums[right] - target);

      if (leftDiff == 0) {
        return midIdx - 1;
      } else if (rightDiff == 0) {
        return midIdx + 1;
      }

      if (leftDiff < rightDiff && leftExtreme < rightExtreme) {
        right = midIdx - 1;
      } else {
        left = midIdx + 1;
      }
      midIdx = (right + left) / 2;
      if (nums[midIdx] == target) {
        return midIdx;
      }
    }

    if (nums[midIdx] != target) {
      return -1;
    }

    return midIdx;
  }
}