import java.util.*;

public class Solution {
  public int lengthOfLastWord(String str) {
    str = str.trim();
    return str.length() - str.lastIndexOf(" ") - 1;
  }

  public static void main(String[] args) {
    String str = "Hello World";
	Solution solution = new Solution();
    int result = solution.lengthOfLastWord(str);
    System.out.println("Result: " + result);
  }
}
