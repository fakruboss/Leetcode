package fakru.leetcode;

public class LC62 {

  public int uniquePaths(int m, int n) {
    int[][] paths = new int[m][n];
    paths[0][0] = 1;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (i == 0 && j == 0) {
          continue;
        }
        int fromTop = i - 1 < 0 ? 0 : paths[i - 1][j];
        int fromLeft = j - 1 < 0 ? 0 : paths[i][j - 1];
        paths[i][j] = fromTop + fromLeft;
      }
    }
    return paths[m - 1][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(new LC62().uniquePaths(3, 3));
  }
}
