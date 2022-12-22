package fakru.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LC1047 {

  public String removeDuplicates(String s) {
    char[] chars = s.toCharArray();
    int pointer = 0;
    for (char c : chars) {
      if (pointer != 0 && chars[pointer - 1] == c) {
        --pointer;
      } else {
        chars[pointer++] = c;
      }
    }
    return new String(chars, 0, pointer);
  }

  public static int countFamilyLogins(List<String> logins) {
    Map<Integer, Set<String>> map = new HashMap<>();
    int n = logins.size(), result = 0;
    for (int i = 0; i < n - 1; ++i) {
      for (int j = i + 1; j < n; ++j) {
        String a = logins.get(i);
        String b = logins.get(j);
        Integer diff = getDiff(a, b);
        if (diff != null) {
          Integer mapKey = getMapKey(a, b, map);
          if (mapKey != null) {
            map.get(mapKey).add(a);
            map.get(mapKey).add(b);
          } else {
            map.computeIfAbsent(diff, key -> new HashSet<>());
            map.get(diff).add(a);
            map.get(diff).add(b);
          }
        }
      }
    }
    for (Set<String> set : map.values()) {
      result += set.size();
    }

    return result;
  }

  private static Integer getMapKey(String a, String b, Map<Integer, Set<String>> map) {
    for (Entry<Integer, Set<String>> entry : map.entrySet()) {
      if (entry.getValue().contains(a) || entry.getValue().contains(b)) {
        return entry.getKey();
      }
    }
    return null;
  }

  private static Integer getDiff(String a, String b) {
    if (a.equals(b)) {
      return null;
    }
    int diff = a.charAt(0) - b.charAt(0);
    for (int i = 1; i < a.length(); ++i) {
      if (a.charAt(i) - b.charAt(i) != diff) {
        return null;
      }
    }
    System.out.println(a + " " + b + " " + diff);
    return diff;
  }

  public static void main(String[] args) {
    String s = new LC1047().removeDuplicates("abbaca");
    System.out.println(s);
//    int i = LC1047.countFamilyLogins(Arrays.asList("bag", "sfe", "cbh", "cbh", "red"));
//    System.out.println(i);
  }
}
