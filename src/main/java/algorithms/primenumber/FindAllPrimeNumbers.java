package algorithms.primenumber;

import java.util.ArrayList;
import java.util.List;

public class FindAllPrimeNumbers {
    public void findAllPrimes(int N) {
        List<Integer> numbersToN = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            numbersToN.add(i);
        }

        numbersToN.removeIf(elem -> elem != 2 && elem % 2 == 0);

        System.out.println("원소: " + numbersToN + ", 개수: " + numbersToN.size());
    }

    public static void main(String[] args) {
        FindAllPrimeNumbers findAllPrimeNumbers = new FindAllPrimeNumbers();
        findAllPrimeNumbers.findAllPrimes(50);
    }
}
