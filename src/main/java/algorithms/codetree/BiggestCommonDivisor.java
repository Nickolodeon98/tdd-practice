package algorithms.codetree;

public class BiggestCommonDivisor {
    /* 정수 n, m이 주어졌을 때, 두 숫자의 최대 공약수를 구하는 알고리즘
     * 최대 공약수의 정의: 두 숫자를 모두 나눌 수 있는 숫자들 중 가장 큰 수 */
    public int commonDivisor(int n, int m) {
        int answer = 0;
        /* 1부터 두 숫자 중 작은 수까지의 수들을 모두 탐색하며 n과 m을 나누고 나머지가 0인지 확인한다. */
        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) answer = i;
        }

        return answer;
    }
}
