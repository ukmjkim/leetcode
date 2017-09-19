import java.util.*;

public class Solution {
  public int findLUSlength(String a, String b) {
    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
  }
  
  public static void main(String[] args) {

    Solution solution = new Solution();

    String a = "abc";
    String b = "avbfc";
    System.out.printf("findLUSlength(%s, %s): %d\n", a, b, solution.findLUSlength(a, b));
  }
}



