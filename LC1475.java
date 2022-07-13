package fakru.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC1475 {

  public int[] finalPrices(int[] prices) {
    int n = prices.length;
    int[] result = new int[n];
    System.arraycopy(prices, 0, result, 0, n);
    for (int i = 0; i < n - 1; ++i) {
      for (int j = i + 1; j < n; ++j) {
        if (prices[j] <= prices[i]) {
          result[i] = prices[i] - prices[j];
          break;
        }
      }
    }
    return result;
  }

  public int[] finalPrices2(int[] prices) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);
    int[] result = new int[prices.length];
    System.arraycopy(prices, 0, result, 0, prices.length);
    for (int i = 1; i < prices.length; ++i) {
      while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
        int pos = stack.pop();
        result[pos] = prices[pos] - prices[i];
      }
      stack.push(i);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] ints = new LC1475().finalPrices2(new int[]{8, 4, 6, 2, 3});
    System.out.println(Arrays.toString(ints));
  }
}
