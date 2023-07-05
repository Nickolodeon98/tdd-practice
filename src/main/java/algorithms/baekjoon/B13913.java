package algorithms.baekjoon;

public class B13913 {
  int cnt = 0;
  boolean[] visited;
  public void solution() {
    visited = new boolean[17];
    DFS(5, 17);
    System.out.println(cnt);
  }
  public void DFS(int current, int goal) {
    if (current > goal) {
      cnt = Integer.MAX_VALUE;
      return;
    }
    if (current < 0) {
      cnt =  Integer.MAX_VALUE;
      return;
    }
    if (current == goal) {
      return;
    }
    visited[current] = true;

    if (current > 0 && !visited[current - 1])
      DFS(current - 1, goal);

    if (!visited[current + 1])
      DFS(current + 1, goal);

    DFS(2 * current, goal);
  }

  public static void main(String[] args) {
    B13913 test = new B13913();

    test.solution();
  }
}
