package fakru.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC52 {

  int count = 0;

  public int totalNQueens(int n) {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    char[][] board = new char[n][n];
    for (char[] row : board) {
      Arrays.fill(row, '.');
    }
    backtrack(0, col, posDiag, negDiag, board);
    return count;
  }

  private void backtrack(int r, Set<Integer> col, Set<Integer> posDiag,
      Set<Integer> negDiag, char[][] board) {
    if (r == board.length) {
      ++count;
    }

    for (int c = 0; c < board.length; ++c) {
      if (col.contains(c) || posDiag.contains(c) || negDiag.contains(c)) {
        continue;
      }
      col.add(c);
      posDiag.add(r + c);
      negDiag.add(r - c);
      board[r][c] = 'Q';

      backtrack(r + 1, col, posDiag, negDiag, board);

      col.remove(c);
      posDiag.remove(r + c);
      negDiag.remove(r - c);
      board[r][c] = '.';
    }
  }

  public static void main(String[] args) {
    new LC52().totalNQueens(2);
  }
}
