package algorithms.neetcode.longest_substring_without_duplicates;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    // 해 - globalMax
    // 매번 가장 긴 부분 문자열 - localMax
    if (s.equals("")) {
      return 0;
    }

    char[] str = s.toCharArray();

    String globalMax = String.valueOf(str[0]);
    System.out.println(globalMax);
    String localMax = globalMax;

    for (int idx = 1; idx < str.length; idx++) {
      // 중복이 있을 시, localMax을 초기화한다.
      String current = String.valueOf(str[idx]);
      while (localMax.contains(current)) {
        if (String.valueOf(localMax.charAt(0)).equals(current)) {
          localMax = localMax.substring(1);
        } else {
          localMax = "";
          break;
        }
      }

      localMax += str[idx];
      System.out.println(localMax);

      if (globalMax.length() < localMax.length()) {
        globalMax = localMax;
      }
    }

    return globalMax.length();
  }
}