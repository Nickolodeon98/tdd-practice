package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B10819 {
  static boolean[] visited;
  static List<String> every;
  public static void solution(int[] arr) {
    int cur = 0;
    int ans = Integer.MIN_VALUE;
    visited = new boolean[arr.length];
    every = new ArrayList<>();
    permutation(arr, 0, new StringBuilder());

    for (String e : every) {
      char[] c = e.toCharArray();
      for (int i = 1; i < e.length(); i++) {
        int tmp = Math.abs(arr[c[i-1] - '0'] - arr[c[i] - '0']);
        cur += tmp;
      }
      ans = Math.max(ans, cur);
      cur = 0;
    }

    System.out.println(ans);
  }

  public static void permutation(int[] arr, int cnt, StringBuilder sb) {
    if (cnt == arr.length) {
      every.add(sb.toString());
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      sb.append(i);
      permutation(arr,cnt+1, sb);
      sb.deleteCharAt(sb.length()-1);
      visited[i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.valueOf(br.readLine());

    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.valueOf(st.nextToken());
    }

    solution(arr);
  }
}
