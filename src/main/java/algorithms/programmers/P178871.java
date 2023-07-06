package algorithms.programmers;

import java.util.*;

public class P178871 {

  public String[] solution(String[] players, String[] callings) {

    Map<String, Integer> info = new HashMap<>();
    Map<Integer, String> other = new HashMap<>();

    for (int i = 0; i < players.length; i++) {
      info.put(players[i], i);
      other.put(i, players[i]);
    }

    for (String c : callings) {
      info.put(other.get(info.get(c) - 1), info.get(c));
      String temp = other.get(info.get(c) - 1);
      other.put(info.get(c) - 1, c);
      other.put(info.get(c), temp);
      info.put(c, info.get(c) - 1);
    }

    List<String> infos = new ArrayList<>(info.keySet());

    Collections.sort(infos, (x1, x2) -> {
      return info.get(x1) - info.get(x2);
    });

    String[] answer = new String[players.length];

    for (int k = 0; k < answer.length; k++) {
      answer[k] = infos.get(k);
    }
    return answer;
  }
}
