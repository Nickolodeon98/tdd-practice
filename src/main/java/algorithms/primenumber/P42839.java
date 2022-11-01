package algorithms.primenumber;

public class P42839 {
    public static void main(String[] args) {
        P42839 p42839 = new P42839();
        System.out.println(p42839.solution(13));
        System.out.println(p42839.solution(17));
        System.out.println(p42839.solution(19));
        System.out.println(p42839.solution(23));
    }

    public boolean solution(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) return false; // 나누어 떨어지게 하는 값이 하나라도 있으면 소수가 아님
        }
        return true; // 나누어 떨어지게 하는 값이 하나도 없으면 소수임
    }
}
