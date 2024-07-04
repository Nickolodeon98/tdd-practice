package algorithms.neetcode.products_of_array_discluding_self;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
  public int[] productExceptSelf(int[] nums) {
    int product = 1;
    Map<Integer, Integer> info = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      info.put(i+1, nums[i]);
    }

    int[] result = new int[nums.length];
    int count = 0;
    for (int j = 0; j < result.length; j++) {
      final int a = j+1;
      List<Integer> keys = info.keySet().stream().filter(k -> k != a)
          .collect(Collectors.toList());
      System.out.println(keys);
      for (int k : keys) {
        product *= info.get(k);
      }
      result[j] = product;
      product = 1;
    }

    return result;
  }
}

