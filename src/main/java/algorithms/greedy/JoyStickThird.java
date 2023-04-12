package algorithms.greedy;

import java.util.*;

public class JoyStickThird {
  int curPos;
  String name;
  StringBuilder newName = new StringBuilder();

  List<Character> alphabets = new ArrayList<>();

  public void setCurPos(int curPos) {
    this.curPos = curPos;
  }

  public void init(String name) {
    this.name = name;
    this.curPos = 0;

    for (char c = 'A'; c <= 'Z'; c++) {
      alphabets.add(c);
    }
  }

  public int moveUpsAndDowns(char letter) {
    if (alphabets.indexOf(letter) > 13)
      return 26 - alphabets.indexOf(letter);

    return alphabets.indexOf(letter) - 1;
  }

  public int process(String name) {
    init(name);

    int counter = 0;

    List<Integer> state = new ArrayList<>();

    int idx = 0;
    for (char single : name.toCharArray()) {
      if (single == 'A') {
        idx++;
        continue;
      }
      state.add(idx);
      idx++;
    }
    int repeat = 0;

    while (repeat < state.size()) {
      counter += moveCursor(state.get(repeat));
      counter += moveUpsAndDowns(name.charAt(curPos));

      if (isCompleted()) break;
      repeat++;
    }

    return counter;
  }

  public int identifyPos(char c) {
    int idx = 0;
    for (char part : name.toCharArray()) {
      if (part == c) return idx;
      idx++;
    }
    return -1;
  }

  public int actualPos(int pos) {
    int actualPos = 0;

    if (pos > name.length()) {
      actualPos = pos - name.length();
    } else actualPos = pos;

    return actualPos;
  }

  public int moveCursor(int targetPos) {
    if (targetPos == curPos) return 0;

    int extent = 0;

    if (moveRight(targetPos) > moveLeft(targetPos) ) {
      extent = moveLeft(targetPos);
    } else {
      extent = moveRight(targetPos);
    }

    setCurPos(actualPos(curPos + extent));

    return extent;
  }

  public int moveRight(int targetState) {
    return targetState - curPos;
  }

  public int moveLeft(int targetState) {
    return name.length() - targetState + curPos;
  }

  public boolean isCompleted() {
    return name.equals(newName.toString());
  }

  public boolean isAtTheEnd(int curPtr) {
    return curPtr == name.length() - 1;
  }

  public int solution(String name) {
    int answer = 0;

    process(name);

    return answer;
  }
}
