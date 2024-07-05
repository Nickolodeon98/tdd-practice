package algorithms.neetcode.longest_consecutive_sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Set<Integer> sortedNums = new TreeSet<>();

    Arrays.stream(nums).forEach(n -> sortedNums.add(n));

    Stack<Integer> numStack = new Stack<>();
    sortedNums.stream().forEach(s -> numStack.push(s));
    int count = 1;

    System.out.println(numStack);

    List<Integer> counts = new ArrayList<>();

    int n = 0;
    while (!numStack.isEmpty()) {
      n = numStack.pop();

      if (numStack.isEmpty()) {
        counts.add(count);
        break;
      }

      if (n != numStack.peek() + 1) {
        counts.add(count);
        count = 1;
        continue;
      }
      count++;
    }

    Collections.sort(counts);

    return counts.get(counts.size()-1);
  }
}

