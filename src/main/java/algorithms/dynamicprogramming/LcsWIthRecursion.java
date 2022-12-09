package algorithms.dynamicprogramming;

import java.util.Arrays;

public class LcsWIthRecursion {

    public int withOnlyRecursion(String X, String Y) {
        if (X.length() < 1 || Y.length() < 1) return 0;

        if (X.charAt(X.length() - 1) == Y.charAt(Y.length() - 1))
            return 1 + withOnlyRecursion(X.substring(0, X.length() - 1), Y.substring(0, Y.length() - 1)); // 마지막 문자가 같을 시
        // 마지막 문제가 다를 시
        return Math.max(withOnlyRecursion(X.substring(0, X.length() - 1), Y), withOnlyRecursion(X, Y.substring(0, Y.length() - 1)));
    }

    public int withCacheAsWell(String X, String Y, int[][] memo) {
        if (X.length() < 1 || Y.length() < 1) {
            return memo[X.length()][Y.length()] = 0;
        }

        int a = 0;
        int b = 0;
        int max = 0;

        if (X.charAt(X.length() - 1) == Y.charAt(Y.length() - 1)) { // 맨 마지막 문자들이 같을 때
            if (memo[X.length()-1][Y.length()-1] != -1)
                a = memo[X.length()-1][Y.length()-1];
            else {
                a = withCacheAsWell(X.substring(0, X.length()-1), Y.substring(0, Y.length()-1), memo);
            }
            return memo[X.length()][Y.length()] = 1 + a;
        }

        if (memo[X.length() - 1][Y.length()] != -1) // 캐시에서 참고해야 하는 위치가 비어있지 않다면
            a = memo[X.length() - 1][Y.length()];
        else {
            a = withCacheAsWell(X.substring(0, X.length() - 1), Y, memo);
            memo[X.length()-1][Y.length()] = a;
        }

        max = a;

        if (memo[X.length()][Y.length() - 1] != -1)
            b = memo[X.length()][Y.length() - 1];
        else {
            b = withCacheAsWell(X, Y.substring(0, Y.length() - 1), memo);
            memo[X.length()][Y.length()-1] = b;
        }

        if (b > max) max = b;

        return memo[X.length()][Y.length()] = max;
    }


    public static void main(String[] args) {
        LcsWIthRecursion lcs = new LcsWIthRecursion();
        String X = "DCABDC";
        String Y = "ABCDCCA";

        int[][] memoization = new int[X.length()+1][Y.length()+1];

        for (int[] row : memoization) {
            Arrays.fill(row, -1);
        }

        System.out.println(lcs.withCacheAsWell(X, Y, memoization));
        for (int[] row : memoization) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(lcs.withOnlyRecursion(X, Y));
    }
}
