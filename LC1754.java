package fakru.leetcode;

public class LC1754 {
  public String largestMerge(String word1, String word2) {
    StringBuilder result = new StringBuilder();
    for (int i = 0, j = 0; i < word1.length() || j < word2.length();) {
      if (i == word1.length()) result.append(word2.charAt(j++));
      else if (j == word2.length()) result.append(word1.charAt(i++));
      else if (word1.charAt(i) > word2.charAt(j)) result.append(word1.charAt(i++));
      else if (word2.charAt(j) > word1.charAt(i)) result.append(word2.charAt(j++));
      else {
        int iTemp = i + 1, jTemp = j + 1;
        while (true) {
          if (iTemp == word1.length()) {
            result.append(word2, j, word2.length());
            result.append(word1, i, word1.length());
            return result.toString();
          } else if (jTemp == word2.length()) {
            result.append(word1, i, word1.length());
            result.append(word2, j, word2.length());
            return result.toString();
          }
          if (word1.charAt(iTemp) == word2.charAt(jTemp)) {
            ++iTemp;
            ++jTemp;
            continue;
          }
          if (word1.charAt(iTemp) > word2.charAt(jTemp)) {
            result.append(word1.charAt(i++));
          } else {
            result.append(word2.charAt(j++));
          }
          break;
        }
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String s = new LC1754().largestMerge("uuur", "ur");
    System.out.println(s);
  }
}
