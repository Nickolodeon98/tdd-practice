package algorithms.programmers;

import java.util.*;

public class P86971 {
// 절댓값이 minimize 되도록 구현
// Math.min()
// 최초 송전탑의 개수는 n
// wires 에서 전력을 둘로 나누어서 각 전력망의 송전탑을 세어 개수가 비슷해질때까지(절댓값이 최소일 때까지) 계속 둘로 나눈다.
// DFS 로 개수를 센다
// 갈 수 있는 곳은 현재 뒤에 것이 앞이나 뒤와 같은 경우에 갈 수 있는 곳으로 판단하여 개수를 센다.

  boolean[] visited;
  int[][] info;
  int cnt = 0;

  public void seek(int start) {
    if (start >= info.length) {
      return;
    }

    for (int i = 0; i < info.length; i++) {

      if (visited[i]) {
        continue;
      }

      if (info[i][0] == info[start][0] || info[i][0] == info[start][1]) {
        visited[i] = true;
        cnt++;
        seek(i);
      } else if (info[i][1] == info[start][0] || info[i][1] == info[start][1]) {
        visited[i] = true;
        cnt++;
        seek(i);
      }
    }
  }

  public int solution(int n, int[][] wires) {
    int answer = -1;
    if (wires.length == 2) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    visited = new boolean[wires.length];
    info = wires;

    for (int i = 0; i < visited.length; i++) {
      visited[i] = true;
      seek(0);

      min = Math.min(min, Math.abs(cnt + 1 - (n - cnt - 1)));
      cnt = 0;
      visited = new boolean[wires.length];
    }
    answer = min;

    return answer;
  }

}
