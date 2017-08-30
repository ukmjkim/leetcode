import java.util.*;

public class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0, tmp = 1; i < nums.length; i++) {
			result[i] = tmp;
			tmp *= nums[i];
		}
		System.out.println(Arrays.toString(result));	

		for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
			result[i] *= tmp;
System.out.println("Result: " + result[i]);
			tmp *= nums[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};

		Solution solution = new Solution();
		int[] output = solution.productExceptSelf(nums);
		System.out.println(Arrays.toString(output));	
	}
}
