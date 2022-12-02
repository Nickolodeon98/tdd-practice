package algorithms.primefactor;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 숫자 자신의 소인수들을 모두 그대로에서 또는 제곱이나 3승 4승..N 승 해서 곱하면 자신이 나온다.
 * 소인수분해는 수학을 배울 때 어떻게 구했냐면 숫자가 주어지면 다음 과정을 거친다.
 * 1. 2로 나누는 것으로 시작한다.
 * 2. 남은 숫자를 2로 나누어 보고, 안되면, 3, ... N 까지로 나누어 본다.
 * 3. 나눈 몫으로 1과 2번을 반복한다.
 * -> 결론적으로 2부터 N까지 모두 나누는데, 몫을 계속 저장하면서 나누면 된다. */
public class PrimeFactor {

    /* 먼저 num 이하의 모든 소수를 찾고 소인수를 구할 때 그 소수들로만 나눌 수 있도록 준비한다. */
    public int[] findPrimes(int num) {
        int[] primes = new int[num+1];

        for (int i = 2; i <= num; i++) {
            primes[i] = i;
        }

        for (int j = 2; j * j <= num; j++) {

            if (primes[j] == 0) continue;

            for (int k = j * j; k <= num ; k += j) {
                primes[k] = 0;
            }
        }

        List<Integer> primeNums = new ArrayList<>();
        for (int l = 2; l < primes.length; l++) {
            if (primes[l] == 0) continue;
            primeNums.add(primes[l]);
        }

        return primeNums.stream().mapToInt(i->i).toArray();
    }

    public List<Integer> divideNum(int num) {
        int[] primeInfo = findPrimes(num);
        List<Integer> allFactors = new ArrayList<>();
//        System.out.println(Arrays.toString(primeInfo));
        for (int i = 0; i < primeInfo.length; i++) {
            if (num % primeInfo[i] == 0) {
                allFactors.add(primeInfo[i]);
                allFactors.addAll(divideNum(num/primeInfo[i]));
                return allFactors;
            }
        }
        return allFactors;
    }

    public int maxPrimeFactor(int num) {
        List<Integer> primeFactors = divideNum(num);
        int maxValue = primeFactors.stream().reduce(0, (a,b)->Math.max(a, b));
        return maxValue;
    }

    public static void main(String[] args) {
        PrimeFactor primeFactor = new PrimeFactor();
        System.out.println(primeFactor.divideNum(3717237)); // 2 와 5가 나와야 한다.
        System.out.println(primeFactor.maxPrimeFactor(3717237));
    }
}
