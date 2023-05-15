package algorithms.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P42627 {

    public int[][] sortJobs(int[][] jobs) {
        int[][] sortedJobs = new int[jobs.length][jobs[0].length];
        int minIdx = 0;
        int min = jobs[minIdx][0];
        List<Integer> passIdx = new ArrayList<Integer>();

        for (int j = 0; j < sortedJobs.length; j++) {
            for (int i = 0; i < jobs.length; i++) {
                if (!passIdx.isEmpty() && passIdx.contains(i)) continue;
                if (jobs[i][0] < min) {
                    min = jobs[i][0];
                    minIdx = i;
                    continue;
                }
                if (jobs[i][0] == min) {
                    if (jobs[i][1] < jobs[minIdx][1]) {
                        min = jobs[i][0];
                        minIdx = i;
                    }
                }
            }
            sortedJobs[j] = jobs[minIdx];
            min = 9999;
            passIdx.add(minIdx);
        }
        for (int i = 0; i < sortedJobs.length; i++) System.out.println(Arrays.toString(sortedJobs[i]));
        return sortedJobs;
    }


    public int totalAboveAll(int[][] jobs) {
        int count = 0;
        int current = 0;

        List<Integer> minIndices = new ArrayList<>();
        int pos = 0;
        int min = 9999;

        int minIdx = -1;

        jobs = sortJobs(jobs);
        boolean check = false;

        while (jobs.length > count) { // 소요 시간을 파악하는 반복문으로, 작업의 개수보다 반복 횟수가 적은 한 계속 반복된다. 마지막에는 총 소요 시간이 구해진다.
            for (int i = 0; i < jobs.length; i++) { // 처리를 대기하는 작업들 각각에 대해,
                //TODO: 이미 처리된 작업을 파악에서 제외한다.
                if (minIndices.contains(i)) continue; // 이미 처리한 작업은 확인하지 않는다.

                if (pos >= jobs[i][0]) { // 시작 시점이 요청 중에 있었을 때에만 진행한다.
                    int duration = pos - jobs[i][0] + jobs[i][1]; // 지금 파악된 처리 까지 대기 시간이 얼마나 되는지 확인하고,
                    System.out.println("duration: " + duration);
                    if (duration < min) { // 대기 시간이 가장 작은 것을 찾는다.
                        min = duration;
                        minIdx = i; // 대기 시간이 가장 적은 작업의 배열 내에서의 인덱스를 파악한다.
                        check = true;
                    }
                }
            }
            if (!check) {
                minIdx = count; // 작업이 아무것도 요청 중에 있던 것이 없으면, 0번이 가장 작은 작업을 진행한다.
                min = jobs[minIdx][1];
                for (int i = 0; i < jobs.length; i++) {
                    if (minIndices.contains(i)) continue;
                    if (jobs[i][0] == jobs[minIdx][0]) {
                        if (jobs[i][1] < min) {
                            minIdx = i;
                            min = jobs[minIdx][1];
                        }
                    }
                }
                pos = jobs[minIdx][0];
            }
            pos += jobs[minIdx][1]; // 파악된 대기 시간이 가장 짧은 작업을 처리한 이후의 위치로 옮긴다.
            current += min; // 현재까지의 소요 시간을 파악한다.
            System.out.println(current);
            count++; // 몇 개의 작업을 처리했는지 센다.
            //TODO: 이미 처리된 작업을 파악에서 제외한다.
            minIndices.add(minIdx);
            min = 99;
            check = false;
        } // 이 반복문을 빠져나오면 처리해야 할 작업들을 모두 current 에 누적해 더한 상태로 빠져나온다.

        return current;
    }


    private int factorial(int num) {
        if (num == 0) return 1;
        return num * factorial(num - 1);
    }

    public int discController(int[][] jobs) {
        int count = 0;
        int total = 0;
        int current = 0;
        int pos = 0;
        int min = 9999;

        int minIdx = -1;
        int counter = 0;

        List<Integer> minIndices = new ArrayList<>();
        /* 반복해서 섞는다. 섞은 결과물들 중 이전 것이 작을 때만 변화가 일어난다. */

        while (total <= current) {
            if (total == 0) total = current;
            while (jobs.length > count) { // 소요 시간을 파악하는 반복문으로, 작업의 개수보다 반복 횟수가 적은 한 계속 반복된다. 마지막에는 총 소요 시간이 구해진다.
                for (int i = 0; i < jobs.length; i++) { // 처리를 대기하는 작업들 각각에 대해,
                    //TODO: 이미 처리된 작업을 파악에서 제외한다.
                    if (minIndices.contains(i)) continue; // 이미 처리한 작업은 확인하지 않는다.

                    int duration = pos - jobs[i][0] + jobs[i][1]; // 지금 파악된 처리 까지 대기 시간이 얼마나 되는지 확인하고,
                    if (duration < min) { // 대기 시간이 가장 작은 것을 찾는다.
                        min = duration;
                        minIdx = i; // 대기 시간이 가장 적은 작업의 배열 내에서의 인덱스를 파악한다.
                    }
                }
                pos += jobs[minIdx][1]; // 파악된 대기 시간이 가장 짧은 작업을 처리한 이후의 위치로 옮긴다.
                current += min; // 현재까지의 소요 시간을 파악한다.
                count++; // 몇 개의 작업을 처리했는지 센다.
                //TODO: 이미 처리된 작업을 파악에서 제외한다.
                minIndices.add(minIdx);

            } // 이 반복문을 빠져나오면 처리해야 할 작업들을 모두 current 에 누적해 더한 상태로 빠져나온다.
            count = 0;
            pos = 0;
            counter++;
            minIndices.clear();
            if (factorial(jobs.length) == counter) break; // total 이 업데이트 되지 않아도 모든 경우의 수를 전부 돌았으면 멈춘다.
        }
        total = current;

        return total;
    }

    public static void main(String[] args) {
        P42627 p42627 = new P42627();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};


//        System.out.println(p42627.discController(jobs));

        System.out.println(p42627.totalAboveAll(jobs) / jobs.length); // 27 / 3 이 나옵니다.
    }

}
