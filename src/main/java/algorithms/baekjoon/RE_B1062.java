package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RE_B1062 {
    static Map<Character, Integer> dict;
    static int K;
    static List<Character> every;

    static Map<Character, Boolean> all;

    public static void solution(String[] given) {

        for (int i = 0; i < given.length; i++) {
            String word = given[i].substring(4, given[i].length() - 4);

            for (int j = 0; j < word.length(); j++) {
                char cur = word.charAt(j);
                if (all.get(cur)) continue;
                all.put(cur, true);
                dict.put(cur, dict.getOrDefault(cur, 0) + 1);
            }
            init();
        }

        every = new ArrayList<>(dict.keySet());

        Collections.sort(every, (a, b) -> dict.get(b) - dict.get(a));

        // abcdefnzyxw
        // abc
        // bce

        every = every.subList(0, K);

    }

    public static boolean readable(String target) {
        for (int i = 0; i < target.length(); i++) {
            if (!every.contains(target.charAt(i))) return false;
        }
        return true;
    }

    public static void init() {
        all = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            if (i == 'a' || i == 'n' || i == 't' || i == 'i' || i == 'c') {
                all.put(i, true);
                continue;
            }
            all.put(i, false);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        dict = new HashMap<>();
        // anta tica -> a n t i c -> N개

        if (K < 5) {
            System.out.println(0);
            return;
        }
        dict.put('a', N);
        dict.put('n', N);
        dict.put('t', N);
        dict.put('i', N);
        dict.put('c', N);

        String[] words = new String[N];
        init();

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        solution(words);

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (readable(words[i])) count++;
        }

        System.out.println(count);
    }

}
