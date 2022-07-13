package fakru.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC318 {

  private boolean isRelated(Set<Character> aSet, Set<Character> bSet) {
    Set<Character> intersection = new HashSet<>(aSet);
    intersection.retainAll(bSet);
    return !intersection.isEmpty();
  }

  public int maxProduct(String[] words) {
    int max = 0;
    Map<String, Set<Character>> map = new HashMap<>();
    for (String word : words) {
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < word.length(); ++i) {
        set.add(word.charAt(i));
      }
      map.put(word, set);
    }

    for (int i = 0; i < words.length - 1; ++i) {
      for (int j = i + 1; j < words.length; ++j) {
        if (!isRelated(map.get(words[i]), map.get(words[j]))) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    String[]strings = {"abcw","baz","foo","bar","xtfn","abcdef"};
    int i = new LC318().maxProduct(strings);
    System.out.println(i);
  }
}
