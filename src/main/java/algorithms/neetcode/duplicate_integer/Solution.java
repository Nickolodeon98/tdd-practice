package algorithms.neetcode.duplicate_integer;

import java.util.Arrays;

class Solution {
  public boolean hasDuplicate(int[] nums) {
    int len = nums.length;
    return len != Arrays.stream(nums).distinct().count();
  }
}
