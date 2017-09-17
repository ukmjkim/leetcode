import java.util.*;

public class Solution {
  public int arrangeCoins(int n) {
    int start = 0;
    int end = n;
    int mid = 0;
    
    while (start <= end) {
      // it effectively divides the operand by 2 and prevents overflow
      mid = (start + end) >>> 1;
      if ((mid * (mid + 1)) / 2 <= n)
        start = mid + 1;
      else
        end = mid - 1;
    }
    return start-1;
  }

  public static void main(String[] args) {
    int n;

    Solution solution = new Solution();

    n = 5;
    System.out.printf("arrangeCoins(%d): %d\n", n, solution.arrangeCoins(n));

    n = 8;
    System.out.printf("arrangeCoins(%d): %d\n", n, solution.arrangeCoins(n));
  }
}


