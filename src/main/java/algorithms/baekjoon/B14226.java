package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;

public class B14226 {
// 3개의 연산
// S개를 화면에 작성하기 위해 필요한 시간의 최솟값
//  모든 연산은 1초가 소요
//  클립보드에 있는 내용은 덮어쓰기 된다.
//  클립보드가 저장할 정보는 현재 가지고 있는 이모티콘의 개수이다.
//  추적되어야 하는 정보는 화면에 입력된 이모티콘의 개수이다.
// 삭제는 단순히 1을 빼면 된다.
//
  int cnt = 0;
  boolean[] visited;
  public void solution(int S) {
    int emojiNum = 1;
    visited = new boolean[100];

    BFS(emojiNum, S);

    System.out.println(cnt);
  }

  public void BFS(int emojiNum, int goal) {
    int clipboard = 0;
    Queue<Integer> candi = new LinkedList<>();

    candi.offer(emojiNum);
    visited[emojiNum] = true;
    while (!candi.isEmpty()) {
      int cur = candi.poll();

      if (cur == goal) {
        cnt /= 3;
        break;
      }

      for (int i = 0; i < 3; i++) {
        int next = cur;
        if (i == 0)
          clipboard = next;
        else if (i == 1)
          next += clipboard;
        else
          next--;
        if (next < 0) continue;
        if (visited[next]) continue;

        if (next == goal) return;
        System.out.println(next);
        candi.offer(next);
        visited[next] = true;
      }
      cnt++;
    }
  }

  public static void main(String[] args) {
    B14226 test = new B14226();

    test.solution(18);
  }
}
