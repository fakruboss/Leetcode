package fakru.leetcode;

public class LC79 {

  private boolean isWordExist(char[][] board, int i, int j, int m, int n,
      String word, int wordIdx) {
    if (wordIdx == word.length()) {
      return true;
    }
    if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(wordIdx)) {
      return false;
    }
    board[i][j] = '#';
    boolean result = isWordExist(board, i - 1, j, m, n, word, wordIdx + 1)
        || isWordExist(board, i + 1, j, m, n, word, wordIdx + 1)
        || isWordExist(board, i, j - 1, m, n, word, wordIdx + 1)
        || isWordExist(board, i, j + 1, m, n, word, wordIdx + 1);
    board[i][j] = word.charAt(wordIdx);
    return result;
  }

  public boolean exist(char[][] board, String word) {
    int m = board.length, n = board[0].length, wordIdx = 0;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (isWordExist(board, i, j, m, n, word, wordIdx)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    System.out.println(new LC79().exist(board, "ABCCED"));
  }
}
