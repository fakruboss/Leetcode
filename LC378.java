package fakru.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

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

  public int kthSmallest2(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length, ans = -1; // For general, the matrix need not be a square
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    for (int r = 0; r < Math.min(m, k); ++r) {
      minHeap.offer(new int[]{matrix[r][0], r, 0});
    }

    for (int i = 1; i <= k; ++i) {
      int[] top = minHeap.poll();
      int r = top[1], c = top[2];
      ans = top[0];
      if (c + 1 < n) {
        minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 3, 7}, {5, 10, 12}, {6, 10, 15}};
    System.out.println(new LC378().kthSmallest2(matrix, 4));
  }

}
