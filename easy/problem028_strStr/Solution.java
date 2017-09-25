import java.util.*;

public class Solution {
  public int strStr(String haystack, String needle) {
    if (haystack.length() == 0 && needle.length() == 0) return 0;
    if (haystack.length() < needle.length()) return -1;

    int matchCount = 0;
    for (int i = 0; i < haystack.length(); i++) {
      for (int j = 0; j < needle.length(); j++) {
        if (i+j > haystack.length() - 1) return -1;
        if (needle.charAt(j) != haystack.charAt(i+j)) {
          break;
        }
        matchCount++;
      }
      if (needle.length() == matchCount) {
        return i;
      }
      matchCount = 0;
    }

    return -1;
  }

  public static void main(String[] args) {
    String haystack = "mississippi";
    String needle = "issipi";
    
    Solution solution = new Solution();
    int result = solution.strStr(haystack, needle);
    System.out.println("Result: " + result);
  }
}

