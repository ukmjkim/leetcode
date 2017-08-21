import java.util.*;

public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) return false;

		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return (x == rev || x == rev / 10);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.length() == 0) break;

			boolean result = solution.isPalindrome(Integer.parseInt(input));
			System.out.println("Result: " + result);
		}
		sc.close();
	}
}
