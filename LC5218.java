package fakru.leetcode;

public class LC5218 {

  int result = Integer.MAX_VALUE;

  public int minimumNumbers(int num, int k) {
    int curr = num;
    while (curr % 10 != k) {
      curr -= 1;
    }
    minimumNumbersHelper(num, curr, k, 0);
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private void minimumNumbersHelper(int num, int curr, int k, int count) {
    System.out.println(num + " " + curr);
    if (num == 0) {
      result = Math.min(result, count);
    }
    if (curr < k) {
      return;
    }
    minimumNumbersHelper(num - curr, getCurr(num - curr, k), k, count + 1);
    minimumNumbersHelper(num, curr - 10, k, count);
  }

  private int getCurr(int curr, int k) {
    while (curr > 0 && curr % 10 != k) {
      curr -= 1;
    }
    return curr;
  }

  public static void main(String[] args) {
    int i = new LC5218().minimumNumbers(100, 6);
    System.out.println(i);
  }
}