import java.util.*;

public class Solution {
  public int removeElement(int[] nums, int target) {
    if (nums.length == 0) return 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != target) nums[count++] = nums[i];
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 2, 3, 4};
    int target = 3;
    
    Solution solution = new Solution();
    int result = solution.removeElement(nums, target);
    System.out.println("Result: " + result);
  }
}

