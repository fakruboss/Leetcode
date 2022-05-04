package fakru.leetcode;

public class LC44 {

  public boolean isMatch(String s, String p) {
    StringBuilder sb = new StringBuilder(p);
    for (int i = 1; i < sb.length(); ++i) {
      if (sb.charAt(i) == '*' && sb.charAt(i) == sb.charAt(i - 1)) {
        sb.deleteCharAt(i);
        --i;
      }
    }
    p = sb.toString();
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    if (n > 0 && p.charAt(0) == '*') {
      dp[0][1] = true;
    }
    for (int i = 1; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (p.charAt(j - 1) == '?'
            || s.charAt(i - 1) == p.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        }
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    boolean match = new LC44().isMatch("a", "");
    System.out.println(match);
  }
}