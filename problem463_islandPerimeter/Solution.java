import java.util.*;

public class Solution {
  public int islandPerimeter(int[][] grid) {
    int count = 0;
    if (grid.length == 0) return count;
    
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          count = count + 4;

          if (i > 0 && grid[i-1][j] == 1) {
            count--;
          }
          if (i < grid.length-1 && grid[i+1][j] == 1) {
            count--;
          }
          if (j > 0 && grid[i][j-1] == 1) {
            count--;
          }
          if (j < grid[0].length-1 && grid[i][j+1] == 1) {
            count--;
          }
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] grid = {
      {0, 1, 0, 0},
      {1, 1, 1, 0},
      {0, 1, 0, 0},
      {1, 1, 0, 0}
    };
    
    for (int i = 0; i < grid.length; i++) {
      System.out.println(Arrays.toString(grid[i]));
    }
    System.out.printf("islandPerimeter(): %d\n\n", solution.islandPerimeter(grid));
  }
}



