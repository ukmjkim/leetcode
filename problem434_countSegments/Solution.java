import java.util.*;

public class Solution {
  public int countSegments(String s) {
    if (s == null || s.length() == 0) return 0;

    int count = 0;
    boolean spaceStart = false;
    boolean spaceEnd = false;
    int start = 0;
    int end = s.length()-1;
    while (start < end) {
      if (spaceStart == false && s.charAt(start) == ' ') {
        count++;
        spaceStart = true;
      } else if (s.charAt(start) != ' ') {
        spaceStart = false;
      }
      if (spaceEnd == false && s.charAt(end) == ' ') {
        count++;
        spaceEnd = true;
      } else if (s.charAt(end) != ' ') {
        spaceEnd = false;
      }
      start++;
      end--;
    }
    
    return count+1;
  }

  public static void main(String[] args) {
    String s;
 
    Solution solution = new Solution();

    s = "Hello, my name is John";
    System.out.printf("countSegments(%s): %d\n", s, solution.countSegments(s));

    s = "Hello, my   name is John";
    System.out.printf("countSegments(%s): %d\n", s, solution.countSegments(s));
  }
}


