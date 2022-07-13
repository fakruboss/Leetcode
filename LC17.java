package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits.isEmpty()) {
      return result;
    }
    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    backtrack(digits, map, 0, new StringBuilder(), result);
    return result;
  }

  private void backtrack(String digits, Map<Character, String> map, int index,
      StringBuilder curr, List<String> result) {
    if (curr.length() == digits.length()) {
      result.add(curr.toString());
      return;
    }
    for (char c : map.get(digits.charAt(index)).toCharArray()) {
      backtrack(digits, map, index + 1, curr.append(c), result);
      curr.deleteCharAt(curr.length() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(new LC17().letterCombinations(""));
  }
}