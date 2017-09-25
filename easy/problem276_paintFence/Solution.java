import java.util.*;

// Assume that there are 3 colors
// 0 house, 0
// 1 house, k
// 2 house, same color = k*1, different color = k*(k-1)
//      -> k + k*(k-1)
// 3 house, different (k-1) (1) 1st 2 the same
//                          (2) lst 2 different
//      -> different = (same + different) * (k-1)
//      -> same = (different) * 1
public class Solution {
  public int numWays(int n, int k) {
    
    if (n == 0) return 0;
    if (n == 1) return k;

    int sameColor = k;
    int differColor = k*(k-1);
    for (int i = 3; i <= n; i++) {
      int preDiff = differColor;
      differColor = (sameColor + differColor) * (k-1);
      sameColor = preDiff * 1;
    }

    return sameColor + differColor;
  }

  public static void main(String[] args) {
    int numHouse = 3;
    int numColor = 3;

    Solution solution = new Solution();
    System.out.println("number of ways: " + solution.numWays(1, 3));
    System.out.println("number of ways: " + solution.numWays(2, 3));
    System.out.println("number of ways: " + solution.numWays(3, 3));
    System.out.println("number of ways: " + solution.numWays(4, 3));
  }
}

