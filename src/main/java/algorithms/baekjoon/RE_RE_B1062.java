package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RE_RE_B1062 {

    static Map<Character, Integer> all;
    static int K;
    static Map<String, Integer> every;
    static String[] words;
    public static void permutation(String s, int cnt) {
        if (s.length() == cnt) {
            every.put(s, 0);
            return;
        }

        for (char i = 'a'; i <= 'z'; i++) {
            if (i == 'a' || i == 'n' || i == 't' || i == 'i' || i == 'c') continue;
            if (all.get(i) != 0) continue;
            all.put(i, 1);
            permutation(s + i, cnt);
           all.put(i, 0);
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
            if (!target.contains(String.valueOf(origin.charAt(i)))) {
                if (cur == 'a' || cur == 'n' || cur == 't' || cur == 'i' || cur == 'c') continue;
                return false;
            }
        }
        return true;
    }

    public static void check() {
        for (int i = 0; i < words.length; i++) {
            for (Map.Entry<String, Integer> elem : every.entrySet()){
                if (readable(words[i], elem.getKey())) {
                    elem.setValue(elem.getValue() + 1);
                }
            }
        }
        List<String> candi = new ArrayList<>(every.keySet());
        Collections.sort(candi, (a,b) -> every.get(b) - every.get(a));
        System.out.println(every.get(candi.get(0)));
    }

    public static void init() {
        all = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            if (i == 'a' || i == 'n' || i == 't' || i == 'i' || i == 'c') {
                all.put(i, 1);
                continue;
            }
            all.put(i, 0);
        }
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

        init();
        every = new HashMap<>();
        permutation("", K - 5);

        process(words);
        check();
    }

}
