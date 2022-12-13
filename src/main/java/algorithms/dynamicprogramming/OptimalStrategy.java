package algorithms.dynamicprogramming;

import java.util.Arrays;

public class OptimalStrategy {

    class Duple {
        int support;
        int enemy;

        public Duple() {
            this.support = 0;
            this.enemy = 0;
        }


        public void setSupport(int support) {
            this.support = support;
        }

        public void setEnemy(int enemy) {
            this.enemy = enemy;
        }

        @Override
        public String toString() {
            return "("+
                    support + ", "
                    + enemy +
                    ")";
        }
    }

    public void buildMatrix() {
        Duple[][] gameBoard = new Duple[4][4]; // Duple 네 개로 이루어진 행이 네 개가 있다. 아군과 적군의 점수가 적힌 게임 점수판을 나타낸다.

        /* 향상된 for 문은 set 능력은 결여되어 있다. get 능력만 갖고 있기 때문에 배열을 초기화할 때는 적당한 반복문 형식이 아니다. */
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = new Duple();
            }
        }

        int[] columns = {2, 7, 40, 19};

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (i == j) { // 만약 숫자가 하나밖에 없으면
                    gameBoard[i][j].setSupport(columns[i]); // 내가 먼저 게임을 시작하므로 아군은 숫자를 가져오고
                    gameBoard[i][j].setEnemy(0); // 적군은 숫자를 가져오지 못한다.
                }
                if (j - i == 1) { // 만약 숫자가 단 두 개라면
                    gameBoard[i][j].setSupport(Math.max(columns[i], columns[j])); // 둘 중에 큰 수(가장 큰 수)를 아군이 가져오고
                    gameBoard[i][j].setEnemy(Math.min(columns[i], columns[j])); // 나머지 (가장 작은 수)를 적군이 가져온다
                }
            }
        }

        for (Duple[] dupleGroup : gameBoard) {
            System.out.println(Arrays.toString(dupleGroup));
        }
    }

    public static void main(String[] args) {
        OptimalStrategy optimalStrategy = new OptimalStrategy();
        optimalStrategy.buildMatrix();
    }
}
