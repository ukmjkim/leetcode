import java.util.*;

public class Solution {
  public int searchInsert(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return i;
      }
    }
    return nums.length;
  }

  private static void runTest(int[] nums, int target, int expected) {
    Solution solution = new Solution();
    int result = solution.searchInsert(nums, target);
    if (result == expected) {
      System.out.println("Success");
    } else {
      System.out.println("Expected: " + expected + ", Result: " + result);
    }
  }

  public static void main(String[] args) {
	int[] nums = {1, 3, 5, 6};
    runTest(nums, 5, 2);
    runTest(nums, 2, 1);
    runTest(nums, 7, 4);
    runTest(nums, 0, 0);
  }
}
