package fakru.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC282 {

  public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<>();
    int currNum = Integer.parseInt(String.valueOf(num.charAt(0)));
    StringBuilder sb = new StringBuilder(String.valueOf(currNum));
    backtrack(num.substring(1), target, currNum, result, sb);
    return result;
  }

  private void backtrack(String num, int target, int currTotal, List<String> result,
      StringBuilder sb) {
    if (num.isEmpty()) {
      if (currTotal == target) {
        result.add(sb.toString());
      }
      return;
    }
    int currNum = Integer.parseInt(String.valueOf(num.charAt(0)));

    backtrack(num.substring(1), target, currTotal + currNum, result,
        sb.append("+").append(currNum));
    sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);

    backtrack(num.substring(1), target, currTotal - currNum, result,
        sb.append("-").append(currNum));
    sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);

    backtrack(num.substring(1), target, currTotal * currNum, result,
        sb.append("*").append(currNum));
    sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
  }

  public static void main(String[] args) {
    System.out.println(new LC282().addOperators("3456237490", 9191));
  }
}
