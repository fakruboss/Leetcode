package fakru.leetcode;

public class LC1545 {

  public char findKthBit(int n, int k) {
    String[] nums = new String[n];
    nums[0] = "0";
    for (int i = 1; i < n; ++i) {
      String prev = nums[i - 1];
      String flip = flip(prev);
      String processed = reverse(flip);
      nums[i] = prev + "1" + processed;
      System.out.println(nums[i]);
    }
    return nums[n - 1].charAt(k);
  }

  private String flip(String num) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < num.length(); ++i) {
      sb.append(num.charAt(i) == '0' ? '1' : '0');
    }
    return sb.toString();
  }

  private String reverse(String num) {
    return new StringBuilder(num).reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(new LC1545().findKthBit(4, 11));
  }
}
