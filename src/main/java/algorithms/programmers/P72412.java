package algorithms.programmers;

import java.util.*;

public class P72412 {

  public int[] search(String[] info, String[] query) {
    String lan = "";
    String field = "";
    String expert = "";
    String food = "";
    String mark = "";
    int population = 0;
    int count = 0;
    int[] counts = new int[query.length];

    for (String q : query) {
      String[] queryInfo = q.split(" and ");
      lan = queryInfo[0];
      field = queryInfo[1];
      expert = queryInfo[2];
      food = queryInfo[3].split(" ")[0];
      mark = queryInfo[3].split(" ")[1];

      for (String i : info) {
        String[] conditions = i.split(" ");
        if (Integer.parseInt(mark) > Integer.parseInt(conditions[4])) {
          continue;
        }
        if (!lan.equals(conditions[0]) && !lan.equals("-")) {
          continue;
        }
        if (!field.equals(conditions[1]) && !field.equals("-")) {
          continue;
        }
        if (!expert.equals(conditions[2]) && !expert.equals("-")) {
          continue;
        }
        if (!food.equals(conditions[3]) && !food.equals("-")) {
          continue;
        }
        population++;
      }
      counts[count] = population;
      population = 0;
      count++;
    }

    return counts;
  }

  public int[] solution(String[] info, String[] query) {
    int[] answer = {};

    answer = search(info, query);
    return answer;
  }
}
