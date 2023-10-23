package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RE_RE_B5430 {
    static int[] arr;
    static String command;
    static String partition;
    static String info;
    static StringBuilder sb;
    static int startPtr;
    static int endPtr;
    static int length;

    public static void init(String info) {
        // "[]"
        if (info.length() == 2) {
            startPtr = 0;
            endPtr = 0;
            return;
        }
        // "[12]"
        partition = info.substring(1, info.length()-1);
        // "12"
        if (!partition.contains(",")) {
            arr[0] = Integer.valueOf(partition);
        }
        // "1,2,3"
        else {
            String[] numbers = partition.split(",");
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.valueOf(numbers[i]);
            }
        }
        // "[1,2,3]"
        startPtr = 0;
        endPtr = arr.length-1;
    }

    public static void solution() {
        char[] actions = command.toCharArray();

        for (int i = 0; i < actions.length; i++) {
            if (actions[i] == 'R') {
                int tmp = startPtr;
                startPtr = endPtr;
                endPtr = tmp;
            } else if (actions[i] == 'D') {
                if (length <= 0) {
                    sb.append("error\n");
                    return;
                }
                length--;

                if (startPtr < endPtr)
                    startPtr++;
                else startPtr--;
            }

        }
        List<Integer> expressed = new ArrayList<>();

        if (length<=0) {
            sb.append("[]\n");
            return;
        }

        if (length == 1) {
            sb.append("[" + arr[startPtr] + "]\n");
            return;
        } else if (startPtr < endPtr) {
            for (int i = startPtr; i <= endPtr; i++) {
                expressed.add(arr[i]);
            }
        } else {
            for (int i = startPtr; i >= endPtr; i--) {
                expressed.add(arr[i]);
            }
        }
        sb.append("[");
        for (int i = 0; i < expressed.size()-1; i++) {
            sb.append(expressed.get(i)+",");
        }
        sb.append(expressed.get(expressed.size()-1));
        sb.append("]\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            command = br.readLine();
            length = Integer.valueOf(br.readLine());
            arr = new int[length];
            info = br.readLine();
            init(info);
            solution();
        }
        System.out.println(sb);
    }
}
