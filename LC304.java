package fakru.leetcode;

public class LC304 {

  public static void main(String[] args) {
    new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}});
  }
}

class NumMatrix {
  private int[][] matrix;
  private int m, n;

  public NumMatrix(int[][] matrix) {
    m = matrix.length;
    n = matrix[0].length;
    for (int i = 0; i < m; ++i) {
      for (int j = 1; j < n; ++j) {
        matrix[i][j] += matrix[i][j - 1];
      }
    }
    this.matrix = matrix;
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int i = row1; i <= row2; ++i) {
      int diffSum = col1 - 1 < 0 ? 0 : matrix[i][col1 - 1];
      sum += matrix[i][col2] - diffSum;
    }
    return sum;
  }
}