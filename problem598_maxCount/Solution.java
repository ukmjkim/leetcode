import java.util.*;

public class Solution {
  public int maxCount(int m, int n, int[][] ops) {
    if (ops == null || ops.length == 0) {
      return m*n;
    }

    int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
    for (int[] op : ops) {
      row = Math.min(row, op[0]);
      col = Math.min(col, op[1]);
    }
    return row*col;
  }

  private static void testFunction(int m, int n, int[][] ops) {
    Solution solution = new Solution();
    int result = solution.maxCount(m, n, ops);
    for (int[] op : ops) System.out.print(Arrays.toString(op));
    System.out.printf("\nmaxCount(%d, %d, ops) : %d\n", m, n, result);
  }

  public static void main(String[] args) {

    int[][] ops = {{2,2}, {3, 3}};
    testFunction(3, 3, ops);
  }
}

