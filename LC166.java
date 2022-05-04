package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC166 {

  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }
    StringBuilder res = new StringBuilder();
    // "+" or "-"
    res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
    long num = Math.abs((long) numerator);
    long den = Math.abs((long) denominator);

    // integral part
    res.append(num / den);
    num %= den;
    if (num == 0) {
      return res.toString();
    }

    // fractional part
    res.append(".");
    Map<Long, Integer> map = new HashMap<>();
    map.put(num, res.length());
    while (num != 0) {
      num *= 10;
      res.append(num / den);
      num %= den;
      if (map.containsKey(num)) {
        int index = map.get(num);
        res.insert(index, "(");
        res.append(")");
        break;
      } else {
        map.put(num, res.length());
      }
    }
    return res.toString();
  }

  public String fractionToDecimal2(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder((numerator > 0) ^ (denominator > 0) ? "-" : "");
    long num = Math.abs((long) numerator);
    long den = Math.abs((long) denominator);
    sb.append(num / den);
    long rem = num % den;
    if (rem == 0) {
      return sb.toString();
    }
    sb.append(".");
    Map<Long, Integer> map = new HashMap<>();
    map.put(rem, sb.length());
    while (rem != 0) {
      rem = rem * 10;
      sb.append(rem / den);
      rem = rem % den;
      if (map.containsKey(rem)) {
        return sb.insert(map.get(rem), "(").append(")").toString();
      } else {
        map.put(rem, sb.length());
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new LC166().fractionToDecimal2(-1, -2147483648));
  }
}
