package fakru.leetcode;

public class LC583 {

  /**
   * The reason why frequency way doesn't work here is because of the ordering. Eg : "sea" & "ate".
   * In the freq way, the output will be 2, since, it just deletes s from string1 & t from string2
   * and considers them to be equal. But, it is not the case, since, 'ea' is not equal to 'ae'.
   * Hence, we have to delete the characters keeping the string order in mind
   */
  public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    int i = dp[m - 1][n - 1];
    return m - i + n - i;
  }

  public static void main(String[] args) {
    int i = new LC583().minDistance("leetcode", "etco");
    System.out.println(i);
  }
}
