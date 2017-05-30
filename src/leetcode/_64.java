package Leetcode;

public class _64 {
	public int minPathSum(int[][] grid) {
		int[][] arr = new int[grid.length][grid[0].length];
		arr[0][0] = grid[0][0];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j > 0) {
					arr[i][j] += arr[i][j - 1] + grid[i][j];
				}
				if (i != 0 && j == 0) {
					arr[i][j] += arr[i - 1][j] + grid[i][j];
				}
				if (i > 0 && j > 0) {
					arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1])
							+ grid[i][j];
				}
			}
		}
		return arr[grid.length - 1][grid[0].length - 1];
	}
}
