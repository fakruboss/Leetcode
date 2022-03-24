package fakru.leetcode;


import static fakru.leetcode.utils.PrintUtils.print;

public class LC202 {

  int digitSquareSum(int n) {
    int sum = 0, tmp;
    while (n > 0) {
      tmp = n % 10;
      sum += tmp * tmp;
      n /= 10;
    }
    return sum;
  }

  boolean isHappy(int n) {
    int slow, fast;
    slow = fast = n;
    do {
      slow = digitSquareSum(slow);
      fast = digitSquareSum(fast);
      fast = digitSquareSum(fast);
      if (fast == 1) {
        return true;
      }
    } while (slow != fast);
    return false;
  }

  public static void main(String[] args) {
    print(new LC202().isHappy(11));
  }
}
