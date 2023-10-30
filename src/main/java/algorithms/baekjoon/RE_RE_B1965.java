package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RE_RE_B1965 {
    static int[] boxes;
    static int[] dp;
    public static void putInside() {
        for (int i = 0; i < boxes.length-1; i++) {
            for (int j = i+1; j < boxes.length; j++) {
                if (boxes[j] > boxes[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        boxes = new int[n];
        dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.valueOf(st.nextToken());
        }

        putInside();
    }
}
