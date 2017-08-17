package Leetcode;

public class _576 {
	public int findPaths(int m, int n, int N, int i, int j) {
		// http://www.cnblogs.com/grandyang/p/6927921.html
		int [][][] dp = new int[m][n][N + 1];
		for (int k = 1; k <= N; k++) {
			for (int a = 0; a < m; a++) {
				for (int b = 0; b < n; b++) {
					long up = a == 0 ? 1 : dp[a - 1][b][k - 1];
					long down = a == m - 1 ? 1 : dp[a + 1][b][k - 1];
					long left = b == 0 ? 1 : dp[a][b - 1][k - 1];
					long right = b == n - 1 ? 1 : dp[a][b + 1][k - 1];
					dp[a][b][k] = (int)((up + down + left + right) % 1000000007);
				}
			}
		}
		return dp[i][j][N];
	}
}
