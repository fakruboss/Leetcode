package fakru.leetcode;

import java.util.Stack;

class Pairr {

  public Character c;
  public int count;

  public Pairr(Character c, int count) {
    this.c = c;
    this.count = count;
  }
}

public class LC1209 {

  public String removeDuplicates(String s, int k) {
    Stack<Pairr> stack = new Stack<>();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      int count = stack.isEmpty() || stack.peek().c != c ? 1 : stack.pop().count + 1;
      stack.push(new Pairr(c, count));
      if (stack.peek().count == k) {
        stack.pop();
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Pairr p : stack) {
      sb.append(String.valueOf(p.c).repeat(Math.max(0, p.count)));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String result = new LC1209().removeDuplicates("aabbcaaaccbba", 3);
    System.out.println(result);
  }
}
