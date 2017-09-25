import java.util.*;

public class Solution {
  public int numberOfBoomerangs (int[][] points) {
    int result = 0;
    
    Map<Integer, Integer> map = new HashMap<>();
    for (int i=0; i < points.length; i++) {
      for (int j=0; j <points.length; j++) {
        if (i == j) continue;
        
        int d = getDistance(points[i], points[j]);
        map.put(d, map.getOrDefault(d, 0) + 1);
      }
      
      for (int val : map.values()) {
        result += val * (val-1);  // the ways to pick up 2 points out of 5 points, 5P2 = n * (n-1)
      }
      map.clear();
    }
    return result;
  }

  private int getDistance(int[] a, int[] b) {
    int dx = a[0] - b[0];
    int dy = a[1] - b[1];
    
    return dx*dx + dy*dy;
  }

  public static void main(String[] args) {
    int[][] points = {
      {0, 0},
      {1, 0},
      {2, 0}
    };

    Solution solution = new Solution();

    System.out.printf("numberOfBoomerangs(): %d\n", solution.numberOfBoomerangs(points));
  }
}



