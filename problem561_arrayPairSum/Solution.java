import java.util.*;

public class Solution {
  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    int i = 0;
    while (i < nums.length) {
      sum += Math.min(nums[i], nums[i+1]);
      i += 2;
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] nums = {1, 4, 3, 2};

    Solution solution = new Solution();
    System.out.println(Arrays.toString(nums));
    System.out.printf("arrayPairSum() : %d\n", solution.arrayPairSum(nums));
  }
}
