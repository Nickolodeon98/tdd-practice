package algorithms.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RE_MovingWalk {
    static int[] chain;
//    static int[] indices;
//    static int[] changedI;
    static int[] changedC;
    static int[] changedP;
    static int[] people;
    static int length;
    static int n;
    static int k;

    public static void pro() {

        int count = 0;
        while (true) {
            count++;
            spin();
            check();
            move();
            check();
            init();
            check();
            if (isFinished()) break;
        }
        System.out.println(count);
    }

    public static boolean isFinished() {
        int cnt = 0;
        for (int i = 0; i < chain.length; i++) {
            if (chain[i] == 0) {
                cnt++;
            }
        }

        return cnt >= k;
    }

    public static void check() {
        if (people[n-1] == 1) {
            people[n-1] = 0;
        }
    }

    public static void spin() {
        // 무빙워크가 회전합니다
        for (int i = 0; i < chain.length; i++) {
            // [1, 2, 3, 4, 5, 6] -> [6, 1, 2, 3, 4, 5]
//            changedI[(i+1)%length] = indices[i];
            changedC[(i+1)%length] = chain[i];
            changedP[(i+1)%length] = people[i];
        }
//        copy(changedI, indices);
        copy(changedC, chain);
        copy(changedP, people);
    }

    public static void move() {
        // 사람들 먼저 올라탄 순서부터 봐준다
        for (int i = people.length-2; i >= 0; i--) {
            if (people[i] == 1) {
                if (chain[i+1] == 0 || people[i+1] == 1) continue;
                people[i+1] = 1;
                people[i] = 0;
                chain[i+1]--;
            }
        }
    }

    public static void init() {
        if (people[0] == 0 && chain[0] != 0) {
            people[0] = 1;
            chain[0]--;
        }
    }

    public static void copy(int[] from, int[] to) {
        for (int i = 0; i < from.length; i++) {
            to[i] = from[i];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        length = 2*n;
        k = Integer.valueOf(st.nextToken());

        chain = new int[length]; // 안정성
//        indices = new int[length]; // 무빙워크 n * 2개에 대한 id e.g. n == 3 -> 1, 2 ,3, 4, 5, 6 -> 6, 1, 2, 3, 4, 5 -> 5, 6, 1, 2, 3, 4
        people = new int[length]; // 사람 올라가있는 위치

        // 임시 배열들
//        changedI = new int[length];
        changedC = new int[length];
        changedP = new int[length];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length; i++) {
            chain[i] = Integer.valueOf(st.nextToken());
//            indices[i] = i + 1;
        }

        pro();


    }
}
