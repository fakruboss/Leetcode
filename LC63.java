package fakru.leetcode;

public class LC63 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[] prev = new int[n];
    for (int i = 0; i < n; ++i) {
      if (obstacleGrid[0][i] == 1) {
        break;
      }
      prev[i] = 1;
    }
    int[] curr = new int[n];
    for (int i = 1; i < m; ++i) {
      curr[0] = obstacleGrid[i][0] == 1 ? 0 : prev[0];
      for (int j = 1; j < n; ++j) {
        curr[j] = obstacleGrid[i][j] == 1 ? 0 : curr[j - 1] + prev[j];
      }
      prev = curr;
    }
    return prev[n - 1];
  }

  public static void main(String[] args) {
    int[][] max = {{1}, {0}};
    int i = new LC63().uniquePathsWithObstacles(max);
    System.out.println(i);
  }
}
