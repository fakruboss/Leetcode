package fakru.leetcode;

public class LC29 {

  public int divide(int dividend, int divisor) {
    boolean isNegative = (dividend > 0) ^ (divisor > 0);
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    int result = 0;
    while (dividend - divisor >= 0) {
      int count = 0;
      while (dividend - (divisor << (1 << count)) >= 0) {
        System.out.println(divisor << (1 << count));
        ++count;
      }
      result += (1 << count);
      dividend -= (divisor << count);
    }
    return isNegative ? -result : result;
  }

  public static void main(String[] args) {
    int divide = new LC29().divide(2147483647, -1);
    System.out.println(divide);
  }
}
