import java.util.*;

public class Solution {
	public int maxProfit(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		System.out.print("Input: ");
		for (int i = 1; i < prices.length; i++) {
			System.out.print(" " + (maxCur + prices[i] - prices[i-1]));
			maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		// int[] prices = {1, 7, 4, 11, 13};
		int[] prices = {0, 6, -3, 7};

		Solution solution = new Solution();
		int maxProfit = solution.maxProfit(prices);
		System.out.println("Result: " + maxProfit);	
	}
}
