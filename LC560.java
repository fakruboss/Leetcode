package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC560 {

  // SOLUTION 1 : Brute force
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    for (int i = 0, n = nums.length; i < n; ++i) {
      int currSum = nums[i];
      if (currSum == k) {
        ++count;
      }
      for (int j = i + 1; j < n; ++j) {
        currSum += nums[j];
        if (currSum == k) {
          ++count;
        }
      }
    }
    return count;
  }

  // SOLUTION 2 : Prefix sum + Hashmap
  public int subarraySum2(int[] nums, int k) {
    int count = 0, currSum = 0;
    Map<Integer, Integer> prefixSum = new HashMap<>();
    for (int num : nums) {
      currSum += num;
      if (currSum == k) {
        ++count;
      }
      count += prefixSum.getOrDefault(currSum - k, 0);
      prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(new LC560().subarraySum2(new int[]{1, 2, 3}, 3));
  }
}