package fakru.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LC496 {

  public static void main(String[] args) {
    LC496Demo lc496 = new LC496Demo();
    long[] arr = {1, 4, 3, 2};
    lc496.nextLargerElement(arr, arr.length);
  }


}

class LC496Demo {

  public static long[] nextLargerElement(long[] arr, int n) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    long[] result = new long[n];
    Arrays.fill(result, -1);
    for (int i = 1; i < n; ++i) {
      while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
        result[stack.pop()] = arr[i];
      }
      stack.push(i);
    }
    return result;
  }
}