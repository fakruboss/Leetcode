package fakru.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1202 {

  private int[] parent;

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    if (s == null || s.length() == 0) {
      return null;
    }
    parent = new int[s.length()];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    for (List<Integer> pair : pairs) {
      union(pair.get(0), pair.get(1));
    }

    Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
    char[] sChar = s.toCharArray();
    for (int i = 0; i < sChar.length; i++) {
      int root = find(i);
      map.putIfAbsent(root, new PriorityQueue<>());
      map.get(root).offer(sChar[i]);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sChar.length; i++) {
      sb.append(map.get(find(i)).poll());
    }
    return sb.toString();
  }

  private int find(int index) {
    while (parent[index] != index) {
      parent[index] = parent[parent[index]];
      index = parent[index];
    }
    return index;
  }

  private void union(int a, int b) {
    int aParent = find(a);
    int bParent = find(b);
    if (aParent < bParent) {
      parent[bParent] = aParent;
    } else {
      parent[aParent] = bParent;
    }
  }

  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>();
    integers.add(0);
    integers.add(3);
    List<Integer> integers1 = new ArrayList<>();
    integers1.add(1);
    integers1.add(2);
//    List<Integer> integers2 = new ArrayList<>();
//    integers2.add(0);
//    integers2.add(2);
    List<List<Integer>> lists = new ArrayList<>();
    lists.add(integers);
    lists.add(integers1);
//    lists.add(integers2);
    System.out.println(new LC1202().smallestStringWithSwaps("dcab", lists));
  }
}