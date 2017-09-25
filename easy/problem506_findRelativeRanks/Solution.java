import java.util.*;

public class Solution {
  public String[] findRelativeRanks(int[] nums) {
    int[][] pair = new int[nums.length][2];
    
    for (int i = 0; i < nums.length; i++) {
      pair[i][0] = nums[i];
      pair[i][1] = i;
    }
    
    Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
    
    String[] result = new String[nums.length];
    
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        result[pair[i][1]] = "Gold Medal";
      } else if (i == 1) {
        result[pair[i][1]] = "Silver Medal";
      } else if (i == 2) {
        result[pair[i][1]] = "Bronze Medal";
      } else {
        result[pair[i][1]] = (i + 1) + "";
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {

    Solution solution = new Solution();

    int[] nums = {5, 4, 3, 2, 1};
    System.out.println(Arrays.toString(nums));
    System.out.println("findRelativeRanks()");
    System.out.println(Arrays.toString(solution.findRelativeRanks(nums)));

    int[] nums2 = {10, 3, 8, 9, 4};
    System.out.println(Arrays.toString(nums2));
    System.out.println("findRelativeRanks()");
    System.out.println(Arrays.toString(solution.findRelativeRanks(nums2)));
  }
}



