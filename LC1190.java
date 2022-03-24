package fakru.leetcode;

import static fakru.leetcode.utils.PrintUtils.print;

import java.util.Stack;

public class LC1190 {

  public String reverseParentheses(String s) {
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    int strLen = s.length();
    for (int i = 0; i < strLen; i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(sb.length());
      } else if (c == ')') {
        int startIndex = stack.pop();
        int endIndex = sb.length() - 1;
        StringBuilder temp = new StringBuilder();
        for (int j = endIndex; j >= startIndex; j--) {
          temp.append(sb.charAt(j));
          sb.deleteCharAt(j);
        }
        sb.append(temp);
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    print(new LC1190().reverseParentheses("(ed(et(oc))el)"));
  }
}