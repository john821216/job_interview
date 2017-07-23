package Leetcode;

public class _304 {
	private int[][] count;

	public _304(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		count = new int[m][n];
		count[0][0] = matrix[0][0];
		for (int i = 1; i < n; i++) {
			count[0][i] += count[0][i - 1];
		}

		for (int i = 1; i < m; i++) {
			count[i][0] += count[i - 1][0];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				count[i][j] = count[i - 1][j] + count[i][j - 1]
						- count[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		sum += count[row2][col2];
		if (row1 - 1 >= 0) {
			sum -= count[row1 - 1][col2];
		}

		if (col1 - 1 >= 0) {
			sum -= count[row2][col1 - 1];
		}

		if (row1 - 1 >= 0 && col1 - 1 >= 0) {
			sum += count[row1 - 1][col1 - 1];
		}
		return sum;
	}
}
