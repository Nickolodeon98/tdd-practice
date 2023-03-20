package algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringSecond {
  public int lengthOfLongestSubstring(String s) {
    int length = 0;


    // s must stop when any duplicate letter appears

    // update length variable whenever single substring ends
    // ends when hashset size does not change after adding letter

    // OR when
    Set<Character> duplicateChecker = new HashSet<>();

    int count = 0;
    StringBuilder longestSubstring = new StringBuilder();
    char currentlyLast = ' ';

    for (int i = 0; i < s.length(); i++) {
      count = duplicateChecker.size();
      System.out.printf("i:%s, count:%s\n", i, count);
      duplicateChecker.add(s.charAt(i));
      System.out.println(duplicateChecker.size());
      if (duplicateChecker.size() != count) {
        longestSubstring.append(Character.toString(s.charAt(i)));
        System.out.println(longestSubstring.toString());
        if (length < longestSubstring.length())
          length = longestSubstring.length();
      } else {
        currentlyLast = s.charAt(i-1);
        System.out.println("currentlyLast: " + currentlyLast);
        longestSubstring.setLength(0);
        System.out.println(longestSubstring.toString());
        duplicateChecker.clear();
        if (currentlyLast != s.charAt(i)) {
          longestSubstring.append(currentlyLast);
          duplicateChecker.add(currentlyLast);
        }

        longestSubstring.append(Character.toString(s.charAt(i)));
        duplicateChecker.add(s.charAt(i));
        System.out.println(longestSubstring.toString());
      }
    }
    System.out.println("length is " +length);
    // output should be the number that represents length

    return length;
  }
}
