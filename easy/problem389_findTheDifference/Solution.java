import java.util.*;

public class Solution {
  public char findTheDifference(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    char[] rArray = s.toCharArray();
    for (int i = 0; i < rArray.length; i++) {
      if (map.containsKey(rArray[i])) {
        map.put(rArray[i], map.get(rArray[i])+1);
      } else {
        map.put(rArray[i], 1);
      }
    }
    
    for (char c : t.toCharArray()) {
      if (map.containsKey(c)) {
        if (map.get(c) == 0) {
          return c;
        } else {
          map.put(c, map.get(c)-1);
        }
      } else {
        return c;
      }
    }
    return ' ';
  }
  
  public static void main(String[] args) {
    String s;
    String t;

    Solution solution = new Solution();
    
    s = "a";
    t = "aa";
    System.out.printf("can construct(%s, %s): %c\n", s, t, solution.findTheDifference(s, t));
    
    s = "adef";
    t = "aedfg";
    System.out.printf("can construct(%s, %s): %c\n", s, t, solution.findTheDifference(s, t));
    
    s = "ztat";
    t = "thazt";
    System.out.printf("can construct(%s, %s): %c\n", s, t, solution.findTheDifference(s, t));
  }
}

