package algorithms.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

    /* n = 5 일 때, memo[5] = fibo(4) + fibo(3) -> 여기서는 memo[3] 만 리턴된다.
     * fibo(4) = memo[4] = fibo(3) + fibo(2) // 깊이 들어간다.
     * memo[3] = 2 + 1 = 3; // memo[3] 이 정해졌다.
     * 궁금한 점: 정수 배열은 원래 변동이 적용이 안되지 않나요? 답: 됩니다.
     * */
    public int fibonacciWithMemo(int n, int[] memo) {
        if (n == 0) throw new RuntimeException();
        if (n == 1 || n == 2) return n;
//        System.out.println(memo[n]);
        if (memo[n] == 0) {
            memo[n] = fibonacciWithMemo(n-1, memo) + fibonacciWithMemo(n-2, memo); // cache 에 저장한다.
            // 최초 메서드 호출 시
            System.out.println(n + "에서 들어왔습니다.");
        }
        System.out.println(n + "에서 나갔습니다.");
        return memo[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 5;
        int[] cache = new int[n+1];
        fibonacci.fibonacciWithMemo(n, cache);
        System.out.println(Arrays.toString(cache));
    }
}
