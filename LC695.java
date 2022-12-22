package fakru.leetcode;

public class LC695 {

  public int maxAreaOfIsland(int[][] grid) {
    int maxArea = 0;
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
        if (grid[i][j] == 1) {
          maxArea = Math.max(maxArea, maxAreaOfIsland(grid, i, j));
        }
      }
    }
    return maxArea;
  }

  private int maxAreaOfIsland(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j < grid[0].length
        || grid[i][j] == 0) {
      return 0;
    }
    grid[i][j] = 0;
    return 1 + maxAreaOfIsland(grid, i + 1, j)
        + maxAreaOfIsland(grid, i - 1, j)
        + maxAreaOfIsland(grid, i, j + 1)
        + maxAreaOfIsland(grid, i, j - 1);
  }

  public static void main(String[] args) {
    int[][] mat = {
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    new LC695().maxAreaOfIsland(mat);
  }
}