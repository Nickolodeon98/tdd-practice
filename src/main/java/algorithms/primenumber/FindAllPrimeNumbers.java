package algorithms.primenumber;

import java.util.ArrayList;
import java.util.List;

public class FindAllPrimeNumbers {
    public void findAllPrimes(int N) {
        List<Integer> numbersToN = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            numbersToN.add(i);
        }
        for (int j = 0; j < numbersToN.size(); j++) {
            if (numbersToN.get(j) != 2 && numbersToN.get(j) % 2 == 0) numbersToN.remove(j);
        }

        System.out.println(numbersToN + " " + numbersToN.size());
    }

    public static void main(String[] args) {
        FindAllPrimeNumbers findAllPrimeNumbers = new FindAllPrimeNumbers();
        findAllPrimeNumbers.findAllPrimes(50);
    }
}
