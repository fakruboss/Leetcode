package fakru.leetcode;

public class LC96 {

  public int numTrees(int n) {
    if (n <= 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= i; ++j) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(new LC96().numTrees(19));
  }
}
