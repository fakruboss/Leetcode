package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC187 {

  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> seen = new HashSet<>();
    Set<String> repeated = new HashSet<>();
    for (int i = 0; i < s.length() - 9; i++) {
      String subStr = s.substring(i, i + 10);
      if (!seen.add(subStr)) {
        repeated.add(subStr);
      }
    }
    return new ArrayList<>(repeated);
  }

  public static void main(String[] args) {
    List<String> sequences = new LC187().findRepeatedDnaSequences(
        "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    System.out.println(sequences);
  }
}
