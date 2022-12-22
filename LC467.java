package fakru.leetcode;

// https://leetcode.com/problems/unique-substrings-in-wraparound-string/
public class LC467 {

  public static void main(String[] args) {
    int zab = new LC467().findSubstringInWraproundString("zab");
  }

  public int findSubstringInWraproundString(String p) {
    int res = 0, count = 1;
    for (int i = 0; i < p.length() - 1; ++i) {
      int curr = p.charAt(i) - 'a';
      int next = p.charAt(i + 1) - 'a';
      if (Math.abs(curr - next) != 1) {
        int currRes = (count * (count + 1)) / 2;
        res += currRes;
      }
      ++count;
    }
    int currRes = (count * (count + 1)) / 2;
    res += currRes;
    return res;
  }
}
