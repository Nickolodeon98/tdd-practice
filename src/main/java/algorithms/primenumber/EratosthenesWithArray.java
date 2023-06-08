package algorithms.primenumber;

import java.util.Arrays;

public class EratosthenesWithArray {
    public int numberOfPrimes(int N) {
        /* 인덱스 N 에 N을 집어넣을 것이기 때문에 배열의 크기는 N + 1 이 되어야 한다. */
        int[] answerArr = new int[N+1];
        int answer = 0;
        /* 배열에 2부터 N 까지의 숫자를 할당한다. */
        for (int i = 2; i <= N; i++) {
            answerArr[i] = i;
        }

        /* 2부터 N 의 제곱근까지의 숫자들 중 소수인 것은 자신을 제외한 모든 배수,
         * 소수가 아니라면 자신을 포함한 모든 배수의 자리에 0을 할당한다.
         * 제곱근인 이유는 밑의 논리와 흡사하다. 숫자의 제곱은 어차피 배수 찾기 동안 모두 지워지기 때문이다. */
        for (int j = 2; j * j <= N; j++) {
            /* 이미 0이 할당되었으면 배수들이 모두 j-1 까지의 숫자들의 배수와 겹치는 수들이라는 의미이므로 배수 찾기를 하지 않는다.
            * 예를 들어 4는 2의 배수 찾을 때 지워져서 0일 것이고, 4 % 2 == 0 이라는 것은 모든 이후 숫자들이 (4 * 2) % 2 == 0,
            * (4 * 3) % 2 == 0 라는 것이다. 이런 식으로 다 볼 필요도 없이 4의 배수들은 2의 배수 지울 때 다 지워졌으므로 안 찾는 것이다.
            * 그래서 4의 배수 찾기는 할 필요가 없다. */
            if (answerArr[j] == 0) continue; // 배수 찾기를 넘어간다.
            /* 2와 3은 소수이므로 상관 없고, 4부터 생각하면 k 는 j 의 제곱부터 시작한다.
             * 그 이유는 j-1 까지의 모든 숫자들은 이미 j 에 도달하기 이전에
             * 한 번씩 j 에 곱해진 후 0이 할당되었음을 짐작 가능하기 때문이다.
             * 예를 들어, 4 * 2 그리고 4 *3 를 확인하지 않고 바로 4 * 4를 확인하면서 시작하는 것은
             * 이전에 2의 배수와 3의 배수를 지울 때 2 * 4와 3 * 4를 지웠기 때문이다. */
            for (int k = j * j; k <= N ; k += j) {
//                System.out.println(Arrays.toString(answerArr));
                answerArr[k] = 0;
            }
        }
        /* 결국 위 이중 for 문은 최소한의 연산으로 소수를 구할 수 있게끔 만들어졌다. */

        /* 배열에 남은 0이 아닌 숫자들의 개수를 센다. 이 시점에서 0이 아닌 숫자들은 모두 그 무엇의 배수도 아니므로 소수이다. */
        for (int l = 0; l < answerArr.length; l++) {
            if (answerArr[l] != 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        EratosthenesWithArray eratosthenes = new EratosthenesWithArray();
        System.out.println(eratosthenes.numberOfPrimes(50));
    }
}
