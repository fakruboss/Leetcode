package fakru.leetcode;

import fakru.leetcode.node.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Codec {

  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  private void serialize(TreeNode root, StringBuilder sb) {
    if (root != null) {
      sb.append(root.val).append(",");
      serialize(root.left, sb);
      serialize(root.right, sb);
    }
  }

  public TreeNode deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode deserialize(Queue<String> queue, int min, int max) {
    if (queue.isEmpty()) {
      return null;
    }
    String s = queue.peek();
    int val = Integer.parseInt(s);
    if (val < min || val > max) {
      return null;
    }
    queue.poll();
    TreeNode root = new TreeNode(val);
    root.left = deserialize(queue, min, val);
    root.right = deserialize(queue, val, max);
    return root;
  }
}

public class LC449 {

  public static void main(String[] args) {
    Codec codec = new Codec();
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    String encodedString = codec.serialize(root);
    System.out.println(encodedString);
    TreeNode result = codec.deserialize(encodedString);
    System.out.println(result);
  }

}
