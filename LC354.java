package fakru.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC354 {

  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
    List<Integer> result = new ArrayList<>();
    result.add(envelopes[0][1]);
    for (int i = 1; i < envelopes.length; ++i) {
      if (result.get(result.size() - 1) < envelopes[i][1]) {
        result.add(envelopes[i][1]);
      } else {
        int idx = Collections.binarySearch(result, envelopes[i][1]);
        result.set(idx < 0 ? -idx - 1 : idx, envelopes[i][1]);
      }
    }
    return result.size();
  }

}
