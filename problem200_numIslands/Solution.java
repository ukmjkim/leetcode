public class Solution {
	public int numIslands(char[][] grid) {
		int answer = 0;
		for (int row=0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				if (grid[row][column] == '1') {
					dfs(row, column, grid);
					answer++;
				}
			}
		}

		return answer;
	}

	public void dfs(int row, int column, char[][] grid) {
		if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] != '1') {
			return;
		}
		grid[row][column] = '0';
		dfs(row-1, column, grid);
		dfs(row, column-1, grid);
		dfs(row+1, column, grid);
		dfs(row, column+1, grid);
	}

	public static int getRegionSize(char[][] matrix, int row, int column) {
		if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[row].length) {
			return 0;
		}
		if (matrix[row][column] == '0') {
			return 0;
		}
		int size = 1;
		matrix[row][column] = '0';
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = column - 1; c <= column + 1; c++) {
				if (r != row || c != column) {
					size += getRegionSize(matrix, r, c);
				}
			}
		}

		return size;
	}

	public static int getBiggestRegion(char[][] matrix) {
		int maxRegion = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (matrix[row][column] == '1') {
					int size = getRegionSize(matrix, row, column);
					maxRegion = Math.max(size, maxRegion);
				}
			}
		}

		return maxRegion;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
	
		char[][] grid1 = {	{'1', '1', '0', '1', '0'},
							{'1', '1', '0', '1', '0'},
							{'1', '1', '0', '0', '0'},
							{'0', '0', '0', '0', '0'}
						};
	
		char[][] grid2 = {	{'1', '1', '0', '1', '0'},
							{'1', '1', '0', '1', '0'},
							{'1', '1', '0', '0', '0'},
							{'0', '0', '0', '0', '0'}
						};
	
		System.out.println("Number of Islands: " + solution.numIslands(grid1));
		System.out.println("Biggest Region: " + solution.getBiggestRegion(grid2));
	}
}

