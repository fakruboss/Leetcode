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

  /**
   * store the last occurrence of each character in a map with char as key and index as value. We
   * will have two indexes, for marking the start and end of the unique substring. While iterating,
   * check if that character is already present in the map. If present, we have to modify the start
   * pointer to point it to the next character after the repeated character, so that the character
   * in the substring from the start to end is unique. while doing so, confirm if the previous start
   * index is less than the index of next repeated char else retain the previous value. This check
   * is done because sometimes, the current start index value might have bypassed the repeated
   * character already. The start pointer has to be updated, only when the index value is greater.
   * At the end of each iteration, store the max length of the substring by subtracting the end
   * index and start index and return it at the end of the iteration
   */
  public int lengthOfLongestSubstring3(String s) {
    int maxLength = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0, j = 0, n = s.length(); i < n; ++i) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        j = Math.max(j, map.get(c) + 1);
      }
      map.put(c, i);
      maxLength = Math.max(maxLength, i - j + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(new LC3().lengthOfLongestSubstring3("abba"));
  }
}