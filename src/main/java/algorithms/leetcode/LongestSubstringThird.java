package algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringThird {
    public boolean hasDuplicates(String s) {
      if (s.length() == 1) return false;

      Set<Character> duplicateChecker = new HashSet<>();

      for (char letter : s.toCharArray())
        duplicateChecker.add(letter);
      if (duplicateChecker.size() < s.length())
        return true;
      return false;
    }

    public int lengthOfLongestSubstring(String s) {
      int length = 0;
      if (s.equals(" ")) return 1;

      // for (int i = 0; i <= s.length()-1; i++) {
      //     for (int j = i+1; j <= s.length(); j++) {
      //         String longestSubstring = s.substring(i, j);
      //         if (hasDuplicates(longestSubstring)) continue;
      //         currentLength = longestSubstring.length();
      //         if (currentLength > length)
      //             length = longestSubstring.length();
      //     }
      // }
      int count = s.length();
      while (count >= 0) {
        for (int i = 0; i + count <= s.length(); i++) {
          // 1. endIdx == s.length()
          // length 6 substrings -> (0, 6) done.
          // length 5 -> (0, 5), (1, 6) done.
          String longest = s.substring(i, i + count);
          if (!hasDuplicates(longest)) {
            length = longest.length();
            return length;
          }
        }

        count--;
      }
      return length;
    }
}
