package fakru.leetcode;

public class LC67 {

  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; --i, --j) {
      int x = i >= 0 ? a.charAt(i) - '0' : 0;
      int y = j >= 0 ? b.charAt(j) - '0' : 0;
      int sum = carry + x + y;
      if (sum == 3) {
        sb.append(1);
        carry = 1;
      } else if (sum == 2) {
        sb.append(0);
        carry = 1;
      } else {
        sb.append(sum);
        carry = 0;
      }
    }
    if (carry > 0) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    String s = new LC67().addBinary("1010", "1011");
    System.out.println(s);
    // 10101
  }
}
