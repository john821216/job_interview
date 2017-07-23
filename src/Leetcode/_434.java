package Leetcode;

public class _434 {
	public int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];

		// length 1
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = 1;
		}

		for (int d = 1; d < s.length(); d++) {
			for (int i = 0; i < s.length()-d; i++) {
				int j = i + d;
				if (s.charAt(i) == s.charAt(j)) {
					if (d != 1) {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					} else{
						dp[i][j] = 2;
					}
				} else{
					if (d != 1) {
						dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
					} else{
						dp[i][j] = 1;
					}
				}
			}
		}
		return dp[0][s.length()-1];
	}
}
