import java.util.*;

public class Solution {
  public int findLengthOfLCIS(int[] nums) {
    int max = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || nums[i-1] < nums[i]) max = Math.max(max, ++count);
      else count = 1;
    }
    return max;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = {1, 3, 5, 4, 7};
    System.out.printf("findLengthOfLCIS(%s) : %d\n", Arrays.toString(nums), solution.findLengthOfLCIS(nums));

    int[] nums2= {2, 2, 2, 2, 2};
    System.out.printf("findLengthOfLCIS(%s) : %d\n", Arrays.toString(nums2), solution.findLengthOfLCIS(nums2));
  }
}

