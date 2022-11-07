package algorithms.hash.programmers;

/* 1단계
 * 주어진 숫자의 각 자릿수의 합을 구한다.
 * 방법 :
 * 예 1) 14가 주어지면, 각 자릿수의 합은 1 + 4 = 5이다.
 * 과정을 풀어서 쓰면, 14 / 10 = 1 ... 4 -> 14 / 10 + 14 % 10.
 * 예 2) 329가 주어진다. 각 자릿수의 합은 3 + 2 + 9 = 14이다.
 * 과정을 풀어서 쓰면, 329 / 10 = 32 ... 9. 32 / 10 = 3... 2
 * -> 329 / 10 / 10 + 329 % 10 + 329 / 10 % 10 = 3 + 9 + 2 = 14.
 * 즉, 몫이 1일 때까지 10으로 나눈 후 그 몫 + 모듈로(%) 연산자로 각 단계에서 구한 나머지들을 더하면 자릿수의 합이다.
 * */

public class P12947 {
    /* Step 1: Find the sum of each digit of given number */
    private int divisibleNum(int x) {
        int value = x;
        int result = 0;
        while (value > 0) {
            result += value % 10;
            value = value / 10;
        }
//        System.out.println(result);
        return result;
    }

    /* Step 2: Find whether a given number is divisible by the sum calculated above */
    public boolean isHarshad(int x) {
        return x % divisibleNum(x) == 0;
    }

    public static void main(String[] args) {
        P12947 p12947 = new P12947();
        System.out.println(p12947.isHarshad(13));
    }
}
