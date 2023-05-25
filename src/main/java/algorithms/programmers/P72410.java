package algorithms.programmers;

import java.util.*;

public class P72410 {

  public String solution(String new_id) {
    String answer = "";

    answer = new_id.toLowerCase();
    String newAns = answer;

    for (int i = 0; i < answer.length(); i++) {
      char c = answer.charAt(i);
      if (!Character.isDigit(c) && !Character.isAlphabetic(c) && !(c == '-' || c == '_'
          || c == '.')) {
        newAns = newAns.replace(Character.toString(c), "");
      }
    }

    while (newAns.contains("..")) {
      newAns = newAns.replace("..", ".");
    }

    if (newAns.length() > 0 && newAns.charAt(0) == '.') {
      newAns = newAns.substring(1, newAns.length());
    }
    if (newAns.length() > 0 && newAns.charAt(newAns.length() - 1) == '.') {
      newAns = newAns.substring(0, newAns.length() - 1);
    }

    if (newAns.length() == 0) {
      newAns = "a";
    }

    if (newAns.length() >= 16) {
      newAns = newAns.substring(0, 15);
      if (newAns.charAt(newAns.length() - 1) == '.') {
        newAns = newAns.substring(0, newAns.length() - 1);
      }
    }

    if (newAns.length() <= 2) {
      char last = newAns.charAt(newAns.length() - 1);
      while (newAns.length() < 3) {
        newAns += last;
      }
    }
    answer = newAns;
    return answer;
  }

}
