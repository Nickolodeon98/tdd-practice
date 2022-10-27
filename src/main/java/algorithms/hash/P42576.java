package algorithms.hash;

import java.util.HashMap;
import java.util.Map;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> completeOrNot = new HashMap<>();
        String answer = "";
        for (String s : participant) {
            if (completeOrNot.get(s) != null)
                completeOrNot.put(s, completeOrNot.get(s) + 1);
            else completeOrNot.put(s, 1);
        }

        for (String s : completion) {
            completeOrNot.put(s, completeOrNot.get(s) - 1);
        }

        for (Map.Entry<String, Integer> eachPlayerInfo : completeOrNot.entrySet()) {
            if (eachPlayerInfo.getValue() != 0) answer = eachPlayerInfo.getKey();
        }

        return answer;
    }
}
