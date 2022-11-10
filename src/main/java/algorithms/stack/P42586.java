package algorithms.stack;

import java.awt.desktop.AppReopenedEvent;
import java.util.*;

public class P42586 {
    /* 우선 progresses 의 모든 원소를 스택에 넣는다.
     * 그리고 speeds 정보를 토대로 스택에 있는 수들을 업데이트한다.
     * 100을 도달한 원소가 있으면 peek 인지 확인한 후 pop 을 하거나 대기시킨다.
     * pop 을 할 때 while 문으로 함께 pop 되는 원소의 개수를 세서 배열에 넣는다. */
    public int[] development(int[] progresses, int[] speeds) {
        Queue<Integer> progressState = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        /* 1단계 */
        for (int i = 0; i < progresses.length; i++) {
            progressState.add(progresses[i]);
        }

        int cnt = 0;
        while (!progressState.isEmpty()) {
            if (progressState.peek() < 100) {
                progressState = dayPassed(progressState, speeds);
                if (cnt > 0) {
                    answer.add(cnt);
                    cnt = 0;
                }
            } else {
                progressState.poll();
                cnt++;
            }
        }
        answer.add(cnt);

        return answer.stream().mapToInt(i->i).toArray();
    }

    private Queue<Integer> dayPassed(Queue<Integer> queue, int[] speeds) {
        /* 2단계 : 1일이 지났을 때 */
        for (int j = 0; j < speeds.length; j++) {
            int toAdd = queue.poll() + speeds[j];
            queue.offer(toAdd);
        }
        return queue;
    }

    public static void main(String[] args) {
        P42586 p42586 = new P42586();
        int[] testArr1 = {95, 90, 99, 99, 80, 99};
        int[] testArr2 = {1, 1, 1, 1, 1, 1};
        int[] answer = p42586.development(testArr1, testArr2);

        System.out.println(Arrays.toString(answer));
    }
}
