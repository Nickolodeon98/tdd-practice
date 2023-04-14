package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Dfs {
  String name = "";
  public void moveCursor(String name) {
    int front = 0;
    int back = name.length()-1;
    int curPos = 0;

    List<Integer> notAs = new ArrayList<>();

    for (int i = 0; i < name.length(); i++) {
      if (name.charAt(i) == 'A') continue;
      notAs.add(i);
    }

    search(curPos, front, back);

  }

  public int minDist(int curPos, int tarPos) {
    int indirect = curPos > tarPos ? tarPos - curPos : curPos - tarPos;
    return Math.min(Math.abs(curPos - tarPos), name.length() + indirect);
  }
  HashSet<Integer> visit = new HashSet<>();
  public int search(int x, int front, int back, int dist) {
    visit.add(x);
    if (front > back) return dist;
    if (!visit.contains(front)) {
      dist += minDist(x, front);
      dist = search(front, ++front, back, dist);
    }
    if (!visit.contains(back)) {
      dist = minDist(x, back);
      dist = Math.min(dist, search(back, --back, back, dist));
    }
    return dist;
  }

}
