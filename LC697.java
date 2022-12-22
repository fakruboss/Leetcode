package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC697 {

  public static void main(String[] args) {
    int shortestSubArray = new LC697().findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2});
    System.out.println(shortestSubArray);
  }

  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, int[]> numLen = new HashMap<>();
    int maxFreq = 0;
    int shortestLen = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; ++i) {
      int num = nums[i];
      if (freq.containsKey(num)) {
        freq.put(num, freq.get(num) + 1);
        numLen.get(num)[1] = i;
      } else {
        freq.put(num, 1);
        numLen.put(num, new int[]{i, i});
      }
      if (freq.get(num) > maxFreq) {
        maxFreq = freq.get(num);
        shortestLen = numLen.get(num)[1] - numLen.get(num)[0] + 1;
      } else if (freq.get(num) == maxFreq) {
        int len = numLen.get(num)[1] - numLen.get(num)[0] + 1;
        shortestLen = Math.min(shortestLen, len);
      }
    }
    return shortestLen;
  }
}
