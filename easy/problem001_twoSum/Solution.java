import java.util.*;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i=0, max=nums.length; i < max; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        return new int[] {map.get(diff), i};
      } else {
        map.put(nums[i], i);
      }
    }

    return new int[]{};
  }

  public static void main(String[] args) {
    int[] nums;
  int target;
    int[] expected;

    Solution solution = new Solution();

    nums = new int[] {2, 7, 11, 15};
  target = 9;
    expected = new int[] {0, 1};
    if (Arrays.equals(solution.twoSum(nums, target), expected)) {
      System.out.printf("result: matched nums: %s, target: %d, result: %s\n", Arrays.toString(nums), target, Arrays.toString(solution.twoSum(nums, target)));
    } else {
      System.out.printf("result: not matched nums: %s, target: %d, result: %s\n", Arrays.toString(nums), target, Arrays.toString(solution.twoSum(nums, target)));
    }

    nums = new int[] {2, 7, 11, 15};
  target = 13;
    expected = new int[] {0, 2};
    if (Arrays.equals(solution.twoSum(nums, target), expected)) {
      System.out.printf("result: matched nums: %s, target: %d, result: %s\n", Arrays.toString(nums), target, Arrays.toString(solution.twoSum(nums, target)));
    } else {
      System.out.printf("result: not matched nums: %s, target: %d, result: %s\n", Arrays.toString(nums), target, Arrays.toString(solution.twoSum(nums, target)));
    }  

    nums = new int[] {11, 7, 2, 15};
  target = 18;
    expected = new int[] {0, 1};
    if (Arrays.equals(solution.twoSum(nums, target), expected)) {
      System.out.printf("result: matched nums: %s, target: %d, result: %s\n", Arrays.toString(nums), target, Arrays.toString(solution.twoSum(nums, target)));
    } else {
      System.out.printf("result: not matched nums: %s, target: %d, result: %s\n", Arrays.toString(nums), target, Arrays.toString(solution.twoSum(nums, target)));
    }

  }
}

