package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC91 {

  private Map<Integer, Integer> memo = new HashMap<>();

  private int numDecodings(String s, int position) {
    if (memo.get(position) != null) {
      return memo.get(position);
    }
    if (s.charAt(position) == 0) {
      return 0;
    }
    int res = numDecodings(s, position + 1);
    if (position < s.length() - 1 && (s.charAt(position) == '1' || (s.charAt(position) == '2'
        && s.charAt(position + 1) < '7'))) {
      res += numDecodings(s, position + 2);
    }
    return res;
  }

  public int numDecodings(String s) {
    memo.put(s.length(), 1);
    return numDecodings(s, 0);
  }

  public static void main(String[] args) {
    System.out.println(new LC91().numDecodings("0"));
  }
}
