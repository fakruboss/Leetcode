package fakru.leetcode;

import fakru.leetcode.node.ListNode;
import java.util.ArrayList;
import java.util.List;

public class LC125 {

  public boolean isPalindrome(String s) {
    String alphabs = "abcdefghijklmnopqrstuvwxyz";
    s = s.toLowerCase();
    int left = 0, right = s.length() - 1;
    while (left < right) {
      while (alphabs.indexOf(s.charAt(left)) == -1 && left < right) {
        ++left;
        if (left == right) {
          return false;
        }
      }
      while (alphabs.indexOf(s.charAt(right)) == -1 && left < right) {
        --right;
        if (left == right) {
          return false;
        }
      }
      System.out.println(s.charAt(left) + " " + s.charAt(right));
      if (s.charAt(left++) != s.charAt(right--)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    new LC125().isPalindrome("A man, a plan, a canal: Panama");
    List<ListNode> mergedLists = new ArrayList<>();
    mergedLists.remove(1);

  }
}
