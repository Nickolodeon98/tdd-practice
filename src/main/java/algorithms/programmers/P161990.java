package algorithms.programmers;

import java.util.*;

public class P161990 {

  // 8분 소요
  public int[] solution(String[] wallpaper) {
    int[] answer = new int[4];

    List<Integer> y = new ArrayList<>();
    List<Integer> x = new ArrayList<>();

    for (int i = 0; i < wallpaper.length; i++) {
      for (int j = 0; j < wallpaper[i].length(); j++) {
        if (wallpaper[i].charAt(j) == '#') {
          y.add(i);
          x.add(j);
        }
      }
    }

    Collections.sort(y);
    Collections.sort(x);

    answer[0] = y.get(0);
    answer[1] = x.get(0);
    answer[2] = y.get(y.size() - 1) + 1;
    answer[3] = x.get(x.size() - 1) + 1;
    return answer;
  }
}
