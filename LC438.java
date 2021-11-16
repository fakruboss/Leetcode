package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438 {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    int pLen = p.length(), sLen = s.length();
    if (sLen < pLen) {
      return result;
    }
    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> pMap = new HashMap<>();
    for (char c : p.toCharArray()) {
      pMap.put(c, pMap.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < pLen; ++i) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
    }
    if (sMap.equals(pMap)) {
      result.add(0);
    }
    for (int i = 1; i <= sLen - pLen; ++i) {
      char exChar = s.charAt(i - 1);
      char currChar = s.charAt(i + pLen - 1);
      if (exChar != currChar && sMap.containsKey(exChar)) {
        if (sMap.get(exChar) == 1) {
          sMap.remove(exChar);
        } else {
          sMap.put(exChar, sMap.get(exChar) - 1);
        }
      sMap.put(currChar, sMap.getOrDefault(currChar, 0) + 1);
      }
      if (sMap.equals(pMap)) {
        result.add(i);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LC438().findAnagrams("abab", "ab"));
  }
}
