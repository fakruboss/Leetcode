package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC300 {

  public int lengthOfLIS(int[] nums) {
    int n = nums.length, max = 0;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = n - 1; i >= 0; --i) {
      for (int j = i; j < n; ++j) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  public int lengthOfLIS2(int[] nums) {
    List<Integer> result = new ArrayList<>();
    result.add(nums[0]);
    for (int i = 1; i < nums.length; ++i) {
      if (result.get(result.size() - 1) < nums[i]) {
        result.add(nums[i]);
      } else {
        int bs = Collections.binarySearch(result, nums[i]);
        result.set(bs < 0 ? -bs - 1 : bs, nums[i]);
      }
    }
    return result.size();
  }

  public static void main(String[] args) {
    int i = new LC300().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
    int i1 = new LC300().lengthOfLIS2(new int[]{0, 1, 1, 4, 3, 2});
  }
}