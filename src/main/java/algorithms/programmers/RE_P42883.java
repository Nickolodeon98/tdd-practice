package algorithms.programmers;

import java.util.*;

public class RE_P42883 {

  boolean[] visited;
  String num;
  List<String> nums;

  public String solution(String number, int k) {
    String answer = "";
    visited = new boolean[number.length()];
    num = number;
    nums = new ArrayList<>();
    int len = number.length() - k;

    DFS(new StringBuilder(), len, 0);

    Collections.sort(nums);

    answer = String.valueOf(nums.get(nums.size() - 1));
    return answer;
  }

  public void DFS(StringBuilder sb, int len, int idx) {
    if (sb.length() == len) {
      nums.add(sb.toString());
      return;
    }

    for (int i = idx; i < num.length(); i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      DFS(sb.append(num.charAt(i)), len, i);
      sb.deleteCharAt(sb.length() - 1);
      visited[i] = false;
    }
  }

}
