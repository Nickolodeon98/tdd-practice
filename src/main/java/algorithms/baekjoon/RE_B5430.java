package algorithms.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class RE_B5430 {
    static int[] arr;
    static String command;
    static String partition;
    static String info;
    static StringBuilder sb;
    static StringBuilder container;
    static Deque<Integer> candi;
    public static void init(String info) {
        candi = new LinkedList<>();
        container = new StringBuilder();

        if (info.length() == 2) return;

        partition = info.substring(1, info.length()-1);

        if (!partition.contains(",")) {
            container.append(partition + " ");
        }
        else {
            String[] numbers = partition.split(",");
            for (int i = 0; i < numbers.length; i++) {
                container.append(numbers[i] + " ");
            }
        }

    }

    public static void solution() {
        char[] actions = command.toCharArray();

        for (int i = 0; i < actions.length; i++) {
            if (actions[i] == 'R') {
                container = container.reverse();
                System.out.println(container);
            } else if (actions[i] == 'D') {
                if (container.length() == 0) {
                    break;
                }
                String[] contained = container.toString().split(" ");
                String[] changed = new String[contained.length-1];
                container = new StringBuilder();
                for (int j = 1; j < contained.length; j++) {
                    changed[j-1] = contained[j];
                    container.append(contained[j]);
                }
            }

        }

        sb.append(container.length() != 0 ? container + "\n" : "error\n");
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

