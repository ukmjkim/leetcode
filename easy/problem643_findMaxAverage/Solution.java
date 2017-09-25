import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Solution {
  public double findMaxAverage(int[] nums, int k) {
    long sum = 0;
    for (int i = 0; i < k; i++) sum += nums[i];
    long max = sum;

    for (int i = k; i < nums.length; i++) {
      sum += nums[i] - nums[i-k];
      max = Math.max(max, sum);
    }

    return max / 1.0 / k;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    DecimalFormat form = new DecimalFormat("#.##");
    form.setRoundingMode(RoundingMode.HALF_UP);

    int[] nums = {1, 12, -5, -6, 50, 3};
    int k = 4;

    System.out.printf("findMaxAverage(%s, %d) : %s\n", Arrays.toString(nums), k, form.format(solution.findMaxAverage(nums, k)));
  }
}

