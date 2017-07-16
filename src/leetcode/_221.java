package Leetcode;

public class _221 {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int maxCount = 0;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1')
				dp[i][0] = 1;
			maxCount = Math.max(maxCount, dp[i][0]);
		}

		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == '1')
				dp[0][i] = 1;
			maxCount = Math.max(maxCount, dp[0][i]);

		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
					dp[i][j] += 1;
					maxCount = Math.max(maxCount, dp[i][j]);
				}
			}
		}
		return maxCount * maxCount;
	}
}
