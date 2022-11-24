package algorithms.codeup;

public class Q1856 {
    /* This requires a selection of options. Each number of stairs,
     * 1, 2, 3, is determined by a number given, judging how many of each number of stairs sums up to that number.
     * Count the number of repetition as long as base case is not met. */

    public int stairOptions(int n, int stairs) { // e.g. n = 5, stairs = 0
        if (n == 0) return 0;
        if (n == 2 || n == 3) stairs++;

        int one = stairOptions(1, stairs) + stairOptions(n-1, stairs);
        /* stairOptions(1, 1) + stairOptions(4, 1)
         * stairOptions(1, 2) + stairOptions(1, 2) + stairOptions(3, 2)
         * stairOptions(1, 3) + stairOptions(1, 3) + stairOptions(1, 3) + stairOptions(2, 3)
         * stairOptions(1, 4) + stairOptions(1, 4) + stairOptions(1, 4) + stairOptions(1, 4) + stairOptions(1, 4)
         * */

        int two = stairOptions(2, stairs) +stairOptions(n-2, stairs);
        /* stairOptions(2, 0) + stairOptions(3, 0)
         * stairOptions(2, 0) + stairOptions(2, 0) + stairOptions(1, 0) */

        int three = stairOptions(3, stairs) + stairOptions(n-3, stairs);
        /* stairOptions(3, 0) + stairOptions(2, 0) */
        return 0;
    }

    public int ascendStairs(int n, int stairs) {
        int ways = ascendStairsWithOne(n, stairs);
        if (n > 2) ways += ascendStairsWithTwo(n, stairs);
        if (n > 3) ways += ascendStairsWithThree(n, stairs);
        return ways;
    }
//    public int finalStairsClimbing(int n, int stairs) {
//        if (n <= 0) return stairs;
//        stairs++;
//        int ways = finalStairsClimbing(n-1, stairs); // 중간 중간 ways 에 더해지는 불필요한 값들은 어떻게 처리하는가?
//        ways += finalStairsClimbing(n-2, stairs= 0);
//        ways += finalStairsClimbing(n-3, stairs= 0);
//        return ways;
//    }
    public int ascendStairsWithOne(int n, int stairs) {
        if (n == 0) return stairs;
        if (n < 0) return stairs-1;
        /* n = 5 일 때,
         * ways = 4, 1
         * ways = 3, 2
         * ways = 2, 3
         * ways = 1, 4 */
        stairs++;
        return ascendStairsWithOne(n-1, stairs); // ways 를 센다. 여기서 4로 가면서 stairs 는 1이 된다.
                                                                // 현재 stairs 는 1인데 3으로 가면서 2가 된다.
    }

    public int ascendStairsWithTwo(int n, int stairs) {
        if (n == 0) return stairs;
        if (n < 0) return stairs-1;

        /* n = 5 일 때,
         * ways = 1 + 1 + 1*/
        stairs++;
        return ascendStairsWithTwo(n-2, stairs); // 여기서 3으로 가면서 stairs 는 1이 된다.
                                                                    // 현재 stairs 는 1인데 1로 가면서 2가 된다.
                                                                        // ways = 2 로 리턴된다.
    }

    public int ascendStairsWithThree(int n, int stairs) {
        if (n == 0) return stairs;
        if (n < 0) return stairs-1;
        /* n = 5 일 때,
         * ways = 1 + 1 + 1*/
        stairs++;
        return ascendStairsWithThree(n-3, stairs); // 여기서 2 로 가면서 stairs 는 1이 된다.
                                                                    // ways = 1 로 리턴된다.
    }

    public static void main(String[] args) {
        Q1856 q1856 = new Q1856();
        System.out.println(q1856.ascendStairs(2, 0));
//        System.out.println(q1856.finalStairsClimbing(5, 0));
    }
}
