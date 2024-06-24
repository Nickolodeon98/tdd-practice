package algorithms.neetcode.valid_anagram;

import java.util.Arrays;

class Solution {
  public boolean isAnagram(String s, String t) {
    String[] sChars = s.split("");
    String[] tChars = t.split("");

    Arrays.sort(sChars);
    Arrays.sort(tChars);

    StringBuilder sB = new StringBuilder();
    StringBuilder sT = new StringBuilder();

    Arrays.stream(sChars).forEach(e -> sB.append(e));
    Arrays.stream(tChars).forEach(e -> sT.append(e));

    return sB.toString().equals(sT.toString());
  }
}

