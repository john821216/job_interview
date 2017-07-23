package Leetcode;

public class _546 {
	public int removeBoxes(int[] boxes) {
		int n = boxes.length;
		int[][][] dp = new int[n][n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][i][j] = (j + 1) * (j + 1);
			}
		}

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i < n; i++) {
				if (i + len - 1 >= n) {
					break;
				}

				int j = i + len - 1;
				// k
				for (int a = 0; a <= i; a++) {
					int max = Integer.MIN_VALUE;
					if (i + 1 < n) {
						max = (a + 1) * (a + 1) + dp[i + 1][j][0];
					}

					for (int m = i + 1; m <= j; m++) {
						if (boxes[m] == boxes[i]) {
							if (i + 1 < n) {
								max = Math.max(max, dp[i + 1][m - 1][0]
										+ dp[m][j][a + 1]);
							}
						}
					}
					if (max != Integer.MIN_VALUE)
						dp[i][j][a] = max;
				}
			}
		}
		return dp[0][n - 1][0];
	}
}
