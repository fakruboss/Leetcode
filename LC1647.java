package fakru.leetcode;

import java.util.Arrays;

public class LC1647 {

  public int minDeletions(String s) {
    int count = 0;
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); ++i) {
      ++freq[s.charAt(i) - 'a'];
    }
    Arrays.sort(freq);
    System.out.println(Arrays.toString(freq));
    int maxFreqAllowed = s.length();
    for (int i = 25; i >= 0 && freq[i] > 0; --i) {
      if (freq[i] > maxFreqAllowed) {
        count += freq[i] - maxFreqAllowed;
        freq[i] = maxFreqAllowed;
      }
      maxFreqAllowed = Math.max(0, freq[i] - 1);
    }
    return count;
  }

  public static void main(String[] args) {
    int count = new LC1647().minDeletions("tokjhygfreswazsdfcd");
//    int count = new LC1647().minDeletions("aaaaaaaaaaaaaaaaaaaa");
//    int count = new LC1647().minDeletions("abcdefghijkl");
    System.out.println(count);
  }
}
