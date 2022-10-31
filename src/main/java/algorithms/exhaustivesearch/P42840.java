package algorithms.exhaustivesearch;

/*
* 모의고사
* 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
* 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
* 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
* */

import java.util.PriorityQueue;
import java.util.Queue;

public class P42840 {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cntInfo = new int[3];

        int max = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) {
                cntInfo[0]++;
                if (max < cntInfo[0]) max = cntInfo[0];
            }
            if (answers[i] == second[i % first.length]) {
                cntInfo[1]++;
                if (max < cntInfo[1]) max = cntInfo[1];
            }
            if (answers[i] == third[i % first.length]) {
                cntInfo[2]++;
                if (max < cntInfo[2]) max = cntInfo[2];
            }
        }

        System.out.println(cntInfo[0]);
        return cntInfo;
    }

    public static void main(String[] args) {
        P42840 p42840 = new P42840();
        int[] test = {1,3,2,4,2};

        p42840.solution(test);
    }
}
