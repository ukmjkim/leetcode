public class Solution {
    public int maxSubArray(int[] nums) {
      int n = nums.length;
      int[] maxSubArr = new int[n];
      maxSubArr[0] = nums[0];
      int max = maxSubArr[0];
      
      for (int i = 1; i < n; i++) {
        maxSubArr[i] = nums[i] + (maxSubArr[i-1] > 0 ? maxSubArr[i-1] : 0);
        max = Math.max(max, maxSubArr[i]);
      }
      
      return max;
    }

	public static void main(String[] args) {
		int[] prices = {-2,1,-3,4,-1,2,1,-5,4};

		Solution solution = new Solution();
		int maxSubArr = solution.maxSubArray(prices);
		System.out.println("Result: " + maxSubArr);	
	}
}
