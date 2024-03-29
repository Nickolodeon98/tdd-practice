package algorithms.programmers;

import java.util.*;

public class P42889 {
  public List<Integer> stageCnt(int N, int[] stages) {
    int ptr = 1;
    int cnt = 0;
    int cntStopped = 0;

    Arrays.sort(stages);

    List<Double> percents = new ArrayList<>();
    int i = stages.length - 1;
    while (i >= 0 && ptr <= N) {
      if (stages[i] < ptr) {
        ptr++;
        i = stages.length - 1;
        if (cntStopped == 0 || cnt == 0) {
          percents.add(0.0);
        } else {
          percents.add((double) cntStopped / cnt);
        }
        cntStopped = 0;
        cnt = 0;
        continue;
      }
      if (stages[i] == ptr) {
        cntStopped++;
      }
      cnt++;
      if (i == 0 && ptr <= N) {
        i = stages.length - 1;
        if (cntStopped == 0 || cnt == 0) {
          percents.add(0.0);
        } else {
          percents.add((double) cntStopped / cnt);
        }
        cntStopped = 0;
        cnt = 0;
        ptr++;
        continue;
      }
      i--;
    }

    Map<Integer, Double> forSort = new HashMap<>();
    int count = 1;
    for (double d : percents) {
      forSort.put(count, d);
      count++;
    }

    List<Integer> orders = new ArrayList<>(forSort.keySet());
    Collections.sort(orders, (o1, o2) -> Double.compare(forSort.get(o2), forSort.get(o1)));

    return orders;
  }

  public List<Integer> solution(int N, int[] stages) {
    return stageCnt(N, stages);
  }

}
