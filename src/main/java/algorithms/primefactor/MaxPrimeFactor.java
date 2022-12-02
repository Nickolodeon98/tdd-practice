package algorithms.primefactor;

import java.util.*;

public class MaxPrimeFactor{

    /* 먼저 num 이하의 모든 소수를 찾고 소인수를 구할 때 그 소수들로만 나눌 수 있도록 준비한다. */
     public Long[] findPrimes(Long num) {
         Long[] primes = new Long[Math.toIntExact(num) + 1];

         for (Long i = 2L; i <= num; i++) {
             primes[Math.toIntExact(i)] = i;
         }

         for (int j = 2; j * j <= num; j++) {

             if (primes[j] == 0L) continue;

             for (int k = j * j; k <= num ; k += j) {
                 primes[k] = 0L;
             }
         }

         List<Long> primeNums = new ArrayList<>();
         for (int l = 2; l < primes.length; l++) {
             if (primes[l] == 0) continue;
             primeNums.add(primes[l]);
         }

         Long[] result = new Long[primeNums.size()];
         int idx = 0;
         for (Long primeNum : primeNums) {
            result[idx++] = primeNum;
         }
         return result;
     }

    public List<Long> divideNum(Long num) {
         Long[] primeInfo = findPrimes(num);
        System.out.println(primeInfo.length);
        List<Long> allFactors = new ArrayList<>();
//        System.out.println(Arrays.toString(primeInfo));
        for (int i = 0; i <= primeInfo.length; i++) {
            if (num % primeInfo[i] == 0) {
                allFactors.add(primeInfo[i]);
                allFactors.addAll(divideNum(num/primeInfo[i]));
                return allFactors;
            }
        }
        return allFactors;
    }

    public Long maxPrimeFactor(Long num) {
        List<Long> primeFactors = divideNum(num);
        Long maxValue = primeFactors.stream().reduce(0L, (a,b)->Math.max(a, b));
        return maxValue;
    }

    public static void main(String[] args) {
        MaxPrimeFactor primeFactor = new MaxPrimeFactor();
        Scanner sc = new Scanner(System.in);
        Long num = sc.nextLong();
        // System.out.println(primeFactor.divideNum(3717237)); // 2 와 5가 나와야 한다.
        System.out.println(primeFactor.maxPrimeFactor(num));
    }
}