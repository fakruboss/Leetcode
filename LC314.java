package fakru.leetcode;

import fakru.leetcode.node.TreeNode;
import java.util.*;

class Pair {

  TreeNode node;
  int index;

  public Pair(TreeNode node, int index) {
    this.node = node;
    this.index = index;
  }
}

public class LC314 {

  private Map<Integer, List<Integer>> preOrderTraversal(TreeNode root, int currIndex,
      Map<Integer, List<Integer>> map) {
    if (root != null) {
      List<Integer> list = map.get(currIndex) == null
          ? new ArrayList<>() : map.get(currIndex);
      list.add(root.val);
      map.put(currIndex, list);
      preOrderTraversal(root.left, currIndex - 1, map);
      preOrderTraversal(root.right, currIndex + 1, map);
    }
    return map;
  }

  public List<List<Integer>> verticalOrder_dfs(TreeNode root) {
    Map<Integer, List<Integer>> map = preOrderTraversal(root, 0, new TreeMap<>());
    return new ArrayList<>(map.values());
  }

  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(root, 0));
    while (!queue.isEmpty()) {
      for (int n = queue.size(); n > 0; --n) {
        Pair pair = queue.poll();
        map.computeIfAbsent(pair.index, x -> new ArrayList<>()).add(pair.node.val);
        min = Math.min(min, pair.index);
        max = Math.max(max, pair.index);
        if (pair.node.left != null) {
          queue.offer(new Pair(pair.node.left, pair.index - 1));
        }
        if (pair.node.right != null) {
          queue.offer(new Pair(pair.node.right, pair.index + 1));
        }
      }
    }

    for (int i = min; i <= max; ++i) {
      result.add(map.get(i));
    }
    return result;
  }
}
