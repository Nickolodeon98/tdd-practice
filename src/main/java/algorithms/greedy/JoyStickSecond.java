package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

public class JoyStickSecond {
  public int findPos(char component) {
    List<Character> components = new ArrayList<>();
    for (char c = 'A'; c <= 'Z'; c++) {
      components.add(c);
    }
    return components.indexOf(component);
  }

  public int basicMoves(String name) {
    int countMoves = 0;
    for (int i = 0; i < name.length(); i++) {
      int pos = findPos(name.charAt(i));
      if (pos > 13) {
        countMoves += 26 - pos;
      } else {
        countMoves += pos;
      }
    }
    return countMoves;
  }

  public int[] minDistance(int currentNode, List<Integer> nodes, int total) {
    int backward = 0;
    int forward = 0;
    int min = 21;
    int minIdx = 0;

    for (int i = 0; i < nodes.size(); i++) {
      if (nodes.get(i) == -1) {
        continue;
      }
      if (currentNode > nodes.get(i)) {
        forward = currentNode - nodes.get(i);
        backward = total - currentNode + nodes.get(i);
      } else if (currentNode < nodes.get(i)) {
        forward = nodes.get(i) - currentNode;
        backward = total - nodes.get(i) + currentNode;
      } else {
        continue;
      }

      if (min > Math.min(forward, backward)) {
        min = Math.min(forward, backward);
        minIdx = i;
      }
    }

    int[] distInfo = new int[2];
    distInfo[0] = minIdx;
    distInfo[1] = min;
    if (min == 21) {
      distInfo[1] = 0;
    }
    return distInfo;
  }

  public int moveLeftAndRight(String name) {
    List<Integer> points = new ArrayList<>();
    int countMoves = 0;
    for (int i = 0; i < name.length(); i++) {
      if (name.charAt(i) != 'A') {
        points.add(i);
      }
    }
    int current = -1;
    int count = 0;
    int[] info = new int[2];
    while (count < points.size()) {
      if (current == -1) {
        info = minDistance(0, points, name.length());
        if (points.get(0) == 0) {
          points.set(0, -1);
        }
      } else {
        info = minDistance(points.get(current), points, name.length());
        points.set(current, -1);
      }

      current = info[0];
      countMoves += info[1];
      count++;
    }
    return countMoves;
  }

  public int solution(String name) {
    int answer = 0;

    answer = basicMoves(name) + moveLeftAndRight(name);

    return answer;
  }

}
