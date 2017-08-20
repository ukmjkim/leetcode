import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i=0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hash.containsKey(diff)) {
                return new int[]{hash.get(diff), i};
            }
            hash.put(nums[i], i);
        }
        
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println("Solution Testing....");
        int[] nums = {2, 7, 11, 15};

        int[] answer = new Solution().twoSum(nums, 9);
        System.out.println("First Number: " + answer[0] + ", Second Number: " + answer[1]);
    }
}
