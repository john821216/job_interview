package Leetcode;

public class _375 {
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 1][n + 1];

		for (int len = 2; len <= n; len++) {
			int from = 1;
			int to = from + len - 1;
			while (to <= n) {
				for (int k = from; k <= to; k++) {
					int left = k - 1 >= from ? dp[from][k - 1] : 0;
					int right = k + 1 <= to ? dp[k + 1][to] : 0;
					dp[from][to] = Math.min(dp[from][to],
							k + Math.max(left, right));
				}
				from++;
				to++;
			}

		}
		return dp[1][n];
	}
}
