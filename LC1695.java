package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1695 {

  public int maximumUniqueSubarray(int[] nums) {
    int max = Integer.MIN_VALUE,
        total = 0,
        currSum = 0;

    int[] prefixSum = new int[nums.length];
    prefixSum[0] = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      prefixSum[i] = nums[i] + prefixSum[i - 1];
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int start = 0, end = 0; end < nums.length; ++end) {
      total += nums[end];
      currSum += nums[end];
      if (map.containsKey(nums[end])) {
        start = Math.max(start, 1 + map.get(nums[end]));
        currSum = total - prefixSum[start - 1];
      }
      map.put(nums[end], end);
      max = Math.max(max, currSum);
    }
    return max;
  }

  public static void main(String[] args) {
    int i = new LC1695().maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5});
    System.out.println(i);
  }
}
