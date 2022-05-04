package fakru.leetcode;

public class LC214 {

  public String shortestPalindrome(String s) {
    String revS = new StringBuilder(s).reverse().toString();
    String fullStr = s + revS;
    String prefix = findLongestPrefix(fullStr);
    prefix = revS.replace(prefix, "");
    return prefix + s;
  }

  private String findLongestPrefix(String s) {
    String result = "";
    int index = 1, n = s.length();
    while (index < n / 2) {
      String fromStart = s.substring(0, index);
      String fromEnd = s.substring(n - index);
      if (fromStart.equals(fromEnd)) {
        result = fromStart;
      }
      ++index;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LC214().shortestPalindrome("a"));
  }
}