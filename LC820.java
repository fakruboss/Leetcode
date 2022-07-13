package fakru.leetcode;

public class LC820 {

  public static void main(String[] args) {
    int i = new LC820().minimumLengthEncoding(new String[]{"time", "me", "bell"});
    System.out.println(i);
  }

  public int minimumLengthEncoding(String[] words) {
    Node trie = new Node();
    // add each word to trie tree
    for (String word : words) {
      add(trie, word);
    }
    // collect lengths with recursion
    return collect(trie);
  }

  private void add(Node trie, String word) {
    Node node = trie;
    for (int i = word.length() - 1; i >= 0; i--) {
      node = node.get(word.charAt(i));
    }
    node.word = word;
  }

  private int collect(Node node) {
    if (node == null) {
      return 0;
    }
    if (!node.hasChild) {
      return node.word.length() + 1;
    }
    int count = 0;
    for (Node n : node.next) {
      count += collect(n);
    }
    return count;
  }


}

class Node {

  Node[] next = new Node[26];
  boolean hasChild; // has children nodes, zero means a leave
  String word = null;

  public Node get(char c) {
    int i = c - 'a';
    if (next[i] == null) {
      next[i] = new Node();
      hasChild = true;
    }
    return next[i];
  }
}