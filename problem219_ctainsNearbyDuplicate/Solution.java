import java.util.*;

public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int distance) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        int value = map.get(nums[i]);
        if (distance >= i - value) {
          return true;
        }
      }
      map.put(nums[i], i);
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    int[] nums = {1, 2, 1, 3, 4, 5, 3, 4, 2};
	int distance = 2;

    Solution solution = new Solution();
    System.out.println("Duplicate: " + solution.containsNearbyDuplicate(nums, distance));
  }
}


