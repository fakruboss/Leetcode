package fakru.leetcode;

public class LC200 {

  public void dfs(char[][] grid, int i, int j) {
    if (i < 0 || i > grid.length - 1
        || j < 0 || j > grid[0].length - 1
        || grid[i][j] != '1') {
      return;
    }
    grid[i][j] = '0';
    dfs(grid, i - 1, j);
    dfs(grid, i + 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i, j + 1);
  }

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          ++count;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    char[][] map = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}};
    LC200 lc200 = new LC200();
    System.out.println(lc200.numIslands(map));
  }
}