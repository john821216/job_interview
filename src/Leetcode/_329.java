package Leetcode;

public class _329 {
	public final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int maxLen = 1;
		int[][] ctch = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int len = dfs(matrix, i, j, ctch);
				maxLen = Math.max(len, maxLen);
			}
		}
		return maxLen;
	}

	public int dfs(int[][] matrix, int m, int n, int[][] ctch) {
		if (ctch[m][n] != 0) {
			return ctch[m][n];
		}
		int maxLen = 1;
		for (int[] d : dir) {
			int nextX = m + d[0];
			int nextY = n + d[1];
			if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && matrix[m][n] > matrix[nextX][nextY]) {
				int len = 1 + dfs(matrix,nextX,nextY,ctch);
				maxLen = Math.max(len, maxLen);
			}
		}
		ctch[m][n] = maxLen;
		return maxLen;
	}
}
