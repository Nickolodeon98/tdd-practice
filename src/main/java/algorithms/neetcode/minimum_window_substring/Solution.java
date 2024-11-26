package algorithms.neetcode.minimum_window_substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public String minWindow(String s, String t) {
    int start = 0;
    int end = start;

    List<String> collected = new ArrayList<>();

    while (start <= end && end < s.length()) {
      Map<Character, Integer> alphabets = new HashMap<>();
      char[] letters = t.toCharArray();

      for (char letter : letters) {
        alphabets.put(letter, alphabets.getOrDefault(letter, 0) + 1);
      }

      String sub = s.substring(start, end+1);
      System.out.println(sub);
      // 존재 하면 지운다. 존재하지 않으면? 0 보다 작아진다.
      for (int i = 0; i <= end - start; i++) {
        if (alphabets.get(sub.charAt(i)) != null) {
          alphabets.put(sub.charAt(i), alphabets.get(sub.charAt(i)) - 1);
        }
      }
      System.out.println(alphabets);

      List<Integer> values = new ArrayList<>(alphabets.values());

      if (values.stream().anyMatch(v -> v >= 1)) {
        end++;
        continue;
      }

      collected.add(sub);
      start++;
    }

    if (collected.isEmpty()) {
      return "";
    }

    int min = Integer.MAX_VALUE;
    String minStr = "";
    for (String str : collected) {
      if (str.length() < min) {
        min = str.length();
        minStr = str;
      }
    }

    System.out.println(collected);

    return minStr;
  }
}