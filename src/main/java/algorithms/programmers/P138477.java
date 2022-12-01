package algorithms.programmers;

import org.mockito.internal.matchers.Null;

import java.util.*;

public class P138477 {

    /* 점수 변수: 문자 투표수에 따라 달라진다. 매일 출연한 가수를 순위를 매긴다.
     * 상위 k 번째 내 이면 명예의 전당 등극.
     * 큐가 빈 상태가 아니라면 항상 최솟값을 교체한다. 현재 사이즈가 k 라면 k 번째보다 클 때 넣는다.
     * 사이즈가 k 보다 작다면 비교할 필요 없이 최솟값을 리턴한다.
     * 사이즈 > k 이 되는 순간부터는 큐 내의 최솟값을 삭제하는 연산도 포함한다. */

    public int[] hallOfFame(int k, int[] score) {
        PriorityQueue<Integer> hall = new PriorityQueue<>();

        int[] hallOfFame = new int[score.length];
        int idx = -1;

        for (int singleScore : score) {
            idx++;
            if (hall.size() < k) {
                hall.add(singleScore);
                hallOfFame[idx] = hall.peek();
                continue;
            }
            if (hall.peek() < singleScore) {
                hall.poll();
                hall.add(singleScore);
            }
            hallOfFame[idx] = hall.peek();
        }

        return hallOfFame;
    }

    public void hallOfFame2(int k, int[] score) {
        List<Integer> hall = new ArrayList<>();

        List<Integer> minNums = new ArrayList<>();

        int[] hallOfFame = new int[score.length];
        int min = score[0];

        minNums.add(min);

        for (int i = 1; i < k; i++) {
            if (score[i] < min) {
                min = score[i];
            }
            minNums.add(min);
//            System.out.println(min);
        }

        for (int j = k; j < score.length; j++) {
            if (min < score[j]) min = score[j];
            minNums.add(min);
        }
        System.out.println(minNums);
    }

    public static void main(String[] args) {
        P138477 p138477 = new P138477();
        int[] test = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println(Arrays.toString(p138477.hallOfFame(4, test)));
//        p138477.hallOfFame2(4, test);
    }

}
