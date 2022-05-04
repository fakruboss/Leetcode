package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC76 {

  public String minWindow(String s, String t) {
    Map<Character, Integer> count = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (int i = 0; i < t.length(); ++i) {
      count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
    }
    int left = 0, minLen = Integer.MAX_VALUE;
    int have = 0, need = count.size();
    int start = -1, end = -1;
    for (int right = 0; right < s.length(); ++right) {
      char c = s.charAt(right);
      window.put(c, window.getOrDefault(c, 0) + 1);
      if (count.containsKey(c) && window.get(c) == count.get(c)) {
        have += 1;
      }
      while (have == need) {
        if (right - left + 1 < minLen) {
          minLen = right - left + 1;
          start = left;
          end = right;
        }
        char cLeft = s.charAt(left);
        window.put(cLeft, window.get(cLeft) - 1);
        if (count.containsKey(cLeft) && window.get(cLeft) < count.get(cLeft)) {
          have -= 1;
        }
        ++left;
      }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
  }

  public static void main(String[] args) {
    new LC76().minWindow("", "");
  }
}