package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RE_B8911 {
    static StringBuilder sb;
    static int[] pos;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int curDir = 0;

    static int minDistY = 250;
    static int minDistX = 250;
    static int maxDistY = 250;
    static int maxDistX = 250;

    public static void move(char inst) {
        int ny = pos[0];
        int nx = pos[1];

        if (inst == 'F') {
            ny += dir[curDir][0];
            nx += dir[curDir][1];
        }

        if (inst == 'B') {
            ny -= dir[curDir][0];
            nx -= dir[curDir][1];
        }
        minDistY = Math.min(minDistY, ny);
        minDistX = Math.min(minDistX, nx);
        maxDistY = Math.max(maxDistY, ny);
        maxDistX = Math.max(maxDistX, nx);
        pos[1] = nx;
        pos[0] = ny;

        if (inst == 'R') {
            curDir = (curDir + 1) % 4;
        }

        if (inst == 'L') {
            curDir = (curDir - 1 + 4) % 4;
        }

    }

    public static void solution(String command) {
        char[] steps = command.toCharArray();

        for (int i = 0; i < steps.length; i++) {
            move(steps[i]);
        }

        rectangle();
    }

    public static int computeDist(int y, int x, int targetY, int targetX) {
        return Math.abs(targetY - y) * Math.abs(targetX - x);
    }

    public static void rectangle() {
        sb.append(computeDist(minDistY, minDistX, maxDistY, maxDistX) + "\n");
    }

    public static void init() {
        pos[0] = 250;
        pos[1] = 250;
        minDistX = 250;
        maxDistX = 250;
        minDistY = 250;
        maxDistY = 250;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        sb = new StringBuilder();
        String command = "";
        pos = new int[2];

        for (int i = 0; i < T; i++) {
            init();
            command = br.readLine();
            solution(command);
        }
        System.out.print(sb);
    }
}
