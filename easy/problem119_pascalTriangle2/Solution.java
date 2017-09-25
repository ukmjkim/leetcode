import java.util.*;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return row;
		}

		for (int i = 0; i <= rowIndex; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++) {
				row.set(j, row.get(j) + row.get(j+1));
			}
		}

		return row;
	}

	public static void main(String[] args) {
		int rowIndex = 3;

		Solution solution = new Solution();
		List<Integer> row = solution.getRow(rowIndex);
		System.out.println("Result: " + row);
	}
}
