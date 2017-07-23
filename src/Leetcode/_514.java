package Leetcode;

public class _514 {
	public int findRotateSteps(String ring, String key) {
		int r = ring.length();
		int k = key.length();

		int[][] dp = new int[k + 1][r];

		for (int i = k - 1; i >= 0; i--) {
			for (int j = 0; j < r; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int a = r - 1; a >= 0; a--) {
					if (key.charAt(i) == ring.charAt(a)) {
						int diff = Math.abs(j - a);
						diff = Math.min(r - diff, diff);
						dp[i][j] = Math.min(dp[i][j], dp[i + 1][a] + diff);
					}
				}
			}
		}
		return dp[0][0] + k;
	}
}
