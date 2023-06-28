package algorithms.baekjoon;

import java.util.Scanner;

public class B12919 {

  public void solution(String T, String S) {
    int answer = DFS(T, S);

    System.out.println(answer);
  }

  public int DFS(String current, String goal) {
    if (current.length() == goal.length()) {
        if (current.equals(goal)) {
          return 1;
      }
    }

    if (current.length() <= goal.length()) return 0;

    int returnedA = 0;
    int returnedB = 0;

    if (current.charAt(current.length()-1) == 'A') {
      returnedA=DFS(current.substring(0, current.length()-1), goal);
    }

    if (current.charAt(0) =='B') {
      StringBuilder reversed = new StringBuilder(current.substring(1));
      reversed.reverse();
      returnedB = DFS(reversed.toString(), goal);
    }


    return Math.max(returnedA, returnedB);
  }

  public static void main(String[] args) {
    B12919 test = new B12919();
    Scanner sc = new Scanner(System.in);
    String S = sc.nextLine();
    String T = sc.nextLine();

    test.solution(T, S);
  }

}
