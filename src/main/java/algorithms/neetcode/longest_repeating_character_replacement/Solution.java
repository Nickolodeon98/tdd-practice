package algorithms.neetcode.longest_repeating_character_replacement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {

  public int characterReplacement(String s, int k) {

    // Map 에 key 는 알파벳으로, value 는 개수로 넣은 후 value 로 내림차순

    Map<Character, Integer> alphabets = new TreeMap<>();
    int n = 0;
    for (char c = 'A'; c <= 'Z'; c++) {
      alphabets.put(c, n++);
    }
    List<Integer> nums = new ArrayList<>();

    int[] letters = new int[26];

    int start = 0;
    int i = start;
    int end = start;
    String curStr = "";
    // start ~ end 문자열
    while (start <= end && end < s.length()) {
      System.out.println("start: " + start + ", " + "end: " + end);
      curStr = s.substring(start, end + 1);
      for (int idx = start; idx <= end; idx++) {
        letters[alphabets.get(curStr.charAt(idx - start))] += 1;
      }
      System.out.println(Arrays.toString(letters));
      int max = -1;
      int maxIdx = 0;
      for (int idx = 0; idx < letters.length; idx++) {
        if (max < letters[idx]) {
          max = letters[idx];
          maxIdx = idx;
        }
      }
      letters = new int[26];

      if (curStr.length() - max <= k) {
        System.out.println(curStr.length() - max);
        if (curStr.length() - max == k) {
          nums.add(curStr.length());
        }
        end++;
        continue;
      }
      start++;
    }
    nums.add(curStr.length());

    Collections.sort(nums, (a, b) -> b - a);

    System.out.println(nums);

    return nums.get(0);
  }
}
