package fakru.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class LC36 {

  public static void main(String[] args) {
    char[][] board = {
        {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
        {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
    boolean validSudoku = new LC36().isValidSudoku(board);
    System.out.println(validSudoku);
  }

  public boolean isValidSudoku(char[][] board) {
    Map<Integer, Set<Character>> rows = new HashMap<>();
    Map<Integer, Set<Character>> cols = new HashMap<>();
    Map<String, Set<Character>> squares = new HashMap<>();

    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[0].length; ++j) {
        if (board[i][j] == '.') {
          continue;
        }

        String index = i / 3 + String.valueOf(j / 3);
        Set<Character> row = rows.computeIfAbsent(i, temp -> new HashSet<>());
        Set<Character> col = cols.computeIfAbsent(j, temp -> new HashSet<>());
        Set<Character> square = squares.computeIfAbsent(index, temp -> new HashSet<>());

        if (row.contains(board[i][j])
            || col.contains(board[i][j])
            || square.contains(board[i][j])) {
          return false;
        }

        rows.get(i).add(board[i][j]);
        cols.get(j).add(board[i][j]);
        squares.get(index).add(board[i][j]);
      }
    }
    return true;
  }
}