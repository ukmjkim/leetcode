import java.util.*;

public class Solution {
  public int[][] imageSmoother(int[][] M) {
    if (M == null) return null;
    if (M.length == 0) return new int[0][];

    int rows = M.length;
    int cols = M[0].length;
    int result[][] = new int[rows][cols];

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int min_row = (row == 0) ? 0 : row - 1;
        int max_row = (row == rows - 1) ? rows - 1 : row + 1;
        int min_col = (col == 0) ? 0 : col - 1;
        int max_col = (col == cols - 1) ? cols - 1 : col + 1;

        int sum = 0;
        int count = 0;
        for (int i = min_row; i <= max_row; i++) {
          for (int j = min_col; j <= max_col; j++) {
            sum += M[i][j];
            count ++;
          }
        }
        result[row][col] = sum / count;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] M = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    for (int[] m : M) {
      System.out.println(Arrays.toString(m));
    }
    System.out.println("");

    int[][] result = solution.imageSmoother(M);
    for (int[] m : result) {
      System.out.println(Arrays.toString(m));
    }
  }
}
