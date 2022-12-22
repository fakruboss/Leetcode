package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30 {

  public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> freq = new HashMap<>();
    for (String word : words) {
      freq.put(word, freq.getOrDefault(word, 0) + 1);
    }
    List<Integer> result = new ArrayList<>();
    int wordLength = words[0].length();
    for (int i = 0; i <= s.length() - words.length * wordLength; ++i) {
      Map<String, Integer> seenWords = new HashMap<>();
      for (int j = 0; j < words.length; ++j) {
        int wordIndex = i + j * wordLength;
        String word = s.substring(wordIndex, wordIndex + wordLength);
        if (!freq.containsKey(word)) {
          break;
        }
        seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
        if (seenWords.get(word) > freq.get(word)) {
          break;
        }
        if (j == words.length - 1) {
          result.add(i);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<Integer> barfoothefoobarman = new LC30().findSubstring("barfoothefoobarman",
        new String[]{"foo", "bar"});
    System.out.println(barfoothefoobarman);
  }
}