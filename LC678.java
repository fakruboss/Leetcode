package fakru.leetcode;

public class LC678 {

  public boolean checkValidString(String s) {
    int cmin = 0,
        cmax = 0;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c == '(') {
        ++cmax;
        ++cmin;
      } else if (c == ')') {
        --cmax;
        --cmin;
      } else {
        ++cmax;
        --cmin;
      }
      if (cmax < 0) {
        return false;
      }
      cmin = Math.max(cmin, 0);
    }
    return cmin == 0;
  }

  public static void main(String[] args) {
    LC678 lc678 = new LC678();
    System.out.println(lc678.checkValidString("***)"));
    System.out.println(lc678.checkValidString("**)"));
  }
}
