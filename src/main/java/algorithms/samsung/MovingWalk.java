package algorithms.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MovingWalk {

  static int[] machine;
  //  사람들이 서있는 상태
  static int[] people;
  static int state = -1;
  static int order = 1;
  static int n;
  static int k;
  static int current = 1;
  public static void spin() {
    int end = machine[machine.length - 1];

    for (int i = machine.length - 1; i > 0; i--) {
      machine[i] = machine[i - 1];
    }

    machine[0] = end;

//    System.out.println("beforeSpin: ");
//
//    for (int person : people) {
//      System.out.print(person + " ");
//    }

    int last = people[people.length - 1];

    for (int p = people.length - 1; p > 0; p--) {
      people[p] = people[p - 1];
      checkOffs();
    }

    people[0] = last;
//    System.out.println();
//    System.out.println("people: ");
//
//    for (int person : people) {
//      System.out.print(person + " ");
//    }
//    System.out.println();
//
//    System.out.println("machine: ");
//    for (int i : machine) {
//      System.out.print(i + " ");
//    }
//
//    System.out.println();
  }

  public static void climb() {
    if (machine[0] > 0 && people[0] == -1) {
      machine[0]--;
      people[0] = order++;
      state = 1;
    }
    checkOffs();

  }

  public static void move() {
//    무빙 워크가 비어 있을 때
    if (state == -1) {
      return;
    }

//    order == 1 인 사람 부터 앞으로 한 칸 이동한다.

    for (int p = people.length; p > 0; p--) {
      for (int i = current; i <= order; i++) {
//      1번인 사람을 찾으면 위치를 한 칸 전진한다.
        if (people[(p - 1) % (2 * n)] == i) {
          if (people[p % (2 * n)] == -1 && machine[p % (2 * n)] > 0) {
            people[p % (2 * n)] = people[(p - 1) % (2 * n)];
            machine[p % (2 * n)]--;
            people[(p - 1) % (2 * n)] = -1;
          }
        }
        checkOffs();
      }
    }



//    System.out.println("afterMove: ");
//    for (int person : people) {
//      System.out.print(person + " ");
//    }
//    System.out.println();
//
//    System.out.println("afterMoveMachine");
//    for (int i : machine) {
//      System.out.print(i + " ");
//    }
//    System.out.println();
  }

  public static void checkOffs() {
    if (people[n-1] != -1) {
      current = people[n-1]+1;
      people[n-1] = -1;
    }
  }

  public static boolean finish() {
    int cnt = 0;
    for (int stability : machine) {
      if (stability == 0) cnt++;
    }
    return cnt >= k;
  }

  public static int solution() {
    int cnt = 0;
    while (!finish()) {
      spin();
      move();
      climb();
      cnt++;
    }
    return cnt;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.valueOf(st.nextToken());

    k = Integer.valueOf(st.nextToken());

    machine = new int[2 * n];
    people = new int[2 * n];

    Arrays.fill(people, -1);
    st = new StringTokenizer(br.readLine(), " ");
//    안정성을 저장할까, 위치를 저장할까?

    for (int i = 0; i < 2 * n; i++) {
      machine[i] = Integer.valueOf(st.nextToken());
    }

    System.out.println(solution());

  }

}
