package fakru.leetcode;

public class LC326 {

  public static void main(String[] args) {
    test();
//    boolean powerOfThree = new LC326().isPowerOfThree(243);
//    System.out.println(powerOfThree);
  }

  public boolean isPowerOfThree(int n) {
    double logNum = Math.log(n);
    double logThree = Math.log10(3);
    double div = logNum / logThree;
    double res = div % 1;
    return res == 0;
  }

  private static void test() {
    try {
      int x = 5 / 0;
//    } catch (Exception e) {
//      String s = null;
//      System.out.println(s.toString());
    } finally {
      System.out.println("finally");
    }
  }
}
