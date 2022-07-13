package fakru.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC929 {

  public int numUniqueEmails(String[] emails) {
    Set<String> emailSet = new HashSet<>();
    for (String email : emails) {
      String[] names = email.split("@");
      String localName = names[0].replaceAll("\\.", "");
      String domainName = names[1];
      if (localName.contains("+")) {
        localName = localName.substring(0, localName.indexOf("+"));
      }
      emailSet.add(localName + "@" + domainName);
    }
    return emailSet.size();
  }

  public static void main(String[] args) {
    int i = new LC929().numUniqueEmails(
        new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"});
    System.out.println(i);
  }
}
