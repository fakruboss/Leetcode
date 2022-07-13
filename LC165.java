package fakru.leetcode;

public class LC165 {

  public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int max = Math.max(v1.length, v2.length);
    for (int i = 0; i < max; ++i) {
      Integer val1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
      Integer val2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
      int res = val1.compareTo(val2);
      if (res != 0) {
        return res;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int i = new LC165().compareVersion("1.01", "1.001");
    System.out.println(i);
  }
}
