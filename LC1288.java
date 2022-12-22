package fakru.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC1288 {

  public static void main(String[] args) {
    int[][] intervals = {{1, 4}, {3, 6}, {2, 8}, {2, 4}, {3, 7}, {6, 8}, {5, 6}};
    int i = new LC1288().removeCoveredIntervals(intervals);
    System.out.println(i);
  }

  public int removeCoveredIntervals(int[][] intervals) {
    int size = intervals.length;
    Arrays.sort(intervals, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
    for (int i = 0, j = 1; j < intervals.length;) {
      int[] currInterval = intervals[i];
      int[] nextInterval = intervals[j];
      if (currInterval[0] <= nextInterval[0] && currInterval[1] >= nextInterval[1]) {
        nextInterval[0] = -1;
        --size;
        ++j;
      }
    }
    return size;
  }
}