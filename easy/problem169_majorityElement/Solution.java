public class Solution {
    public int majorityElement(int[] nums) {
        int major=nums[0], count=1;
      
      for (int i=1; i < nums.length; i++) {
        if (count == 0) {
          count++;
          major = nums[i];
        } else if (major == nums[i]) {
          count++;
        } else count--;
      }
      return major;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 4};

        Solution solution = new Solution();
        int result = solution.majorityElement(nums);
        System.out.println("Result: " + result);
    }
}

