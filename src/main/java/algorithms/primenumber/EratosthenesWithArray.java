package algorithms.primenumber;

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
         * 소수가 아니라면 자신을 포함한 모든 배수의 자리에 0을 할당한다. */
        for (int j = 2; j * j <= N; j++) {
            /* 이미 0이 할당되었으면 배수들이 모두 j-1 까지의 숫자들의 배수와 겹치는 수들이라는 의미이므로 배수 찾기를 하지 않는다. */
            if (answerArr[j] == 0) continue;
            /* 2와 3은 소수이므로 상관 없고, 4부터 생각하면 k 는 j 의 제곱부터 시작한다.
             * 그 이유는 j-1 까지의 모든 숫자들은 이미 j 에 도달하기 이전에
             * 한 번씩 j 에 곱해진 후 0이 할당되었음을 짐작 가능하기 때문이다. */
            for (int k = j * j; k <= N ; k += j) {
                answerArr[k] = 0;
            }
        }

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
