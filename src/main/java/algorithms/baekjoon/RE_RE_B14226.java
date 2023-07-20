package algorithms.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RE_RE_B14226 {

  class Stage {
    int time;
    int emojiNum;
    int clipBoard;

    public Stage(int time, int emojiNum, int clipBoard) {
      this.time = time;
      this.emojiNum = emojiNum;
      this.clipBoard = clipBoard;
    }
  }

  public void BFS(int S) {
    boolean[][] visited = new boolean[2001][2001];
    Queue<Stage> candi = new LinkedList<>();

    candi.offer(new Stage(0, 1, 0));

    while (!candi.isEmpty()) {
      Stage s = candi.poll();

      if (s.emojiNum == S) {
        System.out.println(s.time);
        return;
      }

      if (s.emojiNum > 0 && s.emojiNum <= 2000) {
//        1. 복사
        if (!visited[s.emojiNum][s.emojiNum]) {
          visited[s.emojiNum][s.emojiNum] = true;

          candi.offer(new Stage(s.time + 1, s.emojiNum, s.emojiNum));
        }

//        2. 삭제
        if (!visited[s.emojiNum-1][s.clipBoard]) {
          visited[s.emojiNum-1][s.clipBoard] = true;

          candi.offer(new Stage(s.time + 1, s.emojiNum - 1, s.clipBoard));
        }
      }

      if (s.emojiNum > 0 && s.emojiNum + s.clipBoard <= 2000) {
        if (!visited[s.emojiNum + s.clipBoard][s.clipBoard]) {
          visited[s.emojiNum + s.clipBoard][s.clipBoard] = true;

          candi.offer(new Stage(s.time + 1, s.emojiNum + s.clipBoard, s.clipBoard));
        }
      }
    }
  }

  public static void main(String[] args) {
    RE_RE_B14226 test = new RE_RE_B14226();
    Scanner sc = new Scanner(System.in);

    int S = sc.nextInt();

    test.BFS(S);
  }

}
