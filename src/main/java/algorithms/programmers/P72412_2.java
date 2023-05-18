package algorithms.programmers;

import java.util.*;

public class P72412_2 {

  public Map<String, Integer> everyCase() {
    Map<String, Integer> everything = new HashMap<>();

    String[] lan = {"java", "python", "cpp", "-"};
    String[] field = {"backend", "frontend", "-"};
    String[] expert = {"junior", "senior", "-"};
    String[] food = {"pizza", "chicken", "-"};

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < lan.length; i++) {
      for (int j = 0; j < field.length; j++) {
        for (int l = 0; l < expert.length; l++) {
          for (int k = 0; k < food.length; k++) {
            sb.append(lan[i]);
            sb.append(field[j]);
            sb.append(expert[l]);
            sb.append(food[k]);
            everything.put(sb.toString(), 0);
            sb.setLength(0);
          }
        }
      }
    }
    System.out.println(everything);
    return everything;
  }


  public int[] solution(String[] info, String[] query) {
    int[] answer = {};
    return answer;
  }
}
