import java.util.*;

public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;	
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("Result: " + solution.isValid("(([[]]))"));
	}
}
