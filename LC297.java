package fakru.leetcode;

import fakru.leetcode.node.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Codecc {

  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  private void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("#").append(",");
    } else {
      sb.append(root.val).append(",");
      serialize(root.left);
      serialize(root.right);
    }
  }

  public TreeNode deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserialize(queue);
  }

  private TreeNode deserialize(Queue<String> queue) {
    if (queue.isEmpty()) {
      return null;
    }
    String s = queue.poll();
    if (s.equals("#")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(s));
    root.left = deserialize(queue);
    root.right = deserialize(queue);
    return root;
  }
}

public class LC297 {

  public static void main(String[] args) {
    Codecc codecc = new Codecc();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    String s = codecc.serialize(root);
    System.out.println(s);
    root = codecc.deserialize(s);
    System.out.println(root);
  }
}
