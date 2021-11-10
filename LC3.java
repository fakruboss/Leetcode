package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC3 {

  public int lengthOfLongestSubstring(String s) {
    int maxLen = 0, currLen = 0;
    Map<Character, Integer> freq = new HashMap<>();
    for (int i = 0, j = 0; j < s.length(); ) {
      char c = s.charAt(j);
      if (freq.getOrDefault(c, 0) >= 1) {
        freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
        ++i;
        --currLen;
      } else {
        freq.put(c, freq.getOrDefault(c, 0) + 1);
        ++j;
        ++currLen;
      }
      maxLen = Math.max(currLen, maxLen);
    }
    return maxLen;
  }

  public int lengthOfLongestSubstring2(String s) {
    if (s.length() == 0) {
      return 0;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    int max = 0;
    for (int i = 0, j = 0; i < s.length(); ++i) {
      if (map.containsKey(s.charAt(i))) {
        j = Math.max(j, map.get(s.charAt(i)) + 1);
      }
      map.put(s.charAt(i), i);
      max = Math.max(max, i - j + 1);
    }
    return max;
  }

  public int lengthOfLongestSubstring3(String s) {
    int maxLength = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0, j = 0, n = s.length(); j < n; ++j) {
      char c = s.charAt(j);
      if (map.containsKey(c)) {
//        i = Math.max(i, map.get(c) + 1);
        i = map.get(c) + 1;
      }
      map.put(c, j);
      maxLength = Math.max(maxLength, j - i + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(new LC3().lengthOfLongestSubstring3("abba"));
  }
}