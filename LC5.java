package fakru.leetcode;

public class LC5 {

  private boolean isPalindrome(StringBuilder s) {
    for (int i = 0, n = s.length(); i < n / 2; ++i) {
      if (s.charAt(i) != s.charAt(n - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public String longestPalindrome(String s) {
    int n = s.length();
    String maxString = "";
    for (int i = 0; i < n; ++i) {
      StringBuilder sb = new StringBuilder();
      if (isPalindrome(sb.append(s.charAt(i))) && sb.length() > maxString.length()) {
        maxString = sb.toString();
      }
      for (int j = i + 1; j < n; ++j) {
        if (isPalindrome(sb.append(s.charAt(j))) && sb.length() > maxString.length()) {
          maxString = sb.toString();
        }
      }
    }
    return maxString;
  }

  private String getMaxString(String s, int left, int right, String maxString) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      if (right - left + 1 > maxString.length()) {
        maxString = s.substring(left, right + 1);
      }
      --left;
      ++right;
    }
    return maxString;
  }

  public String longestPalindrome2(String s) {
    int n = s.length();
    String maxString = "";
    for (int i = 0; i < n; ++i) {
      // odd length computation
      maxString = getMaxString(s, i, i, maxString);

      // even length computation
      maxString = getMaxString(s, i, i + 1, maxString);
    }
    return maxString;
  }

  public static void main(String[] args) {
    System.out.println(new LC5().longestPalindrome2("baab"));
  }
}
