package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    int pLen = p.length(), sLen = s.length();
    if (sLen < pLen) {
      return result;
    }
    int[] sMap = new int[26];
    int[] pMap = new int[26];
    for (char c : p.toCharArray()) {
      ++pMap[c - 'a'];
    }
    for (int i = 0; i < pLen; ++i) {
      ++sMap[s.charAt(i) - 'a'];
    }
    if (Arrays.equals(sMap, pMap)) {
      result.add(0);
    }
    for (int i = 1; i <= sLen - pLen; ++i) {
      char exChar = s.charAt(i - 1);
      char currChar = s.charAt(i + pLen - 1);
      if (exChar != currChar) {
        --sMap[exChar - 'a'];
        ++sMap[currChar - 'a'];
      }
      if (Arrays.equals(sMap, pMap)) {
        result.add(i);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LC438().findAnagrams("abab", "ab"));
  }
}
