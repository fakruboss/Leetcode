package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC51 {

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    char[][] board = new char[n][n];
    for (char[] row : board) {
      Arrays.fill(row, '.');
    }

    backtrack(0, col, posDiag, negDiag, board, result);
    return result;
  }

  private void backtrack(int r, Set<Integer> col, Set<Integer> posDiag,
      Set<Integer> negDiag, char[][] board,
      List<List<String>> result) {
    if (r == board.length) {
      List<String> curr = new ArrayList<>();
      for (char[] row : board) {
        StringBuilder sb = new StringBuilder();
        for (char c : row) {
          sb.append(c);
        }
        curr.add(sb.toString());
      }
      result.add(curr);
    }

    for (int c = 0; c < board.length; ++c) {
      if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
        continue;
      }
      col.add(c);
      posDiag.add(r + c);
      negDiag.add(r - c);
      backtrack(r + 1, col, posDiag, negDiag, board, result);
      col.remove(c);
      posDiag.remove(r + c);
      negDiag.remove(r - c);
    }
  }
}
