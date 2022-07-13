package fakru.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC97 {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s3.isEmpty()) {
      return s1.isEmpty() && s2.isEmpty();
    }
    if (s1.isEmpty()) {
      return s2.equals(s3);
    }
    if (s2.isEmpty()) {
      return s1.equals(s3);
    }

    List<String> list = new LinkedList<>();
    char first = s1.charAt(0);
    char second = s2.charAt(0);
    list.add(String.valueOf(first));
    list.add(String.valueOf(second));
    for (int i = 1, j = 1; i < s1.length() || j < s2.length(); ++i, ++j) {
      if (list.isEmpty()) {
        return false;
      }
      first = s1.charAt(i);
      second = s2.charAt(j);
      List<String> temp = new ArrayList<>();
      for (String curr : list) {
        String substring = s3.substring(0, curr.length() + 1);
        if (substring.equals(curr + first)) {
          temp.add(curr + first);
        }

        if (substring.equals(curr + second)) {
          temp.add(curr + second);
        }
      }
      list = temp;
    }
    return true;
  }

  public static void main(String[] args) {
    boolean interleave = new LC97().isInterleave("aab", "aac", "aaaabc");
    System.out.println(interleave);
  }
}