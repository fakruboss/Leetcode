package fakru.leetcode;

public class LC541 {

  public static void main(String[] args) {
    String reverseStr = new LC541().reverseStr("abcd", 2);
    System.out.println(reverseStr);
  }

  public String reverseStr(String s, int k) {
    char[] c = s.toCharArray();
    boolean isReverse = true;
    for (int i = 0; i < s.length(); i += k, isReverse = !isReverse) {
      if (!isReverse) {
        continue;
      }
      reverse(c, i, Math.min(i + k, s.length()) - 1);
    }
    return new String(c);
  }

  private void reverse(char[] c, int start, int end) {
    while (start < end) {
      char temp = c[start];
      c[start++] = c[end];
      c[end--] = temp;
    }
  }
}
