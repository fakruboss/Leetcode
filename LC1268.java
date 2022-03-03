package fakru.leetcode;

import fakru.leetcode.node.TrieNode;
import java.util.ArrayList;
import java.util.List;

public class LC1268 {

  private TrieNode constructTrie(TrieNode root, String[] products) {
    for (String product : products) {
      TrieNode temp = root;
      for (char c : product.toCharArray()) {
        if (temp.children[c - 'a'] == null) {
          temp.children[c - 'a'] = new TrieNode();
        }
        temp = temp.children[c - 'a'];
      }
      temp.isWord = true;
    }
    return root;
  }

  private List<String> dfsWithPrefix(TrieNode curr, String word, List<String> list) {
    if (list.size() == 3) {
      return list;
    }
    if (curr.isWord) {
      list.add(word);
    }
    for (char c = 'a'; c <= 'z'; ++c) {
      if (curr.children[c - 'a'] != null) {
        dfsWithPrefix(curr.children[c - 'a'], word + c, list);
      }
    }
    return list;
  }

  private List<String> getWordsWithPrefix(StringBuilder prefix, TrieNode root) {
    for (char c : prefix.toString().toCharArray()) {
      if (root.children[c - 'a'] == null) {
        return new ArrayList<>();
      }
      root = root.children[c - 'a'];
    }
    return dfsWithPrefix(root, prefix.toString(), new ArrayList<>());
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> result = new ArrayList<>();
    TrieNode root = constructTrie(new TrieNode(), products);
    StringBuilder prefix = new StringBuilder();
    for (char c : searchWord.toCharArray()) {
      prefix.append(c);
      result.add(getWordsWithPrefix(prefix, root));
    }
    return result;
  }

  public static void main(String[] args) {
    List<List<String>> mouse = new LC1268().suggestedProducts(
        new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
    System.out.println(mouse);
  }
}
