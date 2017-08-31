import java.util.*;

public class Solution {
	public void rotate(int[][] matrix) {
		// swap matrix[i][j], maxtrix[j][i]
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// swap matrix[i][j], matrix[i][(matrix.length-1)-j]
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length/2; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][(matrix.length-1)-j];
				matrix[i][(matrix.length-1)-j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		Solution solution = new Solution();
		System.out.println(Arrays.deepToString(matrix));
		solution.rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
}
