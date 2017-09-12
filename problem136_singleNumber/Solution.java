// num XOR num == 0
public class Solution {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result ^= nums[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 7, 9, 9, 7, 5, 1};
    
    Solution solution = new Solution();
    System.out.println("Result: " + solution.singleNumber(nums));
  }
}

