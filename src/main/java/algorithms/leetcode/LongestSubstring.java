package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    public int searchForAnswer(String s, int start) {
      List<String> potentials = new ArrayList<>();
      char[] everyLetter = s.toCharArray();

      for (char c : everyLetter) {
        potentials.add(Character.toString(c));
      }

      char c = s.charAt(start);
      int startPtr = start;
      StringBuilder previous = new StringBuilder();
      previous.append(c);

      for (int i = start; i < s.length(); i++) {
        if (previous.indexOf(Character.toString(s.charAt(i))) == -1) {
          previous.append(s.charAt(i));
        } else {
          potentials.add(previous.toString());
          previous.setLength(0);
          startPtr = i;
        }
      }
      int answer = potentials.get(0).length();
      String answerWord = "";

      for (int i = 1; i < potentials.size(); i++) {
        String word = potentials.get(i);
        if (word.length() > answer) {
          answer = word.length();
          answerWord = word;
        }
      }
      System.out.println(answerWord);
      return answer;
    }

    public int lengthOfLongestSubstring(String s) {
      return searchForAnswer(s, 0);
    }
}
