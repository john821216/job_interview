package Leetcode;

public class _474 {
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int zeroCount = 0, oneCount = 0;
			for (char c : s.toCharArray()) {
				if (c == '0') {
					zeroCount++;
				} else {
					oneCount++;
				}
			}
			for (int i = m; i >= zeroCount; i--) {
				for (int j = n; j >= oneCount; j--) {
					//at most i's 1 j's 0
					dp[i][j] = Math.max(dp[i][j], dp[i-zeroCount][j-oneCount]+1);
				}
			}
		}
		return dp[m][n];
	}
}
