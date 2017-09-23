import java.util.*;

public class Solution {
  public int[] findErrorNums(int[] nums) {
    // The missing value is total - (sum - duplicate)
    Set<Integer> set = new HashSet<>();
    int duplicate = 0, n = nums.length;
    long sum = (n * (n+1)) / 2;
    for (int i : nums) {
      if (set.contains(i)) duplicate = i;
      sum -= i;
      set.add(i);
    }

    return new int[] {duplicate, (int) sum + duplicate};
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = {1, 2, 2, 4};
    System.out.printf("findErrorNums(%s) = %s\n", Arrays.toString(nums), Arrays.toString(solution.findErrorNums(nums)));
  }
}

