import java.util.*;

public class Solution {
  public int findLHS(int[] nums) {
    Map<Long, Integer> map = new HashMap<>();
    for (long num : nums) {
      map.put(num, map.getOrDefault(num,0) + 1);
    }
    int result = 0;
    for (long key : map.keySet()) {
      if (map.containsKey(key+1)) {
        result = Math.max(result, map.get(key+1) + map.get(key));
      }
    }

    return result;
  }

  // dirty code
  public int findLHS2(int[] nums) {
    Arrays.sort(nums);
    int max = 0;

    // Case 1: 1, 2, 2, 2, 3, 3, 5, 6, 6, 7, 7
    // Case 2: 1, 2, 3, 4
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    map.put(1, 0);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i-1]) {
        map.put(0, map.get(0)+1);
      } else if (nums[i] - nums[i-1] == 1) {
        max = Math.max(max, map.get(0)+map.get(1));
        map.put(1, map.get(0));
        map.put(0, 1);
        //System.out.printf("%d, %d, map(0)=%d, map(1)=%d\n", nums[i], nums[i-1], map.get(0), map.get(1));
      } else {
        max = Math.max(max, map.get(0)+map.get(1));
        map.put(1, 0);
        map.put(0, 1);
      }
    }
    max = Math.max(max, map.get(0)+map.get(1));

    return max;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = {1, 3, 2, 2, 5, 2, 3, 7, 6, 6, 7};
    System.out.printf("findLHS(%s) : %d\n", Arrays.toString(nums), solution.findLHS(nums));

    int[] nums2 = {1, 2, 3, 4};
    System.out.printf("findLHS(%s) : %d\n", Arrays.toString(nums2), solution.findLHS(nums2));

    int[] nums3 = {1, 3, 2, 2, 5, 2, 3, 7};
    System.out.printf("findLHS(%s) : %d\n", Arrays.toString(nums3), solution.findLHS(nums3));
  }
}
