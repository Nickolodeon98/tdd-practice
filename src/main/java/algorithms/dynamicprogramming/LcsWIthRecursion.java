package algorithms.dynamicprogramming;

public class LcsWIthRecursion {

    public int withOnlyRecursion(String X, String Y) {
        if (X.length() < 1 || Y.length() < 1) return 0;

        if (X.charAt(X.length()-1) == Y.charAt(Y.length()-1))
            return 1 + withOnlyRecursion(X.substring(0, X.length()-1), Y.substring(0, Y.length()-1)); // 마지막 문자가 같을 시
        // 마지막 문제가 다를 시
        return Math.max(withOnlyRecursion(X.substring(0, X.length() - 1), Y), withOnlyRecursion(X, Y.substring(0, Y.length()-1)));
    }


    public static void main(String[] args) {
        LcsWIthRecursion lcs = new LcsWIthRecursion();
        System.out.println(lcs.withOnlyRecursion("DCABDCABCDEF", "ABCDCBAABCDEF"));
    }
}
