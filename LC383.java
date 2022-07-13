package fakru.leetcode;

public class LC383 {

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] r = new int[26];
    for (int i = 0; i < magazine.length(); ++i) {
      ++r[magazine.charAt(i) - 'a'];
    }
    for (int i = 0; i < ransomNote.length(); ++i) {
      if (--r[ransomNote.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    new LC383().canConstruct("aa", "aab");
  }
}
