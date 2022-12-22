package fakru.leetcode;

public class LC443 {

  public static void main(String[] args) {
    int compress = new LC443().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
  }

  public int compress(char[] chars) {
    int count = 1, end = 0;
    char prev = chars[0];
    for (int i = 1; i < chars.length; ++i) {
      if (chars[i] != prev) {
        if (count == 1) {
          chars[end++] = prev;
        } else {
          chars[end++] = prev;
          String s = String.valueOf(count);
          for (int j = 0; j < s.length(); ++j) {
            chars[end++] = s.charAt(j);
          }
        }
        count = 1;
        prev = chars[i];
      } else {
        ++count;
      }
    }
    if (count == 1) {
      chars[end++] = prev;
    } else {
      chars[end++] = chars[chars.length - 1];
      String s = String.valueOf(count);
      for (int j = 0; j < s.length(); ++j) {
        chars[end++] = s.charAt(j);
      }
    }
    return end;
  }
}