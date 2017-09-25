public class Solution {
  public int rob(int[] nums) {
    int[][] dp = new int[nums.length + 1][2];
    for (int i = 1; i <= nums.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = nums[i - 1] + dp[i - 1][0];
    }
    return Math.max(dp[nums.length][0], dp[nums.length][1]);
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 2, 2, 4};

    Solution solution = new Solution();
    System.out.println("rob(): " + solution.rob(nums));
  }
}

