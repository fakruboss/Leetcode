package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC54 {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; ++i) {
        result.add(matrix[top][i]);
      }
      ++top;

      for (int i = top; i <= bottom; ++i) {
        result.add(matrix[i][right]);
      }
      --right;

      if (left > right || top > bottom) {
        break;
      }

      for (int i = right; i >= left; --i) {
        result.add(matrix[bottom][i]);
      }
      --bottom;

      for (int i = bottom; i >= top; --i) {
        result.add(matrix[i][left]);
      }
      ++left;
    }
    return result;
  }

  public static void main(String[] args) {
//    int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//    int[][] mat = {{1, 2, 3}};
    int[][] mat = {{1, 2}, {3, 4}};
    List<Integer> result = new LC54().spiralOrder(mat);
    for (int num : result) {
      System.out.print(num + " ");
    }
  }
}