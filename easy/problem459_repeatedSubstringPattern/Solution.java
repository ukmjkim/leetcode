import java.util.*;

public class Solution {
  public boolean repeatedSubstringPattern(String s) {
    int len = s.length();
    for (int i=len/2; i >= 1; i--) {
      if (len % i == 0) {
        int m = len / i;
        String subStr = s.substring(0, i);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
          sb.append(subStr);
        }
        if (sb.toString().equals(s)) return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String s;

    Solution solution = new Solution();

    s = "abab";
    System.out.printf("repeatedSubstringPattern(%s): %b\n\n", s, solution.repeatedSubstringPattern(s));

    s = "ababab";
    System.out.printf("repeatedSubstringPattern(%s): %b\n\n", s, solution.repeatedSubstringPattern(s));
  }
}



