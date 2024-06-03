package algorithms.programmers.skilltest;

import java.util.*;

public class Types {

  public String solution(String[] survey, int[] choices) {
    String answer = "";

    int[][] types = new int[4][2];
    char[][] info = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    Map<Character, Integer> characters = new TreeMap<>();

    characters.put('R', 1);
    characters.put('T', 2);
    characters.put('C', 3);
    characters.put('F', 4);
    characters.put('J', 5);
    characters.put('M', 6);
    characters.put('A', 7);
    characters.put('N', 8);

    for (int i = 0; i < choices.length; i++) {
      int choice = choices[i];
      int pos = characters.get(survey[i].charAt(0));
      int idx = 0;
      if (pos % 2 == 0) {
        idx = pos / 2 - 1;
      } else {
        idx = pos / 2;
      }

      if (choice < 4) {
        types[idx][1 - (pos % 2)] += Math.abs(4 - choice);
      } else if (choice > 4) {
        types[idx][pos % 2] += Math.abs(choice - 4);
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int j = 0; j < types.length; j++) {
      int left = types[j][0];
      int right = types[j][1];
      char first = info[j][0];
      char second = info[j][1];

      if (left > right) {
        sb.append(first);
      } else if (left < right) {
        sb.append(second);
      } else {
        sb.append(first > second ? second : first);
      }
    }

    answer = sb.toString();
    return answer;
  }

}
