import java.util.*;

public class Solution {
	public void setZeros(int[][] matrix) {
		boolean firstrow = false, firstcol = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) firstrow = true;
					if (j == 0) firstcol = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (firstrow) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (firstcol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 0, 4, 5, 6}, {4, 5, 6, 7, 8, 9}, {7, 8, 9, 1, 0, 3}};
		Solution solution = new Solution();
		System.out.println("Result: " + Arrays.deepToString(matrix));
		solution.setZeros(matrix);
		System.out.println("Result: " + Arrays.deepToString(matrix));
	}
}

