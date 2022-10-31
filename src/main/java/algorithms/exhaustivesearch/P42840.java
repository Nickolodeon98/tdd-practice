package algorithms.exhaustivesearch;

/*
* 모의고사
* 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
* 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
* 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
* */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class P42840 {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cntInfo = new int[3];

        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) {
                cntInfo[0]++;
                if (max < cntInfo[0]) {
                    max = cntInfo[0];
                    maxIdx = 0;
                }
            }
            if (answers[i] == second[i % first.length]) {
                cntInfo[1]++;
                if (max < cntInfo[1]) {
                    max = cntInfo[1];
                    maxIdx = 1;
                }
            }
            if (answers[i] == third[i % first.length]) {
                cntInfo[2]++;
                if (max < cntInfo[2]) {
                    max = cntInfo[2];
                    maxIdx = 2;
                }
            }
        }

        /*가장 많이 문제를 맞힌 사람 찾는 방법
        * 1. 하나하나 비교하면서 최대값을 찾고 몇 번째에 있는지 확인한다.
        * 2. 찾은 최대값의 위치를 0으로 초기화한다. 계속 탐색한다.
        * 3. 최대값과 같은 값이 나오면 0으로 초기화하고 다시 찾기를 반복한다.
        * 4. 더 이상 같은 값이 나오지 않으면 멈춘다.*/
        int tempMax = cntInfo[maxIdx];
        cntInfo[maxIdx] = 0;
        int i = 0;
        int[] answer = new int[3];

        answer[0] = maxIdx + 1;
        int cnt = 1;
        while (i < 3) {
            if (tempMax == cntInfo[i]) {
                answer[cnt] = i+1;
                cntInfo[i] = 0;
                cnt++;
            }
            i++;
        }
        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));
        return cntInfo;
    }

    public static void main(String[] args) {
        P42840 p42840 = new P42840();
        int[] test = {1,2,3,4,5};

        p42840.solution(test);
    }
}
