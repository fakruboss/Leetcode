package fakru.leetcode;

public class LC424 {

  public static void main(String[] args) {
    int aababba = new LC424().characterReplacement("AABABBA", 1);
    System.out.println(aababba);
  }
  public int characterReplacement(String s, int k) {
    int[] freq = new int[26];
    int left = 0, maxLen = 0, maxFreq = 0;
    for (int right = 0; right < s.length(); ++right) {
      char c = s.charAt(right);
      ++freq[c - 'A'];
      maxFreq = Math.max(maxFreq, freq[c - 'A']);
      if ((right - left + 1) - maxFreq > k) {
        --freq[s.charAt(left) - 'A'];
        ++left;
      }
      maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
  }
}
