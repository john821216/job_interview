package Leetcode;

public class _552 {
	public int checkRecord(int n) {
		final int mod = 1000000007;
		int[][][] dp = new int[n + 1][2][3];
		dp[1] = new int[][] { { 1, 1, 0 }, { 1, 0, 0 } };

		for (int i = 2; i <= n; i++) {
			dp[i][0][0] = sum(dp, i - 1, 0);
			dp[i][0][1] = dp[i - 1][0][0];
			dp[i][0][2] = dp[i - 1][0][1];
			dp[i][1][0] = (sum(dp, i - 1, 0) + sum(dp, i - 1, 1)) % mod;
			dp[i][1][1] = dp[i - 1][1][0];
			dp[i][1][2] = dp[i - 1][1][1];
		}
		return (sum(dp, n, 0) + sum(dp, n, 1)) % mod;
	}

	public int sum(int[][][] dp, int i, int a) {
		final int mod = 1000000007;
		int sum = 0;
		int[] target = dp[i][a];
		for (int j = 0; j < target.length; j++) {
			sum += dp[i][a][j];
			sum %= mod;
		}
		return sum;
	}
}
