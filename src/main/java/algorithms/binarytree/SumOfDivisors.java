package algorithms.binarytree;

public class SumOfDivisors {
    public int addDivisors(int num) {
        int total = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) total += i;
        }
        return total;
    }

//    public int divideByTwo(int num) {
//        if (num == 0) return 0;
//
//        if (num % 2 == 0) {
//            return divideByTwo(num / 2) + num;
//        }
//
//        return divideByTwo(num -1);
//    }

    public static void main(String[] args) {
        SumOfDivisors sumOfDivisors = new SumOfDivisors();
        System.out.println(sumOfDivisors.addDivisors(12));
    }
}
