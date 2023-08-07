package algorithms.softeer;

import java.util.*;
import java.io.*;

public class FirstOf3 {

  static List<Character> alphabets;

  public static void solution(String message, String key) {
    alphabets = new ArrayList<>();
    int cnt = 0;
    for (char a = 'A'; a <= 'Z'; a++) {
      if (a == 'J') {
        continue;
      }
      alphabets.add((char) a);
    }

    char[][] map = new char[5][5];

    char[] cipher = key.toCharArray();

    List<Character> letters = new ArrayList<>();

    for (char c : cipher) {
      if (!letters.isEmpty() && letters.contains(c)) {
        continue;
      }
      letters.add(c);
    }

    for (int i = 0; i < map.length; i++) {
      for (int j = i * 5; j < (i * 5) + map[i].length && j < letters.size(); j++) {
        map[i][j % 5] = letters.get(j);
        alphabets.remove(Character.valueOf(letters.get(j)));
      }
    }

    int count = 0;
    for (int k = 0; k < map.length; k++) {
      for (int l = 0; l < map[k].length; l++) {
        if (!('A' <= map[k][l] && 'Z' >= map[k][l])) {
          map[k][l] = alphabets.get(count++);
        }
      }
    }

    StringBuilder sb = new StringBuilder(message);

    // List<String> ms = new ArrayList<>();
    for (int s = 0; s < sb.length() - 1; s += 2) {
      if (sb.charAt(s) == sb.charAt(s + 1)) {
        if (sb.charAt(s) == 'X') {
          sb.insert(s + 1, 'Q');
        } else {
          sb.insert(s + 1, 'X');
        }
      }
    }

    if (sb.length() % 2 == 1) {
      sb.append("X");
    }

    String result = "";
    int idx = 0;
    while (idx < sb.length() - 1) {
      int curRow0 = 0;
      int curCol0 = 0;

      int curRow1 = 0;
      int curCol1 = 0;
      for (int row = 0; row < map.length; row++) {
        for (int col = 0; col < map[row].length; col++) {
          if (sb.charAt(idx) == map[row][col]) {
            curRow0 = row;
            curCol0 = col;
          }
          if (sb.charAt(idx + 1) == map[row][col]) {
            curRow1 = row;
            curCol1 = col;
          }
        }
      }

      if (curRow0 == curRow1) {
        int nCol0 = curCol0 + 1;
        int nCol1 = curCol1 + 1;

        if (nCol0 > 4) {
          nCol0 = 0;
        }
        if (nCol1 > 4) {
          nCol1 = 0;
        }

        sb.setCharAt(idx, map[curRow0][nCol0]);
        sb.setCharAt(idx + 1, map[curRow1][nCol1]);
      } else if (curCol0 == curCol1) {
        int nRow0 = curRow0 + 1;
        int nRow1 = curRow1 + 1;

        if (nRow0 > 4) {
          nRow0 = 0;
        }
        if (nRow1 > 4) {
          nRow1 = 0;
        }

        sb.setCharAt(idx, map[nRow0][curCol0]);
        sb.setCharAt(idx + 1, map[nRow1][curCol1]);
      } else {
        int newCol0 = curCol1;
        int newCol1 = curCol0;
        sb.setCharAt(idx, map[curRow0][newCol0]);
        sb.setCharAt(idx + 1, map[curRow1][newCol1]);
      }
      idx += 2;
    }

    System.out.print(sb);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String message = sc.nextLine();
    String key = sc.nextLine();

    solution(message, key);
  }

}
