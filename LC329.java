package fakru.leetcode;

import static fakru.leetcode.utils.PrintUtils.print;

/**
 * DP problem. Store the max value that is possible from each cell in a resultant matrix. Do a DFS
 * for traversing. If that cell has already been seen, value can be taken from the resultant matrix,
 * else, process and store it. For the result, find the max in the resultant matrix which can be
 * computed while traversing itself
 */
public class LC329 {

  public int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length, result = 0;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        result = Math.max(result, dfs(i, j, m, n, matrix, dp, Integer.MIN_VALUE));
      }
    }
    return result;
  }

  private int dfs(int i, int j, int m, int n, int[][] mat, int[][] dp, int prev) {
    if (i < 0 || i >= m || j < 0 || j >= n || mat[i][j] <= prev) {
      return 0;
    }
    if (dp[i][j] != 0) {
      return dp[i][j];
    }
    int result = 1;
    result = Math.max(result, 1 + dfs(i + 1, j, m, n, mat, dp, mat[i][j]));
    result = Math.max(result, 1 + dfs(i - 1, j, m, n, mat, dp, mat[i][j]));
    result = Math.max(result, 1 + dfs(i, j + 1, m, n, mat, dp, mat[i][j]));
    result = Math.max(result, 1 + dfs(i, j - 1, m, n, mat, dp, mat[i][j]));
    dp[i][j] = result;
    return result;
  }

  public static void main(String[] args) {
    print(new LC329().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
  }
}
