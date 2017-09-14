import java.util.*;

public class Solution {
  public List<String> generatePossibleNextMoves(String s) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
        String flip = s.substring(0, i) + "--" + s.substring(i + 2);
        list.add(flip);
      }
    }
    return list;
  }
  
  public static void main(String[] args) {
    String[] testcase = {"+","-","++","--","+++","++++","+--+","-+-+","+-+-"};

    Solution solution = new Solution();
    for (int i = 0; i < testcase.length; i++) {
    	System.out.print("Test Case: " + testcase[i] + ", ");
    	System.out.println("Result: " + solution.generatePossibleNextMoves(testcase[i]));
    }
  }
}


