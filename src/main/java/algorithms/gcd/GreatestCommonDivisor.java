package algorithms.gcd;

public class GreatestCommonDivisor {
    /* 반환 타입은 최대공약수를 반환해야 하므로 정수로 한다.
     * 최대공약수를 정의하는 네 가지 정의를 조건문에 넣어 사용한다.
     * b 가 a 보다 크면 b 에서 a 를 뺀다. (vice versa)
     * a 와 b - a 또는 a - b 와 b 를 인자로 메서드를 재귀 호출한다.
     * 하나의 숫자가 1 이 되면 1을 리턴한다. (두 숫자가 소수인 경우) */
    public int computeDivisor(int a, int b) {
        if (a == b) return a; // 같아지는 순간 a 를 리턴하고, 처음에 호출된 곳까지 돌아가서 반환된다.
        if (a == 1 || b == 1) return 1; // 하나라도 1이 되는 순간 리턴되고 처음에 호출된 곳에 돌아가 반환된다.

        if (b > a) return computeDivisor(a, b - a); // b 가 a 보다 크면 a 와 b-a 로 재귀 호출을 한다.

        return computeDivisor(a-b, b); // a 가 b 보다 크면 a-b 와 b 로 재귀 호출한다.
    }

    public static void main(String[] args) {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        gcd.computeDivisor(14, 16); // 기댓값: 2
    }
}
