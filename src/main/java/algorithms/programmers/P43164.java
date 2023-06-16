package algorithms.programmers;

import java.util.*;

public class P43164 {

  boolean[] visited;
  List<String> airports;

  public void DFS(String start, String allRoute, String[][] tickets, int cnt) {
    if (cnt == tickets.length) {
      airports.add(allRoute);
      return;
    }

    for (int i = 0; i < tickets.length; i++) {
      if (visited[i] == true) {
        continue;
      }
      if (start.equals(tickets[i][0])) {
        visited[i] = true;
        DFS(tickets[i][1], allRoute + " " + tickets[i][1], tickets, cnt + 1);
        visited[i] = false;
      }
    }
  }

  public String[] solution(String[][] tickets) {
    String[] answer = {};

    visited = new boolean[tickets.length];
    airports = new ArrayList<>();

    DFS("ICN", "ICN", tickets, 0);

    Collections.sort(airports);

    answer = airports.get(0).split(" ");
    return answer;
  }

}
