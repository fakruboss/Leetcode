package fakru.leetcode;

public class LC6101 {

  public boolean checkXMatrix(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        boolean isDiagonal = j == i || j == m - i - 1;
        if (isDiagonal) {
          if (grid[i][j] == 0) {
            return false;
          }
        } else {
          if (grid[i][j] != 0) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    LC6101 lc6101 = new LC6101();
    boolean b = lc6101.checkXMatrix(
        new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}});
    System.out.println(b);
  }
}
