import java.util.*;

public class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    
    int pointG = 0;
    int pointS = 0;
    while (pointG < g.length && pointS < s.length) {
      if (g[pointG] <= s[pointS]) {
        pointG++;
        pointS++;
      } else {
        pointS++;
      }
    }
    return pointG;
  }

  public static void main(String[] args) {
    int[] g = {1, 2};
    int[] s = {1, 2, 3};

    Solution solution = new Solution();

    System.out.println(Arrays.toString(g));
    System.out.println(Arrays.toString(s));
    System.out.printf("findContentChildren(): %d\n\n", solution.findContentChildren(g, s));
  }
}



