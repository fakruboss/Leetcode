package fakru.leetcode;

import java.util.Arrays;

public class LC1366 {

  public static void main(String[] args) {
    String s = new LC1366().rankTeams(new String[]{"WXZY", "XYWZ"});
    System.out.println(s);
  }

  public String rankTeams(String[] votes) {
    int voteLen = votes[0].length();
    int[][] ranks = new int[26][voteLen + 1];
    for (int i = 0; i < 26; ++i) {
      ranks[i][voteLen] = i;
    }
    for (String vote : votes) {
      for (int j = 0; j < voteLen; ++j) {
        ++ranks[vote.charAt(j) - 'A'][j];
      }
    }
    Arrays.sort(ranks, (a, b) -> {
      for (int i = 0; i < voteLen; ++i) {
        if (a[i] < b[i]) {
          return 1;
        }
        if (a[i] > b[i]) {
          return -1;
        }
      }
      return 0;
    });
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < voteLen; ++i) {
      result.append((char) ('A' + ranks[i][voteLen]));
    }
    return result.toString();
  }
}
