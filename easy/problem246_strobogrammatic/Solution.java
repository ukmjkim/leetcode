import java.util.*;

public class Solution {
  public boolean isStrobogrammatic(String num) {
    if (num == null || num.length() == 0) return false;
    
    int lo = 0, hi = num.length() - 1;
    
    Map<Character, Character> map = new HashMap<>();
    map.put('0', '0');
    map.put('1', '1');
    map.put('6', '9');
    map.put('8', '8');
    map.put('9', '6');
    
    while (lo <= hi) {
      char cLo = num.charAt(lo);
      if (!map.containsKey(cLo)) {
        return false;
      } else if (map.get(cLo) != num.charAt(hi)) {
        return false;
      } else {
        lo++;
        hi--;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String num = "69";

    Solution solution = new Solution();
    boolean result = solution.isStrobogrammatic(num);
    System.out.println("Strobogrammatic: " + result);
  }
}


