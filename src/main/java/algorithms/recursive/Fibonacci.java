package algorithms.recursive;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public Long findFromSequence(int n) {
        if (n == 1 || n == 2) return 1L;
        List<Long> sequence = new ArrayList<>();
        sequence.add(1L);
        sequence.add(1L);

        for (int i = 2; i < n; i++) {
            sequence.add(sequence.get(i-2) + sequence.get(i-1));
        }
        System.out.println(sequence);
        return sequence.get(sequence.size()-1);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.findFromSequence(80));
    }
}
