package fakru.leetcode.wc286;

import static fakru.leetcode.utils.PrintUtils.print;

import java.util.HashMap;
import java.util.Map;

public class LC2217 {

  private boolean isPalindrome(long num) {
    char[] c = String.valueOf(num).toCharArray();
    for (int i = 0, n = c.length; i < n; ++i) {
      if (c[i] != c[n - i - 1]) {
        return false;
      }
    }
    return true;
  }

  // BRUTE-FORCE approach
  public long[] kthPalindrome1(int[] queries, int intLength) {
    long[] result = new long[queries.length];
    int baseNum = (int) Math.pow(10, intLength - 1d);
    Map<Integer, Long> cache = new HashMap<>();
    int maxQuery = Integer.MIN_VALUE;
    for (int query : queries) {
      maxQuery = Math.max(query, maxQuery);
      cache.put(query, null);
    }
    int pCount = 0;
    for (long num = baseNum; num < Long.MAX_VALUE; ++num) {
      if (isPalindrome(num)) {
        ++pCount;

        print(pCount + " : " + num);
        if (cache.containsKey(pCount)) {
          cache.put(pCount, num);
        }
      }
      if (cache.get(maxQuery) != null) {
        break;
      }
    }
    for (int i = 0; i < queries.length; ++i) {
      result[i] = cache.get(queries[i]);
    }
    return result;
  }

  /**
   * Ref : https://www.geeksforgeeks.org/nth-palindrome-k-digits/
   *
   * 1. construct the first half of the palindrome and revere + append it
   * 2. To construct first half, if it's odd, take k / 2 and for even, take (k / 2) - 1. since, for odd extra one digit is the middle digit
   * 3. after generating the base number, add (n - 1) to the base num since, default generated num is the first one
   * 4. if it's odd, exclude the last digit in the base num
   *
   */
  private long kthPalindrome(int n, int k) {
    long result;
    int pow = k % 2 == 1 ? k / 2 : k / 2 - 1;
    int baseNum = (int) Math.pow(10, pow);
    baseNum += n - 1;
    result = baseNum;
    if (k % 2 == 1) {
      baseNum /= 10;
    }
    while (baseNum > 0) {
      result = (result * 10) + (baseNum % 10);
      baseNum /= 10;
    }
    return String.valueOf(result).length() > k ? -1 : result;
  }

  public long[] kthPalindrome(int[] queries, int intLength) {
    long[] result = new long[queries.length];
    for (int i = 0; i < queries.length; ++i) {
      result[i] = kthPalindrome(queries[i], intLength);
    }
    return result;
  }

  public static void main(String[] args) {
    int k = 4;
    long[] x = new LC2217().kthPalindrome(new int[]{1, 2, 3, 4, 5, 90}, k);
    print(x);
  }
}
