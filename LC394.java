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

  public String decodeString2(String s) {
    Stack<Integer> intStack = new Stack<>();
    Stack<String> stringStack = new Stack<>();
    int k = 0;
    StringBuilder curr = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        k = (k * 10) + c - '0';
      } else if (c == '[') {
        intStack.push(k);
        stringStack.push(curr.toString());
        k = 0;
        curr = new StringBuilder();
      } else if (c == ']') {
        int count = intStack.pop();
        StringBuilder temp = curr;
        curr = new StringBuilder(stringStack.pop());
        for (int i = 0; i < count; ++i) {
          curr.append(temp);
        }
      } else {
        curr.append(c);
      }
    }
    return curr.toString();
  }

  public static void main(String[] args) {
    System.out.println(new LC394().decodeString2("3[a2[c]]"));
  }
}
