package fakru.leetcode;

/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * <p>Input: nums = [2,3,1,1,4]</p>
 *
 * <p>Output: 2</p>
 *
 * <p>Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index
 * 0 to 1, then 3 steps to the last index.</p>
 */
public class LC45 {

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 1, 4};
    LC45Demo demo = new LC45Demo();
    demo.jump(nums);
  }
}

class LC45Demo {

  public int jump(int[] A) {
    int jumps = 0, curEnd = 0, curFarthest = 0;
    for (int i = 0; i < A.length - 1; i++) {
      curFarthest = Math.max(curFarthest, i + A[i]);
      if (i == curEnd) {
        jumps++;
        curEnd = curFarthest;
      }
    }
    return jumps;
  }
}
