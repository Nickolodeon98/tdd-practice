package algorithms.book.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class Karatsuba {
  public List<Integer> multiply(int[] a, int[] b) {
    List<Integer> values = new ArrayList<>();

    for (int n = 0; n < a.length + b.length + 1; n++) {
      values.add(0);
    }

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
        values.set(i + j, a[i] * b[j]);
      }
      
    }

    normalise(values);
    return values;
  }

  public void normalise(List<Integer> nums) {
    nums.add(0);
    for (int i = 0; i < nums.size(); i++) {
      if (nums.get(i) < 0) {
        int borrow = (Math.abs(nums.get(i)) + 9) / 10;
        nums.set(i + 1, nums.get(i + 1) - borrow);
        nums.set(i, nums.get(i) + borrow * 10);
      } else {
        nums.set(i+1, nums.get(i+1) + nums.get(i) / 10);
        nums.set(i, nums.get(i) % 10);
      }
    }

    while(nums.size() > 1 && nums.get(nums.size()-1) == 0) nums.remove(nums.size()-1);
  }


}
