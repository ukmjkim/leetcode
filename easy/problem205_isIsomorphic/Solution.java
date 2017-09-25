import java.util.*;

public class Solution {
  public boolean isIsomorphic(String s, String t) {
    HashMap<Character,Character> maps = new HashMap<>();
    int length = s.length();
    if(length!=t.length())
      return false;

    char[] schar = s.toCharArray();
    char[] tchar = t.toCharArray();
    for(int i = 0;i<length;i++) {
      char sval = schar[i];
      char tval = tchar[i];

      if (maps.containsKey(sval)) {
        char tmp = maps.get(sval);
        if (tmp!=tval)
          return false;
      } else {
        if(maps.containsValue(tval))//multi map
          return false;
        maps.put(sval,tval);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s1 = "egg";
    String s2 = "add";

    Solution solution = new Solution();
    System.out.println("Result: " + solution.isIsomorphic(s1, s2));
  }
}

