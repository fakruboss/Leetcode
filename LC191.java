package fakru.leetcode;

public class LC191 {

  public int hammingWeight(int n) {
    int result = 0;
    while (n != 0) {
      System.out.println(n);
      n = n & (n - 1);
      ++result;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("** " + new LC191().hammingWeight(12));
  }
}