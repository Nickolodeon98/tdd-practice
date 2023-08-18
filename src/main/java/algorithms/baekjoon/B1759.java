package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B1759 {

  static char[] letters;
  static int L;
  static int C;
  static boolean[] visited;

  public static void solution() {
    visited = new boolean[letters.length];

    Arrays.sort(letters);

    List<Character> sb = new ArrayList<>();

    combination(sb);
  }

  public static int cntConsonant(List<Character> sb) {
    int cnt = 0;
    for (char c : sb) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u')
        continue;
      cnt++;
    }
    return cnt;
  }

  public static void combination(List<Character> sb) {
    if (sb.size() == L) {
      if (!sb.contains('a') && !sb.contains('e') && !sb.contains('i') && !sb.contains('o') && !sb.contains('u'))
        return;
      if (cntConsonant(sb) < 2) return;
      StringBuilder s = new StringBuilder();
      for (char c : sb) {
        s.append(c);
      }
      System.out.println(s);
      return;
    }

    for (int i = 0; i < letters.length; i++) {
      if (visited[i]) {
        continue;
      }
      if (!sb.isEmpty() && letters[i] < sb.get(sb.size()-1)) continue;
      visited[i] = true;
      sb.add(letters[i]);
      combination(sb);
      sb.remove(sb.size() - 1);
      visited[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    L = Integer.valueOf(st.nextToken());
    C = Integer.valueOf(st.nextToken());
    letters = new char[C];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < C; i++) {
      char letter = st.nextToken().toCharArray()[0];
      letters[i] = letter;
    }

    solution();
  }
}
