import java.util.*;

public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		if (numRows <= 0) {
			return triangle;
		}

		for (int i = 0; i < numRows; i++) {
			List<Integer> one = new ArrayList<Integer>();
			one.add(1);
			for (int j = 1; j < i; j++) {
				one.add(triangle.get(i-1).get(j) + triangle.get(i-1).get(j-1));
			}
			if (i > 0) {
				one.add(1);
			}
			triangle.add(one);
		}

		return triangle;
	}

	public static void main(String[] args) {
		int numRows = 5;

		Solution solution = new Solution();
		List<List<Integer>> triangle = solution.generate(numRows);
		for (List<Integer> list : triangle) {
			System.out.println("Result: " + list);
		}
	}
}
