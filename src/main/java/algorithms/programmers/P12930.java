package algorithms.programmers;

import java.util.*;

public class P12930 {

  public String solution(String s) {
    String answer = "";

    // 우선 전부 소문자로 바꾼다.
    s = s.toLowerCase();
    char[] characters = s.toCharArray();
    System.out.println(Arrays.toString(characters));
    StringBuilder sb = new StringBuilder();
    int i = 0;

    for (char c : characters) {
      if (c == ' ') {
        sb.append(c);
        i = 0;
      } else if (i == 0 || i % 2 == 0) {
        sb.append(Character.toUpperCase(c));
        i++;
      } else {
        sb.append(c);
        i++;
      }
    }

    answer = sb.toString();

    return answer;
  }
}
