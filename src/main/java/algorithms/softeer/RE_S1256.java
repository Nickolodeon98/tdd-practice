package algorithms.softeer;

import java.io.*;
import java.util.*;

public class RE_S1256 {

  static int H;
  static int K;
  static int R;
  static int answer;

  public static class Worker {

    int depth;
    Queue<Integer> job;
    Queue<Integer> leftJob;
    Queue<Integer> rightJob;

    public Worker(int depth) {
      this.depth = depth;
      if (this.depth == H) {
        job = new LinkedList<>();
      } else {
        leftJob = new LinkedList<>();
        rightJob = new LinkedList<>();
      }
    }
  }

  static Worker[] worker;

  public static void pro(int idx, int date, int depth) {
    if (depth > H) {
      return;
    }

    Worker cur = worker[idx];
    // 말단 노드일 때
    if (cur.depth == H && !cur.job.isEmpty()) {
      int task = cur.job.poll();
      // 왼쪽 부하 노드라면
      if (idx % 2 == 0) {
        worker[idx / 2].leftJob.offer(task);
      }
      // 오른쪽 부하 노드라면
      else {
        worker[idx / 2].rightJob.offer(task);
      }

      // 상사 노드이고 홀수 번째 날짜라면
    } else if (cur.depth < H && date % 2 == 1 && !cur.leftJob.isEmpty()) {
      int task = cur.leftJob.poll();

      if (idx == 1) {
        answer += task;
      } else {
        if (idx % 2 == 0) {
          worker[idx / 2].leftJob.offer(task);
        } else {
          worker[idx / 2].rightJob.offer(task);
        }
      }
      // 상사 노드이고 짝수 번째 날짜라면
    } else if (cur.depth < H && date % 2 == 0 && !cur.rightJob.isEmpty()) {
      int task = cur.rightJob.poll();

      if (idx == 1) {
        answer += task;
      } else {
        if (idx % 2 == 0) {
          worker[idx / 2].leftJob.offer(task);
        } else {
          worker[idx / 2].rightJob.offer(task);
        }
      }
    }
    pro(idx * 2, date, depth + 1);
    pro(idx * 2 + 1, date, depth + 1);
  }

  public static void start(int idx, int depth) {
    if (depth > H) {
      return;
    }

    worker[idx] = new Worker(depth);

    start(idx * 2, depth + 1);
    start(idx * 2 + 1, depth + 1);
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    H = Integer.valueOf(st.nextToken());
    K = Integer.valueOf(st.nextToken());
    R = Integer.valueOf(st.nextToken());

    worker = new Worker[((int) Math.pow(2, H)) * 2];

    start(1, 0);

    for (int i = (int) Math.pow(2, H); i < (int) Math.pow(2, H + 1); i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int k = 0; k < K; k++) {
        worker[i].job.offer(Integer.valueOf(st.nextToken()));
      }
    }

    answer = 0;
    for (int r = 1; r <= R; r++) {
      pro(1, r, 0);
    }

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }

}
