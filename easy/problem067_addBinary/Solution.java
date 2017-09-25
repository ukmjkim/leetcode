import java.util.*;

public class Solution {
  public String addBinary(String a, String b) {
    int idxA = a.length()-1;
    int idxB = b.length()-1;
    
    int carry = 0;
    String newNumber = "";
    while (true) {
      int digitA = 0;
      int digitB = 0;
      if (idxA < 0 && idxB < 0) break;
      digitA = idxA < 0 ? 0 : Character.getNumericValue(a.charAt(idxA));
      digitB = idxB < 0 ? 0 : Character.getNumericValue(b.charAt(idxB));

      newNumber = ((digitA + digitB + carry) % 2) + newNumber;
      carry = ((digitA + digitB + carry) > 1) ? 1 : 0;

      System.out.print("a[" + idxA + "]=" + digitA + ", b[" + idxB + "]=" + digitB + " ");
      System.out.println("newNumber: " + newNumber + ", carry: " + carry);

      idxA--;
      idxB--;
    }

    if (carry > 0) {
      newNumber = "1" + newNumber;
    }
    return newNumber;
  }

  public static void main(String[] args) {
    String a = "1010";
    String b = "1011";
	Solution solution = new Solution();
    String result = solution.addBinary(a, b);
    System.out.println("Result: " + result);
  }
}
