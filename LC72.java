package fakru.leetcode;

import java.util.Arrays;

public class LC72 {

  // SOLUTION 1 : RECURSION
  public int minDistance(String word1, String word2) {
    if (word1 == null || word1.isEmpty()) {
      return word2.length();
    }
    if (word2 == null || word2.isEmpty()) {
      return word1.length();
    }
    if (word1.charAt(0) == word2.charAt(0)) {
      return minDistance(word1.substring(1), word2.substring(1));
    }
    int insert = 1 + minDistance(word1, word2.substring(1));
    int delete = 1 + minDistance(word1.substring(1), word2);
    int replace = 1 + minDistance(word1.substring(1), word2.substring(1));
    return Math.min(insert, Math.min(delete, replace));
  }

  // SOLUTION 2 : MEMOIZATION (TOP DOWN approach)
  private int match(char[] c1, char[] c2, int i, int j, int[][] cache) {
    if (i == c1.length) {
      return c2.length - j;
    }
    if (j == c2.length) {
      return c1.length - i;
    }
    if (cache[i][j] != -1) {
      return cache[i][j];
    }
    if (c1[i] == c2[j]) {
      return match(c1, c2, i + 1, j + 1, cache);
    } else {
      int insert = match(c1, c2, i, j + 1, cache);
      int delete = match(c1, c2, i + 1, j, cache);
      int replace = match(c1, c2, i + 1, j + 1, cache);
      cache[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
    return cache[i][j];
  }

  public int minDistance2(String word1, String word2) {
    if (word1 == null || word1.isEmpty()) {
      return word2.length();
    }
    if (word2 == null || word2.isEmpty()) {
      return word1.length();
    }
    char[] c1 = word1.toCharArray();
    char[] c2 = word2.toCharArray();
    int[][] cache = new int[c1.length][c2.length];
    for (int i = 0; i < c1.length; ++i) {
      Arrays.fill(cache[i], -1);
    }
    return match(c1, c2, 0, 0, cache);
  }

  // SOLUTION 3 : Dynamic programming (BOTTOM UP approach)
  public int minDistance3(String word1, String word2) {
    if (word1.isEmpty()) {
      return word2.length();
    }
    if (word2.isEmpty()) {
      return word1.length();
    }
    char[] c1 = word1.toCharArray();
    char[] c2 = word2.toCharArray();
    int[][] cache = new int[c1.length + 1][c2.length + 1];
    for (int i = 0; i <= c1.length; ++i) {
      cache[i][0] = i;
    }
    for (int j = 0; j <= c2.length; ++j) {
      cache[0][j] = j;
    }
    for (int i = 0, n1 = c1.length; i < n1; ++i) {
      for (int j = 0, n2 = c2.length; j < n2; ++j) {
        if (c1[i] == c2[j]) {
          cache[i + 1][j + 1] = cache[i][j];
        } else {
          cache[i + 1][j + 1] =
              1 + Math.min(cache[i][j], Math.min(cache[i + 1][j], cache[i][j + 1]));
        }
      }
    }
    return cache[c1.length][c2.length];
  }

  public static void main(String[] args) {
    System.out.println(new LC72().minDistance("horse", "ros"));
    System.out.println(new LC72().minDistance2("horse", "ros"));
    System.out.println(new LC72().minDistance3("horse", "ros"));
  }
}