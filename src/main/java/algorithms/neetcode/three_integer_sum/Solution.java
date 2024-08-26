package algorithms.neetcode.three_integer_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    List<Integer> triplets = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length-2; i++) {
      int L = i + 1;
      int R = nums.length - 1;
      if (i > 0 && nums[i] == nums[i-1]) {
        continue;
      }
      while (R < nums.length && L >= 0 && L < R) {
        if (R+1 < nums.length && L-1 >= 0 && nums[R] == nums[R+1] && nums[L] == nums[L-1]) {
          R--;
          L++;
          continue;
        }
        sum = nums[i] + nums[L] + nums[R];
        if (sum > 0) {
          R--;
        } else if (sum < 0) {
          L++;
        } else if (sum == 0) {
          triplets.add(nums[i]);
          triplets.add(nums[L]);
          triplets.add(nums[R]);
          result.add(triplets);
          triplets = new ArrayList<>();
          L++;
          R--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
//    threeSum(new int[]{-1,0,1,2,-1,-4});
//    threeSum(new int[]{0,0,0,0});
    threeSum(new int[]{-2, 0, 0, 2, 2});
  }
}

