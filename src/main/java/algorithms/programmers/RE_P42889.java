package algorithms.programmers;

import java.util.*;

public class RE_P42889 {

  public List<Integer> solution(int N, int[] stages) {
    Map<Integer, Double> m = new HashMap<>();

    int cnt = 0;
    int passed = 0;
    for (int i = 1; i <= N; i++) {
      for (int s : stages) {
        if (s >= i) {
          cnt++;
        }
        if (s > i) {
          passed++;
        }
      }
      double d = 0.0;
      if (cnt == 0) {
        d = 0.0;
      } else {
        d = (double) (cnt - passed) / (double) cnt;
      }
      m.put(i, d);
      cnt = 0;
      passed = 0;
    }

    List<Integer> keys = new ArrayList<>(m.keySet());
    Collections.sort(keys, (a, b) -> {
      return m.get(b) == m.get(a) ? b - a : m.get(b).compareTo(m.get(a));
    });

    return keys;
  }

}
