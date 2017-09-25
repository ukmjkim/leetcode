import java.util.*;

public class Solution {
  public int findPairs(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;
    
    Map<Integer, Integer> map = new HashMap<>();
    int uniquePairsCount = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        int diff = nums[i] - k;
        if (map.containsKey(diff)) {
          uniquePairsCount++;
        }
        map.put(nums[i], 1);
      } else {
        if (map.get(nums[i]) == 1 && k == 0) {
          uniquePairsCount++;
        }
        map.put(nums[i], map.get(nums[i])+1);
      }
    }
    
    return uniquePairsCount;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = {3, 1, 4, 1, 5};
    int k = 2;
    System.out.println(Arrays.toString(nums));
    System.out.printf("findPairs(%d): %d\n", k, solution.findPairs(nums, k));

    int[] nums2 = {1, 2, 3, 4, 5};
    int k2 = 1;
    System.out.println(Arrays.toString(nums2));
    System.out.printf("findPairs(%d): %d\n", k2, solution.findPairs(nums2, k2));

    int[] nums3 = {1, 3, 1, 5, 4};
    int k3 = 0;
    System.out.println(Arrays.toString(nums3));
    System.out.printf("findPairs(%d): %d\n", k3, solution.findPairs(nums3, k3));

    int[] nums4 = {1, 1, 1, 1, 1};
    int k4 = 0;
    System.out.println(Arrays.toString(nums4));
    System.out.printf("findPairs(%d): %d\n", k4, solution.findPairs(nums4, k4));
  }
}


