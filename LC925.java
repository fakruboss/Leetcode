package fakru.leetcode;

public class LC925 {

  public static void main(String[] args) {
    boolean longPressedName = new LC925().isLongPressedName("vtkgn", "vttkgnn");
    System.out.println(longPressedName);
  }

  public boolean isLongPressedName(String name, String typed) {
    if (name.charAt(0) != typed.charAt(0)) {
      return false;
    }
    int i = 1, j = 1;
    while (i < typed.length() && j < name.length()) {
      if (typed.charAt(i) == name.charAt(j)) {
        ++j;
      } else if (typed.charAt(i) == typed.charAt(i - 1)) {

      } else {
        return false;
      }
      ++i;
    }
    return i == typed.length() && j == name.length();
  }
}
