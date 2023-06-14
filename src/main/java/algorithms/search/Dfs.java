package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Dfs {
  String name = "JAEROEN";
  HashSet<Integer> visit = new HashSet<>();

  public void moveCursor() {
    int front = 0;
    int back = name.length()-1;
    int curPos = 0;

    List<Integer> notAs = new ArrayList<>();

    for (int i = 0; i < name.length(); i++) {
      if (name.charAt(i) == 'A') continue;
      notAs.add(i);
    }
    int answer = search(curPos, front, back, 0);

    System.out.println(answer);
  }

  public int minDist(int curPos, int tarPos) {
    int indirect = curPos > tarPos ? tarPos - curPos : curPos - tarPos;
    return Math.min(Math.abs(curPos - tarPos), name.length() + indirect);
  }
  public int search(int x, int front, int back, int dist) {
    visit.add(x);
    int frontDist = 0;
    int backDist = 0;
    if (front > back) return dist;
    if (!visit.contains(front)) {
      frontDist = dist + minDist(x, front);
      frontDist = search(front, ++front, back, frontDist);
    }
    if (!visit.contains(back)) {
      backDist = dist + minDist(x, back);
      backDist = search(back, --back, back, backDist);
    }
    return Math.min(frontDist, backDist);
  }

  public static void main(String[] args) {
    Dfs dfs = new Dfs();
    dfs.moveCursor();
  }
}
