package fakru.leetcode;

import fakru.leetcode.node.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class LC1008 {

  private TreeNode insertIntoBst(TreeNode root, int value) {
    if (root == null) {
      return new TreeNode(value);
    }
    if (value < root.val) {
      root.left = insertIntoBst(root.left, value);
    } else {
      root.right = insertIntoBst(root.right, value);
    }
    return root;

  }

  public TreeNode bstFromPreorder(int[] preorder) {
    new Stack<>();
    TreeNode root = null;
    for (int num : preorder) {
      root = insertIntoBst(root, num);
    }
    return root;
  }

  public static void main(String[] args) {
//    TreeNode treeNode = new LC1008().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});

    "fakru".indexOf('a');
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 11);
    map.put(2, 22);
    map.put(3, 33);
    map.put(4, 44);

    List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    list.sort((a, b) -> b.getValue() - a.getValue());
    System.out.println(list);

    int n = 4;
    Map<Integer, Integer> values = new HashMap<>();
    for (Map.Entry<Integer, Integer> entry : list) {
      values.put(entry.getKey(), n--);
    }
    System.out.println(values);
  }
}
