package fakru.leetcode;

import static fakru.leetcode.utils.PrintUtils.print;

/**
 * https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
 */
public class LC1888 {

  /**
   * Ref : https://youtu.be/MOeuK6gaC2A
   *
   * 1. generate two strings. one starting with zero & another with one
   * 2. Strings are doubled to prevent deleting at the front and adding at the back operation which
   * can be achieved by just moving the substring window
   * 3. If we find the substring length equal to the original string length, we are finding the
   * minimum among (existing result, starting with zero and starting with one) and storing it as the
   * current result
   * 4. If we find the substring length greater than n, we are truncating by checking the substring
   * start and then reducing the result by one if they are not equal, since, we are letting that
   * character go
   * 5. This type of comparison works because during delete and append, the zero comparison will
   * become equivalent to one comparison and vice versa. Since, we just care about the numbers,
   * whichever we are comparing with, just the end min result is what is needed
   *
   */
  public int minFlips(String s) {
    int n = s.length(), result = Integer.MAX_VALUE;
    s += s;
    StringBuilder zeroStart = new StringBuilder();
    StringBuilder oneStart = new StringBuilder();
    int zero = 0, one = 0;
    for (int left = 0, right = 0; right < s.length(); ++right) {
      zeroStart.append(right % 2 == 0 ? "0" : "1");
      oneStart.append(right % 2 == 0 ? "1" : "0");
      if (s.charAt(right) != zeroStart.charAt(right)) {
        ++zero;
      }
      if (s.charAt(right) != oneStart.charAt(right)) {
        ++one;
      }
      if (right - left + 1 > n) {
        if (s.charAt(left) != zeroStart.charAt(left)) {
          --zero;
        }
        if (s.charAt(left) != oneStart.charAt(left)) {
          --one;
        }
         ++left;
      }
      if (right - left + 1 == n) {
        result = Math.min(result, Math.min(one, zero));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    print(new LC1888().minFlips("1010110101010111010101001010101010101"));
  }
}