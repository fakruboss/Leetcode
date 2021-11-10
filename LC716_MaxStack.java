package fakru.leetcode;

import java.util.Stack;

public class LC716_MaxStack {

  Stack<Integer> stack;
  Stack<Integer> maxStack;

  /**
   * initialize your data structure here.
   */
  public LC716_MaxStack() {
    stack = new Stack<>();
    maxStack = new Stack<>();
  }

  public void push(int x) {
    pushHelper(x);
  }

  public void pushHelper(int x) {
    int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
    if (x > tempMax) {
      tempMax = x;
    }
    stack.push(x);
    maxStack.push(tempMax);
  }

  public int pop() {
    maxStack.pop();
    return stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return maxStack.peek();
  }

  public int popMax() {
    int max = maxStack.peek();
    Stack<Integer> temp = new Stack<>();

    while (stack.peek() != max) {
      temp.push(stack.pop());
      maxStack.pop();
    }
    stack.pop();
    maxStack.pop();
    while (!temp.isEmpty()) {
      int x = temp.pop();
      pushHelper(x);
    }
    return max;
  }
}

class LC716_MaxStackDemo {

  public static void main(String[] args) {
    LC716_MaxStack lc716_maxStack = new LC716_MaxStack();
    lc716_maxStack.push(5);
    lc716_maxStack.peekMax();
    lc716_maxStack.popMax();
    lc716_maxStack.push(5);
    lc716_maxStack.push(1);
    lc716_maxStack.push(2);
    lc716_maxStack.push(2);
    lc716_maxStack.push(2);
    lc716_maxStack.push(6);
    System.out.println(lc716_maxStack.top());
    System.out.println(lc716_maxStack.popMax());
    System.out.println(lc716_maxStack.popMax());
  }
}