import java.util.*;

public class Solution {
  public int findRadius(int[] houses, int[] heaters) {
	Arrays.sort(heaters);
    int result = Integer.MIN_VALUE;
    
    for (int house : houses) {
      // Returns : (-(insertion point) - 1) if not found
      int index = Arrays.binarySearch(heaters, house);
      if (index < 0) {
        index = -index - 1;
        int dist1 = index - 1 >= 0 ? house - heaters[index-1] : Integer.MAX_VALUE;
        int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
      
        result = Math.max(result, Math.min(dist1, dist2));
      }
    }
    
    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] houses = {1, 2, 3};
    int[] heaters = {3};
    
    System.out.println(Arrays.toString(houses));
    System.out.println(Arrays.toString(heaters));
    System.out.printf("findRadius(): %d\n\n", solution.findRadius(houses, heaters));

    int[] houses2 = {1, 2, 3, 4};
    int[] heaters2 = {1, 4};
    
    System.out.println(Arrays.toString(houses2));
    System.out.println(Arrays.toString(heaters2));
    System.out.printf("findRadius(): %d\n\n", solution.findRadius(houses2, heaters2));
  }
}



