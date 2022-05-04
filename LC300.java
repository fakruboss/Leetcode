package fakru.leetcode;

import java.util.Arrays;

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

  public static void main(String[] args) {
    new LC300().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
  }
}