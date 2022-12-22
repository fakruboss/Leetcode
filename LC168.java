package fakru.leetcode;

public class LC168 {

  private String charEquiv(int rem) {
    return String.valueOf((char) (64 + rem));
  }

  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 26) {
      int rem = n % 26;
      rem = rem == 0 ? 25 : 0;
      sb.append((char) (rem + 'A' - 1));
      n = n / 26;
    }
    sb.append((char) (n + 'A' - 1));
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    String s = new LC168().convertToTitle(702);
    System.out.println(s);
  }
}
