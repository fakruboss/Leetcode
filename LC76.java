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

  public String minWindow2(String s, String t) {
    int[] map = new int[128];
    for (char c : t.toCharArray()) {
      map[c]++;
    }
    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
    print(map);
    while (end < s.length()) {
      final char sEnd = s.charAt(end);
      if (map[sEnd] > 0) {
        counter--;
      }
      map[sEnd]--;
      end++;
      print(map);
      while (counter == 0) {
        if (minLen > end - start) {
          minLen = end - start;
          minStart = start;
        }
        final char sStart = s.charAt(start);
        map[sStart]++;
        print(map);
        if (map[sStart] > 0) {
          counter++;
        }
        start++;
      }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
  }

  public static void main(String[] args) {
    String s = new LC76().minWindow2("abaa", "aa");
    System.out.println(s);
  }

  private void print(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != 0) {
        System.out.print((char) i + " " + nums[i] + " | ");
      }
    }
    System.out.println();
  }
}