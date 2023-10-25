package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RE_RE_RE_B1062 {
    static int max = Integer.MIN_VALUE;
    static int K;
    static Map<String, Integer> every;
    static String[] words;

    public static void combination(char cur, StringBuilder sb, int cnt) {
        if (sb.length() == cnt) {
            check(sb.toString());
            return;
        }

        for (char i = cur; i <= 'z'; i++) {
            if (i == 'a' || i == 'n' || i == 't' || i == 'i' || i == 'c') continue;
            if (sb.toString().contains(String.valueOf(i))) continue;
            combination(i, sb.append(i), cnt);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void process(String[] words) {
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(4, words[i].length()-4);
        }
    }

    public static boolean readable(String origin, String target) {
        for (int i = 0; i < origin.length(); i++) {
            char cur = origin.charAt(i);
            if (cur == 'a' || cur == 'n' || cur == 't' || cur == 'i' || cur == 'c') continue;
            if (!target.contains(String.valueOf(origin.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static void check(String candidate) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (readable(words[i], candidate)) {
                count++;
            }
        }
        max = Math.max(max, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }
        every = new HashMap<>();

        process(words);
        combination('a', new StringBuilder(), K-5);

        System.out.println(max);
    }

}
