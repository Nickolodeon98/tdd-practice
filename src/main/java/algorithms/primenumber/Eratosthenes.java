package algorithms.primenumber;

import java.time.chrono.Era;

public class Eratosthenes {
    public int eratosthenes(int N) {
        int[] arr = new int[N-1];
        // 2부터 N 까지의 숫자가 들어있는 배열 생성
        for (int i = 2; i <= N; i++) {
            arr[i-2] = i;
        }
        boolean[] checks = new boolean[N-1];
        for (int j = 0; j < checks.length; j++) {
            if (arr[j] > 2 && arr[j] % 2 == 0) checks[j] = false;
        }

        int cnt = 0;
        for (int k = 0; k < checks.length; k++) {
            if (checks[k]) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Eratosthenes eratosthenes = new Eratosthenes();
        System.out.println(eratosthenes.eratosthenes(50));
    }
}
