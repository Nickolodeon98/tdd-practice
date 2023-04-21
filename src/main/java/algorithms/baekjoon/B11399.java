package algorithms.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B11399 {

  public int lineUp(int[] queue) {
    Arrays.sort(queue);
    int timer = 0;
    int total = 0;
    for (int i = 0; i < queue.length; i++) {
      timer += queue[i];
      total += timer;
    }

    return total;
  }

  public static void main(String[] args) {
    B11399 test = new B11399();

    Scanner sc = new Scanner(System.in);

    int num = Integer.parseInt(sc.nextLine());
    int[] ps = new int[num];
    String[] times = sc.nextLine().split(" ");

    for (int j = 0; j < ps.length; j++) {
      ps[j] = Integer.parseInt(times[j]);
    }

    System.out.println(test.lineUp(ps));
  }
}
