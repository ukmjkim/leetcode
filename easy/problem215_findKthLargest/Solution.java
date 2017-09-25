import java.util.*;

public class Solution {
	public int findKthLargest(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		Arrays.sort(nums);
		int kthValue = nums[nums.length-k];
		return kthValue;	
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;

		Solution solution = new Solution();
		int result = solution.findKthLargest(nums, k);
		System.out.println("Kth Largest Number is " + result);
	}
}
