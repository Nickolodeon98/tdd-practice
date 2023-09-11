package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class B23294 {

  static Deque<Integer> past;
  static Stack<Integer> rollback;
  static int volume = 0;
  static int current = -1;
  static int[] sizes;
  static int max;

  public static void goBackward() {
    if (past.isEmpty()) {
      return;
    }

    rollback.push(current);
    current = past.removeLast();
  }

  public static void goFrontward() {
    if (rollback.isEmpty()) {
      return;
    }

    past.addLast(current);

    current = rollback.pop();
  }

  public static void access(int target) {
    if (current != -1) {
      past.addLast(current);
    }

    if (!rollback.isEmpty()) {
      int total = 0;
      for (int r : rollback) {
        total += sizes[r];
      }
      volume -= total;
      rollback.clear();
    }

    current = target;
    volume += sizes[target];

    if (volume > max) {
      while (volume > max && !past.isEmpty()) {
        volume -= sizes[past.getFirst()];
        past.removeFirst();
      }
    }

  }

  public static void compress() {
    int cur = -1;
    List<Integer> p = new ArrayList<>(past);
    for (int i = 0; i < p.size(); i++) {
      if (cur != -1 && cur == p.get(i)) {
        while (i < p.size() && p.get(i) >= 0 && cur == p.get(i)) {
          volume -= sizes[p.get(i)];
          p.set(i, -1);
          i++;
        }
//        p.set(i-1, cur);
      }
      if (i < p.size()) {
        cur = p.get(i);
      }
    }
    int n = 0;
    while (p.contains(-1)) {
      if (p.get(n) == -1) {
        p.remove(n);
        continue;
      }
      n++;
    }
    past = new LinkedList<>(p);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.valueOf(st.nextToken());
    int Q = Integer.valueOf(st.nextToken());
    max = Integer.valueOf(st.nextToken());

    sizes = new int[N + 1];

    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 1; i <= N; i++) {
      sizes[i] = Integer.valueOf(st.nextToken());
    }

    past = new LinkedList<>();
    rollback = new Stack<>();

    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      String command1 = st.nextToken();
      String command2 = "";
      if (st.hasMoreTokens()) {
        command2 = st.nextToken();
      }

      if (command1.equals("B")) {
        goBackward();
      }

      if (command1.equals("F")) {
        goFrontward();
      }

      if (command1.equals("A")) {
        access(Integer.valueOf(command2));
      }

      if (command1.equals("C")) {
        compress();
      }
    }

    System.out.println(current);

    StringBuilder sb1 = new StringBuilder();
    if (past.isEmpty()) {
      System.out.println(-1);
    } else {
      List<Integer> p = new ArrayList<>(past);
      for (int i = p.size() - 1; i >= 0; i--) {
        if (i == 0) {
          sb1.append(p.get(i));
        } else {
          sb1.append(p.get(i) + " ");
        }
      }
      System.out.println(sb1);
    }

    StringBuilder sb2 = new StringBuilder();
    if (rollback.isEmpty()) {
      System.out.print(-1);
    } else {
      List<Integer> r = new ArrayList<>(rollback);
      for (int i = r.size()-1; i >= 0; i--) {
        if (i == 0) {
          sb2.append(r.get(i));
        } else {
          sb2.append(r.get(i) + " ");
        }
      }
      System.out.print(sb2);
    }

  }

}