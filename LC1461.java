package fakru.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC1461 {

  public boolean hasAllCodes(String s, int k) {
    if (s.length() < k) return false;
    Set<String> set = new HashSet<>();
    StringBuilder base = new StringBuilder(s.substring(0, k));
    set.add(base.toString());
    for (int i = k; i < s.length(); ++i) {
      base.deleteCharAt(0);
      base.append(s.charAt(i));
      set.add(base.toString());
    }
    return set.size() == (int) Math.pow(2, k);
  }

  public static void main(String[] args) {
    boolean b = new LC1461().hasAllCodes("0111111111111", 20);
    System.out.println(b);
  }
}
