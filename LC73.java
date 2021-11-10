package fakru.leetcode;

public class LC73 {

  public static void main(String[] args) {
//    int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int[][] matrix = {{1, 0, 3}};
    Solution73 solution73 = new Solution73();
    solution73.setZeroes(matrix);
  }

}

class Solution73 {

  public void setZeroes(int[][] matrix) {
    boolean isZeroCol = false, isZeroRow = false;
    int m = matrix.length, n = matrix[0].length;
    for (int i = 0; i < m; ++i) {
      if (matrix[i][0] == 0) {
        isZeroCol = true;
        break;
      }
    }
    for (int i = 0; i < n; ++i) {
      if (matrix[0][i] == 0) {
        isZeroRow = true;
        break;
      }
    }
    for (int i = 1; i < m; ++i) {
      for (int j = 1; j < n; ++j) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for (int i = 1; i < m; ++i) {
      for (int j = 1; j < n; ++j) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (isZeroRow) {
      for (int i = 0; i < n; ++i) {
        matrix[0][i] = 0;
      }
    }
    if (isZeroCol) {
      for (int i = 0; i < m; ++i) {
        matrix[i][0] = 0;
      }
    }
  }
}