package fakru.leetcode;

import java.util.LinkedList;

public class LC57 {
  public int[][] insert(int[][] oldIntervals, int[] newInterval) {
    int n = oldIntervals.length;
    LinkedList<int[]> merged = new LinkedList<>();
    int[][] intervals = new int[n + 1][];
    boolean isInserted = false;
    for (int i = 0, j = 0; i < n + 1; ++i) {
      if (!isInserted && (n == 0 || j == n || newInterval[0] < oldIntervals[j][0])) {
        intervals[i] = newInterval;
        isInserted = true;
      } else {
        intervals[i] = oldIntervals[j++];
      }
    }

    for (int[] interval : intervals) {
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      } else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
}