package fakru.leetcode;

import java.util.Arrays;

public class LC322 {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        if (dp[i - coin] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    System.out.println(new LC322().coinChange(new int[]{1, 2, 5}, 11));
  }
}