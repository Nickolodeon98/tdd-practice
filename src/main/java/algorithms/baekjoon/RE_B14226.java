package algorithms.baekjoon;

public class RE_B14226 {
  boolean[] visited;

  public void solution(int S) {
    visited = new boolean[100];
    DFS(1, 0, S-1, 0);
  }

  public void DFS(int start, int clipboard, int goal, int cnt) {
    if (start == goal) {
      System.out.println(cnt);
      return;
    }

    for (int i = 0; i < 3; i++) {
      int cur = start;
      if (i == 0) {
        if (clipboard == 0) continue;
        cur += clipboard;
      }
      else if (i == 1) cur--;
      else clipboard = cur;

      if (cur < 0) continue;
      if (visited[cur]) continue;

      visited[cur] = true;
      DFS(cur, clipboard, goal, cnt + 1);
      visited[cur] = false;
    }
  }

  public static void main(String[] args) {
    RE_B14226 test = new RE_B14226();

    test.solution(18);
  }
}
