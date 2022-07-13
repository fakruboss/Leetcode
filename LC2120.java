package fakru.leetcode;

import java.util.Arrays;

public class LC2120 {

  private int[] moveDir(char c, int[] dir) {
    if (c == 'L') {
      dir[1] -= 1;
    } else if (c == 'R') {
      dir[1] += 1;
    } else if (c == 'U') {
      dir[0] -= 1;
    } else {
      dir[0] += 1;
    }
    return dir;
  }

  private boolean isValidMove(int[] pos, int n) {
    return pos[0] >= 0 && pos[0] < n && pos[1] >= 0 && pos[1] < n;
  }

  public int[] executeInstructions(int n, int[] startPos, String s) {
    int[] result = new int[s.length()];
    for (int i = 0; i < s.length(); ++i) {
      int[] curr = new int[startPos.length];
      System.arraycopy(startPos, 0, curr, 0, startPos.length);
      int count = 0;
      for (int j = i; j < s.length(); ++j) {
        moveDir(s.charAt(j), curr);
        if (!isValidMove(curr, n)) {
          break;
        }
        ++count;
      }
      result[i] = count;
    }
    return result;
  }

  public static void main(String[] args) {
    LC2120 lc120 = new LC2120();
    int[] rrddlus = lc120.executeInstructions(1, new int[]{0, 0}, "LRUD");
    System.out.println(Arrays.toString(rrddlus));
  }
}
