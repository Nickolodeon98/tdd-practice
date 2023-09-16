package algorithms.startup;

import java.util.*;

public class E9Pay {

  String[] words;
  String target;
  int min = Integer.MAX_VALUE;

  public void DFS(String cur, int cnt) {
    if (cur.matches("[.]+$")) {
      min = Math.min(min, cnt);
      return;
    }
    StringBuilder sb = new StringBuilder(cur);

    for (String word : words) {
      if (sb.toString().contains(word)) {
        int targetIdx = sb.indexOf(word);
        sb.replace(targetIdx, targetIdx + word.length(), ".".repeat(word.length()));
        DFS(sb.toString(), cnt + 1);
        sb = sb.replace(targetIdx, targetIdx + word.length(), word);
      }
    }
  }

  public int solution(String[] strs, String t) {
    int answer = 0;

    words = strs;
    target = t;

    DFS(target, 0);
    answer = min;
    return answer == Integer.MAX_VALUE ? -1 : answer;
  }

}
