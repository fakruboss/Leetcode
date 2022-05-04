package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC279 {

  public int numSquares(int n) {
    List<Integer> nums = new ArrayList<>();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= n; ++i) {
      nums.add(i * i);
    }
    for (int num : nums) {
      for (int i = num; i <= n; ++i) {
        dp[i] = Math.min(dp[i], dp[i - num] + 1);
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(new LC279().numSquares(12));
  }
}
