import java.util.*;

public class Solution {
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;

    // why it considers minimum numbers?, negative numbers
    return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-1]*nums[n-2]*nums[n-3]);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = {1, 2, 3};
    System.out.printf("maximumProduct(%s) => %d\n", Arrays.toString(nums), solution.maximumProduct(nums));

    int[] nums2 = {1, 2, 3, 4};
    System.out.printf("maximumProduct(%s) => %d\n", Arrays.toString(nums2), solution.maximumProduct(nums2));

    int[] nums3 = {-4, -3, -2, -1, 5};
    System.out.printf("maximumProduct(%s) => %d\n", Arrays.toString(nums3), solution.maximumProduct(nums3));

    int[] nums4 = {-4, -3, 1, 2, 5};
    System.out.printf("maximumProduct(%s) => %d\n", Arrays.toString(nums4), solution.maximumProduct(nums4));
  }
}
