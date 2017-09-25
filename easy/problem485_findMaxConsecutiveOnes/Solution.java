import java.util.*;

public class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int consecutiveCount = (nums[0] == 1) ? 1 : 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i-1] && nums[i] == 1) {
        consecutiveCount++;
      } else {
        max = Math.max(max, consecutiveCount);
        consecutiveCount = (nums[i] == 1) ? 1 : 0;
      }
    }
    return max = Math.max(max, consecutiveCount);
  }
  
  public static void main(String[] args) {
    Solution solution = new Solution();
    
    int[] nums1 = {1,1,0,1,1,1};
    System.out.println(Arrays.toString(nums1));
    System.out.println(solution.findMaxConsecutiveOnes(nums1));
    
    int[] nums2 = {1,0,1,1,0,1};
    System.out.println(Arrays.toString(nums2));
    System.out.println(solution.findMaxConsecutiveOnes(nums2));
    
    int[] nums3 = {0};
    System.out.println(Arrays.toString(nums3));
    System.out.println(solution.findMaxConsecutiveOnes(nums3));
    
    int[] nums4 = {1};
    System.out.println(Arrays.toString(nums4));
    System.out.println(solution.findMaxConsecutiveOnes(nums4));
    
    int[] nums5 = {0,1};
    System.out.println(Arrays.toString(nums5));
    System.out.println(solution.findMaxConsecutiveOnes(nums5));
  }
}
