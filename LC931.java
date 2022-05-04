package fakru.leetcode;

/**
 * Typical 2D dp problem. for each value in the row, store the minimum possible value obtained from
 * possible direction. In this problem, it is top, top left and top right since we are following
 * bottom up approach. After each element, check if it's the minimum possible value. Make sure that,
 * during the traversal of each new row, the value is reset. This is done so that after the last
 * row, since, this won't be reset, we will be able to return the min value without any further
 * traversal
 */
public class LC931 {

  public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length, result = Integer.MAX_VALUE;
    for (int i = 1; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        int topLeft = j == 0 ? Integer.MAX_VALUE : matrix[i - 1][j - 1];
        int topRight = j == n - 1 ? Integer.MAX_VALUE : matrix[i - 1][j + 1];
        matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(topLeft, topRight));
      }
    }
    for (int i = 0; i < n; ++i) {
      result = Math.min(result, matrix[m - 1][i]);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LC931().minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
  }
}
