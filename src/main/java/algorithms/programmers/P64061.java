package algorithms.programmers;

import java.util.*;

public class P64061 {
  public int moveTo(int[][] board, int[] moves, int move, ArrayList<Integer> basket) {
    int tmp = 0;
    int count = 0;

    if (move >= moves.length) {
      return count;
    }

    for (int i = 0; i < board.length; i++) {
      tmp = board[i][moves[move] - 1];
      if (tmp == 0) {
        continue;
      }

      board[i][moves[move] - 1] = 0;

      if (!basket.isEmpty()) {
        if (basket.get(basket.size() - 1) == tmp) {
          count += 2;
          basket.remove(basket.size() - 1);
          break;
        }
      }
      basket.add(tmp);
      break;
    }

    count += moveTo(board, moves, move + 1, basket);

    return count;
  }

  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    ArrayList<Integer> basket = new ArrayList<Integer>();

    answer = moveTo(board, moves, 0, basket);

    return answer;
  }
}
