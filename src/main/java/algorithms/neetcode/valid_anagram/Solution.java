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

    Arrays.stream(sChars).forEach(sB::append);
    Arrays.stream(tChars).forEach(sT::append);

    return sB.toString().contentEquals(sT);
  }
}

