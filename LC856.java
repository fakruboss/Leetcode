package fakru.leetcode;

import java.util.Stack;

public class LC856 {

  public int scoreOfParentheses(String s) {
    Stack<Integer> st = new Stack<>();
    int score = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        st.push(score);
        score = 0;
      } else {
        score = st.pop() + Math.max(2 * score, 1);
      }
    }
    return score;
  }

  public static void main(String[] args) {
    int scoreOfParentheses = new LC856().scoreOfParentheses("()(()())");
    System.out.println(scoreOfParentheses);
  }
}