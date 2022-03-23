package fakru.leetcode;

/**
 * https://leetcode.com/problems/count-binary-substrings/
 *
 * First, I count the number of 1 or 0 grouped consecutively.
 * For example "0110001111" will be [1, 2, 3, 4].
 *
 * Second, for any possible substrings with 1 and 0 grouped consecutively, the number of valid substring will be the minimum number of 0 and 1.
 * For example "0001111", will be min(3, 4) = 3, ("01", "0011", "000111")
 *
 */
public class LC696 {

  public int countBinarySubstrings(String s) {
    int result = 0, curr = 1, prev = 0;
    for (int i = 1; i < s.length(); ++i) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        ++curr;
      } else {
        result += Math.min(curr, prev);
        prev = curr;
        curr = 1;
      }
    }
    return result + Math.min(curr, prev);
  }

  public static void main(String[] args) {
    System.out.println(new LC696().countBinarySubstrings("0001111"));
  }
}