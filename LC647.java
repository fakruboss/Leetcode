package fakru.leetcode;

public class LC647 {

  private boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left <= right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      ++left;
      --right;
    }
    return true;
  }

  public int countSubstrings2(String s) {
    int count = 0;
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      for (int j = i; j < n; ++j) {
        if (isPalindrome(s.substring(i, j + 1))) {
          ++count;
        }
      }
    }
    return count;
  }

  private int palindromeCount(String s, int left, int right) {
    int count = 0;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      ++count;
      --left;
      ++right;
    }
    return count;
  }

  public int countSubstrings(String s) {
    int count = 0;
    for (int i = 0, n = s.length(); i < n; ++i) {
      count += palindromeCount(s, i, i);
      count += palindromeCount(s, i, i + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(new LC647().countSubstrings("aaa"));
  }
}
