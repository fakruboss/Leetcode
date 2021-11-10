package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC560 {

  public int subArraySum(int[] nums, int k) {
    int count = 0;
    int prefixSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int num : nums) {
      prefixSum += num;
      if (map.containsKey(prefixSum - k)) {
        count += map.get(prefixSum - k);
      }
      map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
  }

  public int subArraySum2(int[] nums, int k) {
    int n = nums.length;
    int count = 0;
    for (int i = 0; i < n; ++i) {
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

  public static void main(String[] args) {
    System.out.println(new LC560().subArraySum(new int[]{1, 2, 3}, 3));
    System.out.println(new LC560().subArraySum2(new int[]{1, 2, 3}, 3));
  }
}