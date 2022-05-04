package fakru.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC1094 {

  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, Comparator.comparingInt(trip -> trip[1]));
    for (int i = 1; i < trips.length; ++i) {
      if (trips[i - 1][0] > capacity || trips[i][0] > capacity) {
        return false;
      }
      if (trips[i][1] < trips[i - 1][2] && trips[i][0] + trips[i - 1][0] > capacity) {
        return false;
      }
    }
    for (int[] trip : trips) {
      System.out.println(Arrays.toString(trip));
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new LC1094().carPooling(new int[][]{{3, 3, 7}, {1, 2, 3}, {2, 1, 5}}, 4));
  }
}
