import java.util.*;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		Arrays.sort(nums);
		helper(result, path, nums, 0);
		return result;
	}

	// [1, 2, 3] - [] [1] [1,2] [1,2,3]   [2] [2,3]  [3]
	private void helper(List<List<Integer>> result, List<Integer> path, int[] nums, int index) {
		result.add(new ArrayList<Integer>(path));
		for (int i = index; i < nums.length; i++) {
			path.add(nums[i]);
			helper(result, path, nums, i+1);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};

		Solution solution = new Solution();
		List<List<Integer>> result = solution.subsets(nums);
		System.out.println("Result: " + result);
	}
}
