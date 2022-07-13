package fakru.leetcode;

public class LC463 {

  public int islandPerimeter(int[][] grid) {
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
        if (grid[i][j] == 1) {
          return dfs(i, j, grid);
        }
      }
    }
    return -1;
  }

  private int dfs(int i, int j, int[][] grid) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == 0) {
      return 0;
    }
    grid[i][j] = 0;
    return 1
        + dfs(i + 1, j, grid)
        + dfs(i - 1, j, grid)
        + dfs(i, j + 1, grid)
        + dfs(i, j - 1, grid);
  }

  public static void main(String[] args) {
    int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
    LC463 lc463 = new LC463();
    int i = lc463.islandPerimeter(grid);
    System.out.println(i);
  }
}
