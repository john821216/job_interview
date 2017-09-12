package Leetcode;

public class _562 {
	public static void main(String[] args) {
		_562 a = new _562();
		a.execute();
	}

	public void execute() {
		longestLine(new int[][] { { 1, 1, 1, 1 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 } });
	}

	public int longestLine(int[][] M) {
		if (M.length == 0) {
			return 0;
		}
		int m = M.length;
		int n = M[0].length;
		int[][][] dp = new int[m][n][4];
		int max = 0;
		if (M[0][0] == 1) {
			dp[0][0][0] = 1;
			dp[0][0][1] = 1;
			dp[0][0][2] = 1;
			dp[0][0][3] = 1;
			max = 1;
		}
		for (int i = 1; i < m; i++) {
			if (M[i][0] == 1) {
				dp[i][0][0] = dp[i - 1][0][0] + 1;
				dp[i][0][1] = 1;
				dp[i][0][2] = 1;
				max = Math.max(dp[i][0][3], Math.max(max, Math.max(dp[i][0][0], Math.max(dp[i][0][1], dp[i][0][2]))));
			}

			if (M[i][n - 1] == 1) {
				dp[i][n - 1][3] = 1;
				max = Math.max(max, dp[i][n - 1][3]);
			}
		}

		for (int i = 1; i < n; i++) {
			if (M[0][i] == 1) {
				dp[0][i][1] = dp[0][i - 1][1] + 1;
				dp[0][i][0] = 1;
				dp[0][i][2] = 1;
				dp[0][i][3] = 1;
				max = Math.max(dp[0][i][3], Math.max(max, Math.max(dp[0][i][0], Math.max(dp[0][i][1], dp[0][i][2]))));
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (M[i][j] == 1) {
					dp[i][j][0] = dp[i - 1][j][0] + 1;
					dp[i][j][1] = dp[i][j - 1][1] + 1;
					dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
					max = Math.max(max, Math.max(dp[i][j][0], Math.max(dp[i][j][1], dp[i][j][2])));
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = n - 2; j >= 0; j--) {
				if (M[i][j] == 1) {
					dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
					max = Math.max(max, dp[i][j][3]);
				}
			}
		}
		return max;
	}
}
