import java.util.*;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numMap.containsKey(diff)) {
                indices[0] = numMap.get(diff);
                indices[1] = i;
                return indices;
            }
            numMap.put(nums[i], i);
        }
        return indices;
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

