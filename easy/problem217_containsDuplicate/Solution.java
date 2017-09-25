import java.util.*;

public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 3, 4, 2};
    Solution solution = new Solution();
    System.out.println("Duplicate: " + solution.containsDuplicate(nums));
  }
}


