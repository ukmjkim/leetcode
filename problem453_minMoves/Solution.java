import java.util.*;

public class Solution {
  public int minMoves(int[] nums) {
    int sum = 0;
    int min = Integer.MAX_VALUE;

    for (int num : nums) {
      sum += num;
      min = Math.min(min, num);
    }

    return sum - (min*nums.length);
  }
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = {1, 2, 3};
    System.out.printf("minMoves(%s) : %d\n", Arrays.toString(nums), solution.minMoves(nums));
  }
}

