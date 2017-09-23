import java.util.*;

public class Solution {
  public boolean checkPossibility(int[] nums) {
    int count = 0;
    for (int i = 1; i < nums.length && count <= 1; i++) {
      if (nums[i-1] > nums[i]) {
        count++;
        if (i-2 < 0 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
        else nums[i] = nums[i-1];
      }
    }
    return count<=1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = {4, 2, 3};
    System.out.printf("checkPossibility(%s) : %b\n", Arrays.toString(nums), solution.checkPossibility(nums));
    int[] nums2 = {3, 2, 4, 0};
    System.out.printf("checkPossibility(%s) : %b\n", Arrays.toString(nums2), solution.checkPossibility(nums2));
    int[] nums3 = {4, 2, 3, 1};
    System.out.printf("checkPossibility(%s) : %b\n", Arrays.toString(nums3), solution.checkPossibility(nums3));
  }
}

