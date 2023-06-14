//package algorithms.baekjoon;
//
//import java.util.Stack;
//
//public class B2839 {
//
//  public void sugarDelivery(int grams) {
//    int totalSugar = 0;
//    int totalWithThrees = 0;
//    int addedVinyl = 1;
////
//    if (grams % 3 == 0) {
//      totalWithThrees = grams / 3;
//    }
//    int cnt = 1;
//// 5로 가는 경우
//    int firstGram = grams;
//    while (grams > 0) {
//      while (grams > 4) {
//        if (grams % 5 < 3) {
//          grams = grams - 5 * (grams / 5 - cnt);
//        }
//        addedVinyl = grams / 5;
//        totalSugar += addedVinyl;
//        grams %= 5;
//      }
//// 3으로 가는 경우
//      while (grams > 2) {
//        addedVinyl = grams / 3;
//        totalSugar += addedVinyl;
//        grams %= 3;
//      }
//      cnt++;
//      grams = firstGram;
//
//
//    }
//
//    if (totalWithThrees != 0) {
//      System.out.println(totalWithThrees);
//      return;
//    }
//
//    if (grams > 0) {
//      totalSugar = -1;
//
//      System.out.println(Math.min(totalWithThrees, totalSugar));
//
//    }
//  }
//
//  public void newAlgo() {
//    Stack<Integer> s = new Stack<>();
//
//    while(!s.isEmpty()) {
////    3을 나누는 곳
//      if () {
//        continue;
//      }
////    5를 나누는 곳
//      if () {
//        continue;
//      }
//    }
//  }
//
//  public void dfs(int start, int size) {
//    Stack<Integer> track = new Stack<>();
//    track.push(start);
//    boolean[] visit = new boolean[size];
//    for (int i = 0; i < size; i++) {
//      visit[i] =false;
//    }
//    visit[start] = true;
//    while (!track.isEmpty()) {
//
//      int i = track.pop();
//
//      if (i == 0) continue;
//      if (visit[i]) continue;
//      visit[i] = true;
//      if () {
//        track.push();
//      }
//      if (.equals(track.peek())) {
//        Math.min();
//      }
//    }
//  }
//
//  public static void main(String[] args) {
//    B2839 test = new B2839();
//    test.sugarDelivery(18);
//    test.sugarDelivery(4);
//    test.sugarDelivery(6);
//    test.sugarDelivery(9);
//    test.sugarDelivery(11);
//  }
//
//}
