package fakru.leetcode;

import java.util.Arrays;
import java.util.List;

public class LC1007 {

  public int minDominoRotations(int[] tops, int[] bottoms) {
    int result = Integer.MAX_VALUE;
    List<Integer> list = Arrays.asList(tops[0], bottoms[0]);
    for (int target : list) {
      boolean flag = false;
      int missingT = 0, missingB = 0;
      for (int i = 0; i < tops.length; ++i) {
        int top = tops[i], bottom = bottoms[i];
        if (top != target && bottom != target) {
          flag = true;
          break;
        }
        if (top != target) {
          ++missingT;
        }
        if (bottom != target) {
          ++missingB;
        }
      }
      if (!flag) {
        result = Math.min(result, Math.min(missingT, missingB));
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  public static void main(String[] args) {
    System.out.println(
        new LC1007().minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
  }
}