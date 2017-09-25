import java.util.*;

public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i-1]) nums[++count] = nums[i];
    }
    return ++count;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 2};
    
    Solution solution = new Solution();
    int result = solution.removeDuplicates(nums);
    System.out.println("Result: " + result);
  }
}

