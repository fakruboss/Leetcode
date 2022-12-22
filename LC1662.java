package fakru.leetcode;

// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
public class LC1662 {

  public static void main(String[] args) {
    String[] word1 = {"ab", "c"};
    String[] word2 = {"a", "bc"};
    new LC1662().arrayStringsAreEqual(word1, word2);

  }

  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    int w1 = 0, p1 = 0;
    int w2 = 0, p2 = 0;
    while (w1 < word1.length && w2 < word2.length) {
      String curr1 = word1[w1], curr2 = word2[w2];
      if (curr1.charAt(p1) != curr2.charAt(p2)) {
        return false;
      }
      if (p1 == word1[w1].length() - 1) {
        p1 = 0;
        ++w1;
      } else {
        ++p1;
      }

      if (p2 == word2[w2].length() - 1) {
        p2 = 0;
        ++w2;
      } else {
        ++p2;
      }
    }
    return w1 == word1.length && w2 == word2.length;
  }
}