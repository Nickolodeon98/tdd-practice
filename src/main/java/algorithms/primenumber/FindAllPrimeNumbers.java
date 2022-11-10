package algorithms.primenumber;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FindAllPrimeNumbers {
    public int findAllPrimes(int N) {
        List<Integer> numbersToN = new ArrayList<>();

        for (int i = 2; i <= N; i++) {

            numbersToN.add(i);

        }

        for (int j = 2; j <= Math.sqrt(N); j++) {
            for (int k = 0; k < numbersToN.size(); k++) {
                if (numbersToN.get(k) != j && numbersToN.get(k) % j == 0) numbersToN.remove(k);
            }
        }
        return numbersToN.size();
    }

    public static void main(String[] args) {
        FindAllPrimeNumbers findAllPrimeNumbers = new FindAllPrimeNumbers();
        System.out.println(LocalDateTime.now());
        System.out.println(findAllPrimeNumbers.findAllPrimes(300000));
        System.out.println(LocalDateTime.now());

    }
}
