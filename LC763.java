package fakru.leetcode;

import java.util.*;

public class LC763 {

  public List<Integer> partitionLabels(String s) {
    List<Integer> result = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); ++i) {
      map.put(s.charAt(i), i);
    }
    System.out.println(map);
    int maxStretch = map.get(s.charAt(0)), prev = 0;
    for (int i = 1; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (i > maxStretch && map.get(c) > maxStretch) {
        result.add(maxStretch - prev + 1);
        prev = i;
      }
      maxStretch = Math.max(maxStretch, map.get(c));
    }
    result.add(maxStretch - prev + 1);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LC763().partitionLabels("ababcbacadefegdehijhklij"));
  }
}
