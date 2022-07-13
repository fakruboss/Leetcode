package fakru.leetcode;

public class LC5242 {

  public String greatestLetter(String s) {
    boolean[] small = new boolean[26];
    boolean[] big = new boolean[26];
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c >= 'a' && c <= 'z') {
        small[c - 'a'] = true;
      } else if (c >= 'A' && c <= 'Z') {
        big[c - 'A'] = true;
      }
    }
    for (int i = 25; i >= 0; --i) {
      if (big[i] && small[i]) {
        return String.valueOf((char) ('A' + i));
      }
    }
    return "";
  }
}
