package algorithms.programmers;
import java.util.*;

public class P118666 {
    public String allMarked(String[] survey, int[] choices) {

      int[][] indicator = new int[4][2];
      Map<Character, int[]> positions = new HashMap<>();

      positions.put('R', new int[]{0,0});
      positions.put('T', new int[]{0,1});
      positions.put('C', new int[]{1,0});
      positions.put('F', new int[]{1,1});
      positions.put('J', new int[]{2,0});
      positions.put('M', new int[]{2,1});
      positions.put('A', new int[]{3,0});
      positions.put('N', new int[]{3,1});


      for (int i = 0; i < survey.length; i++) {
        if (choices[i] <= 3) {
          indicator[positions.get(survey[i].charAt(0))[0]][positions.get(survey[i].charAt(0))[1]] += (4 - choices[i]);
          continue;
        }
        indicator[positions.get(survey[i].charAt(1))[0]][positions.get(survey[i].charAt(1))[1]] += (choices[i] - 4);
      }

      String[] lefts = {"R", "C", "J", "A"};
      String[] rights = {"T", "F", "M", "N"};

      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < indicator.length; j++) {
        if (indicator[j][0] < indicator[j][1]) {
          sb.append(rights[j]);
          continue;
        }
        sb.append(lefts[j]);
      }

      return sb.toString();
    }

    public String solution(String[] survey, int[] choices) {
      String answer = "";
      answer = allMarked(survey, choices);
      return answer;
    }
}
