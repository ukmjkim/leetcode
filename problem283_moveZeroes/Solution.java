// 0 -> {0, 1} -> {1, 0}
// 1 -> {1, 0, 0} -> {1, 0, 0}
// 2 -> {1, 0, 0, 3}
import java.util.*;
public class Solution {
  public void moveZeroes(int[] nums) {
    int i=0;
    int count = 0;
    while (i + count < nums.length) {
      if (nums[i] == 0) {
        count++;
        for (int j = i; j < nums.length-1; j++) {
          nums[j] = nums[j+1];
          nums[j+1] = 0;
        }
      } else {
        i++;
      }
    }
  }
  
  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};

    Solution solution = new Solution();
    solution.moveZeroes(nums);
    System.out.println("firstBadVersion: " + Arrays.toString(nums));
  }
}

