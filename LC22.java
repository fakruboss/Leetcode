package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC22 {

  private void generateParenthesis(List<String> result, StringBuilder sb, int open, int close,
      int n) {
    if (sb.length() == 2 * n) {
      result.add(sb.toString());
    }
    if (open < n) {
      generateParenthesis(result, sb.append('('), open + 1, close, n);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (close < open) {
      generateParenthesis(result, sb.append(')'), open, close + 1, n);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generateParenthesis(result, new StringBuilder(), 0, 0, n);
    return result;
  }

  public static void main(String[] args) {
    LC22 lc22 = new LC22();
    long totalTime = 0;
    for (int i = 0; i < 5; ++i) {
      long startTime = System.currentTimeMillis();
      List<String> list = lc22.generateParenthesis(15);
      totalTime += System.currentTimeMillis() - startTime;
    }
    System.out.println(totalTime / 5);
  }
}