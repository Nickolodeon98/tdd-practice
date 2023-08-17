package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1062 {
  static int K;
  static boolean[] visited;
  static String[] words;
  static Set<Character> letters;
  static int cnt;
  static int max = 0;
  static int count = 0;
  static boolean[] flag;
  public static void solution() {
    visited = new boolean[words.length];
    flag = new boolean[words.length];

    cnt = 0;
    combination(words.length, 0, 0);

    if (max == 1)
      System.out.println(count);
    else
      System.out.println(max);
  }

  public static int generate(String word) {
    for (int i = 0; i < word.length(); i++) {
      letters.add(word.charAt(i));
    }
    return letters.size();
  }
  public static void combination(int total, int sum, int idx) {
    if (sum == K) {
      max = Math.max(max, cnt);
      count++;
      flag[idx] = true;
      cnt = 0;
      return;
    }

    if (sum > K) {
      return;
    }

    for (int i = 0; i < total; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      cnt++;
      combination(total, generate(words[i]), i);
      cnt--;
      if (!flag[i])
        visited[i] = false;
      letters = new HashSet<>();
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.valueOf(st.nextToken());
    K = Integer.valueOf(st.nextToken());

    words = new String[N];

    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      words[i] = word;
    }
    letters = new HashSet<>();

    solution();
  }
}

