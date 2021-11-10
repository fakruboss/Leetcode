package fakru.leetcode;

public class LC371 {

  public int getSum(int a, int b) {
    while (b != 0) {
      int temp = (a & b) << 1;
      a = a ^ b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) {
    System.out.println(new LC371().getSum(20, 30));
  }
}