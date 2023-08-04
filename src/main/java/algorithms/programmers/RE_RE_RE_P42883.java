package algorithms.programmers;

import java.util.*;

public class RE_RE_RE_P42883 {

  public String solution(String number, int k) {
    char[] result = new char[number.length() - k];

    Stack<Character> candi = new Stack<>();

    for (int i = 0; i < number.length(); i++) {
      char c = number.charAt(i);
      while (!candi.isEmpty() && candi.peek() < c && k > 0) {
        candi.pop();
        k--;
      }
      candi.push(c);
    }

    for (int j = 0; j < result.length; j++) {
      result[j] = candi.get(j);
    }

    return new String(result);
  }

}
