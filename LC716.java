package fakru.leetcode;

import java.util.Stack;

public class LC716 {

  Stack<Integer> stack;
  Stack<Integer> maxStack;

  /**
   * initialize your data structure here.
   */
  public LC716() {
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

  public static void main(String[] args) {
    LC716 maxStack = new LC716();
    maxStack.push(5);
    maxStack.peekMax();
    maxStack.popMax();
    maxStack.push(5);
    maxStack.push(1);
    maxStack.push(2);
    maxStack.push(2);
    maxStack.push(2);
    maxStack.push(6);
    System.out.println(maxStack.top());
    System.out.println(maxStack.popMax());
    System.out.println(maxStack.popMax());
  }
}