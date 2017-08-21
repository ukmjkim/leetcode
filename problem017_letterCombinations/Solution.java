import java.util.*;

public class Solution {
	public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			System.out.println("digits["+i+"]: " + "ans.peek(): " + ans.peek());
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
			System.out.println("digits["+i+"]: " + digits.charAt(i) + " ==> " + ans);
		}
		return ans;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> result = solution.letterCombinations("234");
		System.out.println("Result: " + result);
	}
}

