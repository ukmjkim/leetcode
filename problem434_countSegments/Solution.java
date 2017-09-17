import java.util.*;

public class Solution {
  public int countSegments(String s) {
    if (s == null || s.length() == 0) return 0;

    int count = 0;
    char prevChar = ' ';
    for (int i = 0; i < s.length(); i++) {
      if (prevChar == ' ' && s.charAt(i) != ' ') {
        count++;
      }
      prevChar = s.charAt(i);
    }
        
    
    return count;
  }

  public static void main(String[] args) {
    String s;
 
    Solution solution = new Solution();

    s = "Hello, my name is John";
    System.out.printf("countSegments(%s): %d\n", s, solution.countSegments(s));

    s = "Hello, my   name is John";
    System.out.printf("countSegments(%s): %d\n", s, solution.countSegments(s));

    s = "         ";
    System.out.printf("countSegments(%s): %d\n", s, solution.countSegments(s));

    s = "Hello";
    System.out.printf("countSegments(%s): %d\n", s, solution.countSegments(s));
  }
}

