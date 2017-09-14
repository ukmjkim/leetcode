/*
  n winning
  1 true
  2 true
  3 true
  4 false
  5 true
  6 true
  7 true
  8 false
  i = 3
  while (i <= n)
  
  4-1 lose &&
  4-2 lose &&
  4-3 lose    -> lose
*/
  
import java.util.*;

public class Solution {
  public boolean canWinNim(int n) {
    return (n % 4) != 0;
  }
  
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("Result: " + solution.canWinNim(8));
    System.out.println("Result: " + solution.canWinNim(7));
  }
}


