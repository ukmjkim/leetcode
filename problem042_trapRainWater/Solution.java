public class Solution {
	public int trap(int[] height) {
		int a = 0;
		int b = height.length-1;
		int max = 0;
		int leftmax = 0;
		int rightmax = 0;

		while (a <= b) {
			leftmax = Math.max(leftmax, height[a]);
			rightmax = Math.max(rightmax, height[b]);

			if (leftmax < rightmax) {
				max += (leftmax - height[a]);
				a ++;
			} else {
				max += (rightmax - height[b]);
				b --;
			}
		}
	
		return max;
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		Solution solution = new Solution();
		int result = solution.trap(nums);
		System.out.println("Max account of water: " + result);
	}
}
