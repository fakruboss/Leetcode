package fakru.leetcode;

import java.util.Stack;

public class LC402 {

  public String removeKdigits(String num, int k) {
    Stack<Character> stack = new Stack<>();
    int i = 0;
    while (i < num.length()) {
      char c = num.charAt(i);
      while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
        stack.pop();
        --k;
      }
      stack.push(c);
      ++i;
    }
    StringBuilder result = new StringBuilder();
    for (int j = 0, n = stack.size(); j < n - k; ++j) {
      if (result.length() == 0 && stack.get(j) == '0') {
        continue;
      }
      result.append(stack.get(j));
    }
    result.append(num.substring(i));
    return result.length() == 0 ? "0" : result.toString();
  }

  public static void main(String[] args) {
    System.out.println(new LC402().removeKdigits("9", 1));
  }
}