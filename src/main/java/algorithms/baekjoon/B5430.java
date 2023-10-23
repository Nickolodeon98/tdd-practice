package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class B5430 {
    static int[] arr;
    static String command;
    static String partition;
    static String info;
    static StringBuilder sb;
    static Deque<Integer> candi;
    public static void init(String info) {
        candi = new LinkedList<>();

        if (info.length() == 2) return;

        partition = info.substring(1, info.length()-1);

        if (!partition.contains(",")) {
            candi.addLast(Integer.valueOf(partition));
        }
        else {
            String[] numbers = partition.split(",");
            for (int i = 0; i < numbers.length; i++) {
                candi.addLast(Integer.valueOf(numbers[i]));
            }
        }

    }

    public static void solution() {
        char[] actions = command.toCharArray();
        Stack<Integer> reversed = new Stack<>();

        for (int i = 0; i < actions.length; i++) {
            if (actions[i] == 'R') {
                while (!candi.isEmpty()) {
                    reversed.push(candi.removeLast());
                }
                candi = new LinkedList<>(reversed);
                reversed.clear();
            } else if (actions[i] == 'D') {
                if (candi.isEmpty()) {
                    break;
                }
                candi.removeFirst();
            }

        }

        sb.append(candi.isEmpty() ? "error\n" : candi + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            command = br.readLine();
            int size = Integer.valueOf(br.readLine());
            arr = new int[size];
            info = br.readLine();
            init(info);
            solution();
        }
        System.out.println(sb);
    }
}
