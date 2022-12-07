package algorithms.heap;

import java.util.PriorityQueue;

public class P42626 {

    /* 모든 경우의 수
     * 1. 하나씩 모두 센다. 매번 모든 원소가 K 이상인지 확인한다.
     * 2. 섞은 수가 K 이상일 때에는 넣은 후의 맨 처음의 상태를 확인한다.
     * -> 맨 처음 상태만 확인하면 된다.
     * 대신 K 이상이 아닐 때에는 (K 미만) 확인하지 않는다.
     * 섞는 연산 시 + 1 로 카운트한다.
     */

    public static int makeSpicy(int[] scoville, int k) {
        PriorityQueue<Integer> rankings = new PriorityQueue<>();
        int count = 0;

        for (int i : scoville) {
            rankings.add(i);
        }

        /* 맨 앞 두 개를 빼서 섞는다. 이미 맨 앞이 K 이상이면 끝. 0회다.
         * 반복해서 섞는 작업을 하면서 횟수를 세는데, 맨 처음이 k 보다 작은 한 반복된다.
         * 크거나 같아지면 결국 우선순위 큐의 모든 원소가 k 보다 크거나 같다는 것이기 때문이다. */

        int lowest = 0;
        while ((lowest = rankings.poll()) < k) {
            /* 만약 방금 빼낸 것이 마지막으로 남은 원소였다면, 결국 섞다 섞다 마지막 두 개를 섞어서 최소 스코빌 지수가 k 보다 작았다는 의미이므로
             * 모든 음식을 k 이상으로 만드는 것에 실패했다. -1을 반환한다. */
            if (rankings.isEmpty()) return -1;
            int nextLowest = rankings.poll();
            int mixed = lowest + (2 * nextLowest);
            count++;
            rankings.add(mixed);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(makeSpicy(scoville, k));
    }

}
