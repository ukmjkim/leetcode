import java.util.*;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<>();
		for (int i=0; i < nums.length-2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo+1]) lo++;
						while (lo < hi && nums[hi] == nums[hi-1]) hi--;
						lo++; hi--;
					} else if (nums[lo] + nums[hi] < sum) lo++;
					else hi--;
				}
			}
		}	
		return result;
	}

	// Testing Code
	private List<List<Integer>> initializeListofListInteger() {
		// List<? extends List<Integer>> intList = new ArrayList<ArrayList<Integer>>(){{
		List<List<Integer>> intList = new ArrayList<List<Integer>>(){{
			add(new ArrayList<Integer>(){{
					add(1);
					add(2);
					add(3);
				}}
			);
			add(new ArrayList<Integer>(){{
					add(4);
					add(5);
					add(6);
				}}
			);
		}};

		return intList;
	}

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};

		Solution solution = new Solution();
		List<List<Integer>> intList = solution.threeSum(nums);
		System.out.println("Content: " + intList);
	}
}
