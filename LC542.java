package fakru.leetcode;

public class LC542 {

  public static void main(String[] args) {
    int[][] mat = {{0,0,0},{}};
  }

  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    int[][] dp = new int[m][n];
    for (int i = 1; i < m; ++i) {
      if (mat[i][0] == 0) {
        continue;
      }
      dp[i][0] = mat[i - 1][0] == 0 ? 1 : 1 + dp[i - 1][0];
    }
    for (int j = 1; j < n; ++j) {
      if (mat[0][j] == 0) {
        continue;
      }
      dp[0][j] = mat[0][j - 1] == 0 ? 1 : 1 + dp[0][j - 1];
    }
    for (int i = 1; i < m; ++i) {
      for (int j = 1; j < n; ++j) {
        if (mat[i - 1][j] == 0 || mat[i][j - 1] == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp;
  }
}
