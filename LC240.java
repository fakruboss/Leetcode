package fakru.leetcode;

public class LC240 {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int row = 0, col = n - 1;
    while (row < m && col >= 0) {
      if (target == matrix[row][col]) {
        return true;
      } else if (target < matrix[row][col]) {
        --col;
      } else {
        ++row;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
    System.out.println(new LC240().searchMatrix(matrix, 31));
  }
}