import java.util.*;

public class Solution {
  public boolean isPowerOfThree(int n) {
    if (n == 0) return false;

    return n == Math.pow(3, Math.round(Math.log(n)/Math.log(3)));
  }

  // recursive
  public boolean isPowerOfThree2(int n) {
    if (n == 0) return false;
    if (n == 1) return true;

    if (n > 1)
      return (n%3 == 0 && isPowerOfThree(n/3));
    else
      return false;
  }

  // iterative
  public boolean isPowerOfThree3(int n) {
    if (n == 0) return false;
    if (n == 1) return true;

    boolean result = false;
    while (n > 0) {
      int m = n%3;
      if (m == 0) {
        n /= 3;
        if (n ==1) return true;
      } else {
        return false;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};

    Solution obj = new Solution();
    
    System.out.printf("isPowerOfThree(%d): %b\n", 10, obj.isPowerOfThree(10));
    System.out.printf("isPowerOfThree(%d): %b\n", 9, obj.isPowerOfThree2(9));
    System.out.printf("isPowerOfThree(%d): %b\n", 27, obj.isPowerOfThree3(27));
  }
}


