package fakru.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC406 {

  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
    List<int[]> list = new LinkedList<>();
    for (int[] p : people) {
      list.add(p[1], p);
    }
    return list.toArray(new int[list.size()][]);
  }

  public static void main(String[] args) {
    int[][] p = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//    int[][] p = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
    int[][] queue = new LC406().reconstructQueue(p);
    for (int[] q : queue) {
      System.out.println(Arrays.toString(q));
    }
  }
}