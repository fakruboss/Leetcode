package fakru.leetcode;

public class LC345 {

  public static void main(String[] args) {
    String hello = new LC345().reverseVowels("aeae");
    System.out.println(hello);
  }

  private boolean isVowel(char c) {
    c = Character.toLowerCase(c);
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  public String reverseVowels(String s) {
    char[] c = s.toCharArray();
    int left = 0, right = s.length() - 1;
    while (left < right) {
      int leftVowel = -1, rightVowel = -1;
      while (leftVowel == -1) {
        leftVowel = isVowel(s.charAt(left)) ? left : -1;
        if (left >= right) {
          return new String(c);
        }
        ++left;
      }
      while (rightVowel == -1) {
        rightVowel = isVowel(s.charAt(right)) ? right : -1;
        if (left > right) {
          return new String(c);
        }
        --right;
      }
      char temp = c[leftVowel];
      c[leftVowel] = c[rightVowel];
      c[rightVowel] = temp;
    }
    return new String(c);
  }
}