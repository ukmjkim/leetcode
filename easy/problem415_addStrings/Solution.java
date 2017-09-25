import java.util.*;

public class Solution {
  public String addStrings(String num1, String num2) {
    String addStr = "";
    int carry = 0;
    int i = num1.length()-1;
    int j = num2.length()-1;
    while (true) {
      if (i < 0 && j < 0) {
        if (carry > 0) {
          addStr = carry + addStr;
        }
        return addStr;
      }
      int num1Value = i < 0 ? 0 : Character.getNumericValue(num1.charAt(i));
      int num2Value = j < 0 ? 0 : Character.getNumericValue(num2.charAt(j));
      
      int newValue = (carry + num1Value + num2Value) % 10;
      addStr = newValue + addStr;

      if (carry + num1Value + num2Value >= 10) {
        carry = 1;
      } else {
        carry = 0;
      }
      i--;
      j--;
    }
  }

  public static void main(String[] args) {
    String num1 = "321";
    String num2 = "45";
 
    Solution solution = new Solution();

    num1 = "1";
    num2 = "9";
    System.out.printf("addStrings(%s, %s): %s\n", num1, num2, solution.addStrings(num1, num2));

    num1 = "321";
    num2 = "745";
    System.out.printf("addStrings(%s, %s): %s\n", num1, num2, solution.addStrings(num1, num2));

    num1 = "23321";
    num2 = "45";
    System.out.printf("addStrings(%s, %s): %s\n", num1, num2, solution.addStrings(num1, num2));

    num1 = "4154321";
    num2 = "45";
    System.out.printf("addStrings(%s, %s): %s\n", num1, num2, solution.addStrings(num1, num2));
  }
}


