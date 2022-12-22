package fakru.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC547 {

  public static void main(String[] args) {
    int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    int circleNumDFS = new LC547().findCircleNumDFS(M);
    int circleNumBFS = new LC547().findCircleNumBFS(M);
    System.out.println(circleNumDFS);
    System.out.println(circleNumBFS);
  }

  public int findCircleNumDFS(int[][] isConnected) {
    boolean[] visited = new boolean[isConnected.length];
    int count = 0;
    for (int i = 0; i < isConnected.length; ++i) {
      if (!visited[i]) {
        dfs(isConnected, visited, i);
        ++count;
      }
    }
    return count;
  }

  private void dfs(int[][] isConnected, boolean[] visited, int i) {
    for (int j = 0; j < isConnected.length; ++j) {
      if (isConnected[i][j] == 1 && !visited[j]) {
        visited[j] = true;
        dfs(isConnected, visited, j);
      }
    }
  }

  public int findCircleNumBFS(int[][] isConnected) {
    int count = 0;
    boolean[] visited = new boolean[isConnected.length];
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < isConnected.length; ++i) {
      if (!visited[i]) {
        ++count;
        q.offer(i);
      }

      while (!q.isEmpty()) {
        int curr = q.poll();
        visited[curr] = true;
        for (int j = 0; j < isConnected.length; ++j) {
          if (j != curr && isConnected[curr][j] == 1 && !visited[j]) {
            q.offer(j);
          }
        }
      }
    }
    return count;
  }
}