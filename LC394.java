package fakru.leetcode;

import java.util.Stack;

public class LC394 {

  public String decodeString(String s) {
    StringBuilder curr = new StringBuilder();
    Stack<String> strStack = new Stack<>();
    Stack<Integer> intStack = new Stack<>();
    int k = 0;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        k = (k * 10) + c - '0';
      } else if (c == '[') {
        strStack.push(curr.toString());
        intStack.push(k);
        curr = new StringBuilder();
        k = 0;
      } else if (c == ']') {
        StringBuilder temp = curr;
        curr = new StringBuilder(strStack.pop());
        for (k = intStack.pop(); k > 0; --k) {
          curr.append(temp);
        }
      } else {
        curr.append(c);
      }
    }
    return curr.toString();
  }

  public static void main(String[] args) {
    System.out.println(new LC394().decodeString("3[a2[c]]"));
  }
}
