package algorithms.primenumber;

public class P42839 {

    interface DividerMethod {
        boolean divider(int a, int b);
    }
    private DividerMethod dividerMethod;

    public P42839() {
    }

    public P42839(DividerMethod dividerMethod) {
        this.dividerMethod = dividerMethod;
    }

    public static void main(String[] args) {
        P42839 p42839First = new P42839((a, b)-> a < b);
        P42839 p42839Second = new P42839((a, b)-> a < (b/2));
        P42839 p42839Third = new P42839((a, b)-> a < Math.sqrt(b));

        System.out.println(p42839First.solution(35));
        System.out.println(p42839Second.solution(17));
        System.out.println(p42839Third.solution(19));
        System.out.println(p42839First.solution(23));
    }

    public boolean solution(int num) {
        for (int i = 2; dividerMethod.divider(i, num); i++) {
            if (num % i == 0) return false; // 나누어 떨어지게 하는 값이 하나라도 있으면 소수가 아님
        }
        return true; // 나누어 떨어지게 하는 값이 하나도 없으면 소수임
    }

}
