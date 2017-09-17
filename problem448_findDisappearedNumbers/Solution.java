import java.util.*;

public class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> list = new LinkedList<>();
    
    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }
    
    for (int i = 0; i <nums.length; i++) {
      if (nums[i] > 0) {
        list.add(i+1);
      }
    }

    return list;
  }

  public static void main(String[] args) {
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

    Solution solution = new Solution();

    System.out.println(Arrays.toString(nums));
    System.out.println(solution.findDisappearedNumbers(nums));
  }
}


