package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC139 {

  /*
  public boolean wordBreak(String s, List<String> wordDict) {
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0, n = wordDict.size(); i < n; ++i) {
      String word = wordDict.get(i);
      int start = sb.indexOf(word);
      if (start != -1) {
        sb.replace(start, start + word.length(), "");
        --i;
      }
      if (sb.length() == 0) {
        return true;
      }

    }
    return sb.length() == 0;
  }
   */

  public boolean wordBreak(String s, List<String> wordDict) {
    System.out.println(s);
    for (int i = 1; i <= s.length(); ++i) {
      if (wordDict.contains(s.substring(0, i))
          && wordBreak(s.substring(i), wordDict)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String s = "applepenapple";
    ArrayList<String> wordDict = new ArrayList<>(
        Arrays.asList("apple", "pen"));
    System.out.println(new LC139().wordBreak(s, wordDict));
  }
}