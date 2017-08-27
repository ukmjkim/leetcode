import java.util.*;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] indice = new int[2];
		if (numbers == null || numbers.length < 2) return indice;

		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int v = numbers[left] + numbers[right];
			if (v == target) {
				indice[0] = left + 1;
				indice[1] = right + 1;
				break;
			} else if (v > target) {
				right --;
			} else {
				left ++;
			}
		}

		return indice;
	}

	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;

		Solution solution = new Solution();
		int[] result = solution.twoSum(numbers, target);
		System.out.println(Arrays.toString(result));
	}
}
