package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {

  private void letterCombinations(String digits, List<String> result, String curr,
      int index, Map<Character, String> map) {
    if (curr.length() == digits.length()) {
      result.add(curr);
      return;
    }

    for (char c : map.get(digits.charAt(index)).toCharArray()) {
      letterCombinations(digits, result, curr + c, index + 1, map);
    }
  }

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (!digits.isEmpty()) {
      Map<Character, String> map = new HashMap<>();
      map.put('2', "abc");
      map.put('3', "def");
      map.put('4', "ghi");
      map.put('5', "jkl");
      map.put('6', "mno");
      map.put('7', "pqrs");
      map.put('8', "tuv");
      map.put('9', "wxyz");
      letterCombinations(digits, result, "", 0, map);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LC17().letterCombinations("23"));
  }
}
