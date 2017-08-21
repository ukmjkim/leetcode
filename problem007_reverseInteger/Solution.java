import java.util.*;

public class Solution {
	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) { return 0; }
			result = newResult;
			x = x / 10;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.length() == 0) break;

			int x = Integer.parseInt(input);
			int result = solution.reverse(x);
			System.out.println("Result: " + result);
		}
		sc.close();
	}
}

