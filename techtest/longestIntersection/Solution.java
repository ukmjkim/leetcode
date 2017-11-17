import java.util.*;

public class Solution {
    public int solution(String s) {
      int lastIndex = s.length();

      Set<String> prefixSet = new HashSet<>();

      String previousPref = "";
      for (int i=1; i < lastIndex; i++) {
        previousPref = s.substring(0, i);
        prefixSet.add(previousPref);
      }

      for (int i=1; i < lastIndex; i++) {
        if (prefixSet.contains(s.substring(i))) {
          return lastIndex-i;
        }
      }
      return 0;
    }
}

