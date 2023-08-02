package algorithms.programmers;

import java.util.*;

public class P17677 {


  public int solution(String str1, String str2) {
    int answer = 0;

    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    List<String> elems1 = toElems(str1);
    List<String> elems2 = toElems(str2);

    List<String> tmp1 = new ArrayList<>(elems1);
    List<String> tmp2 = new ArrayList<>(elems1);

    Map<String, Integer> map1 = putEverything(elems1);
    Map<String, Integer> map2 = putEverything(elems2);

    int minI = 0;
    for (Map.Entry<String, Integer> me : map1.entrySet()) {
      int i = map2.getOrDefault(me.getKey(), 0);
      minI += Math.min(i, me.getValue());
    }

    tmp1.addAll(elems2);

    int sum = tmp1.size() - minI;
    int intersected = minI;

    if (sum == intersected) {
      return 65536;
    }

    answer = (int) Math.floor(((double) intersected / (double) sum) * 65536);

    return answer;
  }

  private List<String> toElems(String str) {
    List<String> elems = new ArrayList<>();
    for (int i = 0; i < str.length() - 1; i++) {
      String part = str.substring(i, i + 2);
      if (!part.matches("[a-z][a-z]")) {
        continue;
      }
      elems.add(part);
    }

    return elems;
  }

  private Map<String, Integer> putEverything(List<String> elems) {
    Map<String, Integer> m = new HashMap<>();

    for (int i = 0; i < elems.size(); i++) {
      m.put(elems.get(i), m.getOrDefault(elems.get(i), 0) + 1);
    }
    return m;
  }
}

