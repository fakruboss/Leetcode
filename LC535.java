package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Codec535 {

  private static final String allChars = "abcdefghijklmnopqrstuvwxyz0123456789";
  private final Map<String, String> short2long;
  private final Map<String, String> long2short;
  private final Random random;

  public Codec535() {
    short2long = new HashMap<>();
    long2short = new HashMap<>();
    random = new Random();
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    while (!long2short.containsKey(longUrl)) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 6; ++i) {
        sb.append(allChars.charAt(random.nextInt(allChars.length())));
      }
      if (!short2long.containsKey(sb.toString())) {
        short2long.put(sb.toString(), longUrl);
        long2short.put(longUrl, sb.toString());
        break;
      }
    }
    return "https://tinyurl.com/" + long2short.get(longUrl);
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    return short2long.get(shortUrl.substring(20));
  }
}

public class LC535 {

  public static void main(String[] args) {
    Codec535 codec535 = new Codec535();
    System.out.println(codec535.encode("https://leetcode.com/problems/design-tinyurl"));
    System.out.println(codec535.encode("https://leetcode.com/problems/design-tinyurl1"));
    System.out.println(codec535.encode("https://leetcode.com/problems/design-tinyurl2"));
    System.out.println(codec535.encode("https://leetcode.com/problems/design-tinyurl3"));
    System.out.println(codec535.encode("https://leetcode.com/problems/design-tinyurl"));
    System.out.println(codec535.encode("https://leetcode.com/problems/design-tinyurl1"));
    System.out.println(codec535.encode("https://leetcode.com/problems/design-tinyurl2"));
    System.out.println(codec535.encode("https://leetcode.com/problems/design-tinyurl3"));
  }
}