package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> freq = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      freq.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(freq.values());
  }
}