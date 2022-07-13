package fakru.leetcode;

public class LC38 {

  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    StringBuilder prevResult = new StringBuilder(1);
    for (int i = 2; i <= n; ++i) {
      StringBuilder result = new StringBuilder();
      int count = 1;
      for (int j = 1; j < prevResult.length(); ++j) {
        if (prevResult.charAt(j) == prevResult.charAt(j - 1)) {
          ++count;
        } else {
          result.append(count).append(prevResult.charAt(j - 1));
          count = 1;
        }
      }
      result.append(count)
          .append(prevResult.charAt(prevResult.length() - 1));
      prevResult = result;
    }
    return prevResult.toString();
  }

  public static void main(String[] args) {
    String s = new LC38().countAndSay(4);
    System.out.println(s);
  }
}