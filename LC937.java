package fakru.leetcode;

import java.util.Arrays;

public class LC937 {

  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, (s1, s2) -> {
      String[] words1 = s1.split(" ", 2);
      String[] words2 = s2.split(" ", 2);

      boolean isDigit1 = Character.isDigit(words1[1].charAt(0));
      boolean isDigit2 = Character.isDigit(words2[1].charAt(0));

      if (!isDigit1 && !isDigit2) {
        int comp = words1[1].compareTo(words2[1]);
        return comp == 0 ? words1[0].compareTo(words2[0]) : comp;
      } else if (isDigit1 && !isDigit2) {
        return 1;
      } else if (!isDigit1) {
        return -1;
      }
      return 0;
    });
    return logs;
  }

  public static void main(String[] args) {
    String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig",
        "let3 art zero"};
    System.out.println(Arrays.toString(new LC937().reorderLogFiles(logs)));
  }
}