package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC378 {

  private void insertElement(int[] result, int num, int left, int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (num == result[mid]) {
        result[mid + 1] = num;
      } else if (num > result[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int[] result = new int[n * n];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        insertElement(result, matrix[i][j], 0, n * n);
      }
    }
    return result[k - 1];
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    System.out.println(new LC378().kthSmallest(matrix, 8));
  }

}
