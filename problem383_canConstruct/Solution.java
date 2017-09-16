import java.util.*;

public class Solution {
  public boolean canConstruct(String ransomeNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    char[] rArray = magazine.toCharArray();
    for (int i = 0; i < rArray.length; i++) {
      if (map.containsKey(rArray[i])) {
        map.put(rArray[i], map.get(rArray[i])+1);
      } else {
        map.put(rArray[i], 1);
      }
    }
    
    for (char c : ransomeNote.toCharArray()) {
      if (map.containsKey(c)) {
        if (map.get(c) == 0) {
          return false;
        } else {
          map.put(c, map.get(c)-1);
        }
      } else {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    String ransome;
    String magazine;

    Solution solution = new Solution();
    
    ransome = "a";
    magazine = "b";
    System.out.printf("can construct(%s, %s): %b\n", 
        ransome, magazine,
        solution.canConstruct(ransome, magazine));
    
    ransome = "aa";
    magazine = "bb";
    System.out.printf("can construct(%s, %s): %b\n", 
        ransome, magazine,
        solution.canConstruct(ransome, magazine));
    
    ransome = "aa";
    magazine = "aab";
    System.out.printf("can construct(%s, %s): %b\n", 
        ransome, magazine,
        solution.canConstruct(ransome, magazine));
  }
}


