package fakru.leetcode;

import static fakru.leetcode.utils.PrintUtils.print;

import java.util.*;

public class LC811 {

  public List<String> subdomainVisits(String[] cpdomains) {
    List<String> result = new ArrayList<>();
    Map<String, Integer> domainVisits = new HashMap<>();
    for (String cpdomain : cpdomains) {
      int i = cpdomain.indexOf(" ");
      int count = Integer.parseInt(cpdomain.substring(0, i));
      String domains = cpdomain.substring(i + 1);
      for (i = 0; i < domains.length(); ++i) {
        if (domains.charAt(i) == '.') {
          String x = domains.substring(i + 1);
          domainVisits.put(x, domainVisits.getOrDefault(x, 0) + count);
        }
      }
      domainVisits.put(domains, domainVisits.getOrDefault(domains, 0) + count);
    }
    for (String key : domainVisits.keySet()) {
      result.add(domainVisits.get(key) + " " + key);
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> strings = new LC811().subdomainVisits(
        new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
    print(strings);
  }
}