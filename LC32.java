package fakru.leetcode;

import java.util.Stack;

public class LC32 {

  public int longestValidParentheses(String s) {
    int longest = 0, n = s.length();
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; ++i) {
      if (s.charAt(i) == '(') {
        st.push(i);
      } else {
        if (!st.isEmpty()) {
          if (s.charAt(st.peek()) == '(') {
            st.pop();
          } else {
            st.push(i);
          }
        }
        st.push(i);
      }
    }
    if (st.isEmpty()) {
      return n;
    }
    int a = n,
        b = 0;
    while (!st.isEmpty()) {
      b = st.pop();
      longest = Math.max(longest, a - b - 1);
      a = b;
    }
    return Math.max(longest, a);
  }

  public static void main(String[] args) {
    int i = new LC32().longestValidParentheses(")()())");
    System.out.println(i);
  }
}
