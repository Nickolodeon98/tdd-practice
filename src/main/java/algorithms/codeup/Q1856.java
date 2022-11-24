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
        if (n <= 0) return stairs-1;
        /* n = 5 일 때,
         * ways = 4, 1
         * ways = 3, 2
         * ways = 2, 3
         * ways = 1, 4 */
        int ways = ascendStairs(n-1, stairs + 1);

        /* n = 5 일 때,
         * */
        if (n > 1) ways += ascendStairs(n-2, stairs + 1);

        if (n > 2) ways += ascendStairs(n-3, stairs + 1);

        return ways;
    }


}
