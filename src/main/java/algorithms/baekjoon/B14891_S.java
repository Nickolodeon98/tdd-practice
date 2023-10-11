package algorithms.baekjoon;

import java.io.*;
import java.util.*;

public class B14891_S {
    static class Gear {
        int[] gears;
        int right;
        int left;

        public Gear() {
            this.gears = new int[8];
            this.right = 2;
            this.left = 6;
        }

        public void turnClockWise() {
            this.right = (this.right + 7) % 8;
            this.left = (this.left + 7) % 8;
        }

        public void turnAntiClockWise() {
            this.right = (this.right + 1) % 8;
            this.left = (this.left + 1) % 8;
        }

        public int getTop() {
            return this.gears[(this.right + 6) % 8];
        }

        public int getLeftValue() {
            return this.gears[this.left];
        }

        public int getRightValue() {
            return this.gears[this.right];
        }


    }

    static Gear[] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new Gear[4];

        for (int i = 0; i < gears.length; i++) {
            char[] chars = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(chars));
            gears[i] = new Gear();
            for (int j = 0; j < 8; j++) {
                int type = chars[j] == '0' ? 0 : 1;
//                System.out.println(type);
                gears[i].gears[j] = type;
            }

        }


        int N = Integer.valueOf(br.readLine());
//        int[][] input = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int gear = Integer.valueOf(st.nextToken()) - 1;
            int direction = Integer.valueOf(st.nextToken());

//            input[i][0] = gear;
//            input[i][1] = direction;

            turn(gear, direction);
        }

        int totalScore = 0;
        int point = 1;
        for (int i = 0; i < gears.length; i++) {
            if (gears[i].getTop() == 1) {
                totalScore += point;
            }
            point *= 2;
        }
        System.out.println(totalScore);


    }

    static void turnGearToLeft(int gear, int isClockWise) {
        if (gear < 0) {
            return;
        }

        if (gear > 0) {
            if (gears[gear].getLeftValue() != gears[gear - 1].getRightValue()) {
                turnGearToLeft(gear - 1, isClockWise * -1);
            }

        }

        if (isClockWise == 1) {
            gears[gear].turnClockWise();
        } else {
            gears[gear].turnAntiClockWise();
        }
    }

    static void turnGearToRight(int gear, int isClockWise) {
        if (gear >= gears.length) {
            return;
        }

        if (gear < gears.length - 1) {
            if (gears[gear].getRightValue() != gears[gear + 1].getLeftValue()) {
                turnGearToRight(gear + 1, isClockWise * -1);
            }
        }

        if (isClockWise == 1) {
            gears[gear].turnClockWise();
        } else {
            gears[gear].turnAntiClockWise();
        }
    }

    static void turn(int gear, int isClockWise) {
        if (gear > 0) {
            if (gears[gear].getLeftValue() != gears[gear - 1].getRightValue()) {
                turnGearToLeft(gear - 1, isClockWise * -1);
            }

        }
        if (gear < gears.length - 1) {
            if (gears[gear].getRightValue() != gears[gear + 1].getLeftValue()) {
                turnGearToRight(gear + 1, isClockWise * -1);
            }
        }

        if (isClockWise == 1) {
            gears[gear].turnClockWise();
        } else {
            gears[gear].turnAntiClockWise();
        }
    }
}


