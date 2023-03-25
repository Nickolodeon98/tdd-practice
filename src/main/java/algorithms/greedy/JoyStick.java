package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

public class JoyStick {
    public List<Integer> computeDestination(int sourceIdx, List<Integer> targetIndices, int total) {
//         target 으로 곧장 가는 것이 나은지 돌아가는 것이 나은지 판단하는 메서드
      int minIdx = 999999;
      int distance = 999999;

      List<Integer> distanceInfo = new ArrayList<>();

      for (int targetIdx : targetIndices) {
        if (Math.abs(targetIdx - sourceIdx) <= Math.abs(total - targetIdx + sourceIdx)) {
          if (distance > Math.abs(targetIdx - sourceIdx)) {
            minIdx = targetIdx;
            distance = Math.abs(targetIdx - sourceIdx);
          }
        } else {
          if (distance > Math.abs(total - targetIdx + sourceIdx)) {
            minIdx = targetIdx;
            distance = Math.abs(total - targetIdx + sourceIdx);
          }
        }
      }
      distanceInfo.add(minIdx);
      distanceInfo.add(distance);

      return distanceInfo;
    }

    public int countLeftsAndRights(String name) {

      int length = name.length();
      char[] components = name.toCharArray();
      List<Integer> traces = new ArrayList<>();

      for (int i = 1; i < components.length; i++) {
        if (components[i] != 'A') {
          traces.add(i);
        }
      }

      int count = 0;
      int curPtr = 0;

      if (name.contains("A")) {
        while (!traces.isEmpty()) {
          List<Integer> destinationInfo
              = computeDestination(curPtr, traces, length);

          curPtr = destinationInfo.get(0);
          count += destinationInfo.get(1);
          traces.remove(traces.indexOf(curPtr));
        }
      } else {
        count = length - 1;
      }
      return count;
    }

    public List<Character> readName() {
      List<Character> letters = new ArrayList<>();
      for(char c = 'A'; c <= 'Z'; c++) {
        letters.add(c);
      }
      return letters;
    }

    public int countUpsAndDowns(String name) {
      List<Character> indices = readName();
      char[] components = name.toCharArray();

      int pos = 0;

      for (char letter : components) {
        if (indices.indexOf(letter) <= 13) {
          pos += indices.indexOf(letter);
        } else {
          pos += 26 - indices.indexOf(letter);
        }
      }
      return pos;
    }

    public int solution(String name) {
      int answer = 0;

      answer = countLeftsAndRights(name) + countUpsAndDowns(name);

      return answer;
    }

}
