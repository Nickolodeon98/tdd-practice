package algorithms.primenumber;

public class P42839 {

    interface DividerMethod {
        boolean divider(int a, int b);
    }
//    private DividerMethod dividerMethod;

    public P42839() {
    }

//    public P42839(DividerMethod dividerMethod) {
//        this.dividerMethod = dividerMethod;
//    }

    public boolean solution(int num, DividerMethod dividerMethod) {
        for (int i = 2; dividerMethod.divider(i, num); i++) {
            if (num % i == 0) return false; // 나누어 떨어지게 하는 값이 하나라도 있으면 소수가 아님
        }
        return true; // 나누어 떨어지게 하는 값이 하나도 없으면 소수임
    }

    public static void main(String[] args) {
        P42839 p42839 = new P42839();

        System.out.println(p42839.solution(35, (a, b) -> a < b));
        System.out.println(p42839.solution(17, (a, b) -> a < (b/2)));
        System.out.println(p42839.solution(19, (a, b) -> a < Math.sqrt(b)));
        System.out.println(p42839.solution(23, (a, b) -> a < b));
    }
}
