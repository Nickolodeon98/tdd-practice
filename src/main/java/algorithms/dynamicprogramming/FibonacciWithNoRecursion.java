package algorithms.dynamicprogramming;

public class FibonacciWithNoRecursion {


    public int fibonacciNum(int n, int[] memo) {
        if (n == 1 || n == 2) return n;

        memo[1] = 1;
        memo[2] = 2;
        int idx = 1;
        while (idx <= n) {
            if (memo[idx] == 0) memo[idx] = memo[idx-1] + memo[idx-2]; // memo 에 저장이 안되어 있으면 새로 구한다.
            idx++;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        FibonacciWithNoRecursion fibonacci = new FibonacciWithNoRecursion();
        System.out.println(fibonacci.fibonacciNum(5, new int[6])); // 8 이 출력된다.
    }
}
