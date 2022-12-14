package algorithms.dynamicprogramming;

import java.util.Arrays;

public class OptimalStrategyInProgress {

    class State {
        int mine;
        int yours;

        public State(int mine, int yours) {
            this.mine = mine;
            this.yours = yours;
        }

        @Override
        public String toString() {
            return "(" +
                    mine +
                    ", " + yours +
                    ')';
        }
    }

    public void storeEdges() {
        int[] columns = {2, 7, 40, 19};

        State[][] cache = new State[columns.length][columns.length];

        for (int i = 0; i < cache.length; i++) {
            for (int j = i; j < cache[i].length; j++) {
                if (j == i) {
                    cache[i][j] = new State(columns[i], 0);
                    System.out.println(cache[i][j]);
                    continue;
                }
                cache[i][j] = new State(columns[i], columns[j]);
                System.out.println(cache[i][j]);
            }
        }

//        for (int i = 1; i < cache.length; i++) { // 행
//            for (int j = 0; j < cache[i].length; j++) { // 열
//                int left = columns[j];
//                int right = columns[j+i];
//                cache[i][j] = new State(left, right);
//                System.out.println(cache[i][j]);
//            }
//        }

//        for (State[] states : cache) {
//            System.out.println(Arrays.toString(states));
//        }
    }

    public void dummyMethod() {
        int[] columns = {2, 7, 40, 19};

        State[][] cache = new State[columns.length][columns.length];

        for (int i = 1; i < cache.length; i++) { // 행
            for (int j = 0; j < cache[i].length - i; j++) { // 열
                int left = columns[j];
                int right = columns[j+i];
                cache[i][j] = new State(left, right);
                System.out.println(cache[i][j]);
            }
        }

//        for (State[] states : cache) {
//            System.out.println(Arrays.toString(states));
//        }
    }

    public static void fillMatrix() {
        int[] columns = {2, 7, 40, 19};

        int[][] memo = new int[columns.length][columns.length];

        for (int i = 0; i < memo.length; i++) {
            for (int j = i; j < memo[i].length; j++) {
                if (j == 0) {
                    memo[i][j] = columns[i];
                    continue;
                }
                memo[i][j] = memo[i][j - 1] + columns[j];
            }
        }

        for (int[] row : memo) {
            System.out.println(Arrays.toString(row));
        }

    }

    public static void main(String[] args) {
//        fillMatrix();

        OptimalStrategyInProgress optimalStrategyInProgress = new OptimalStrategyInProgress();
        optimalStrategyInProgress.storeEdges();
        System.out.println("----------------");
        optimalStrategyInProgress.dummyMethod();
    }

}
