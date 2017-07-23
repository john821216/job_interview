package Leetcode;

public class _132 {
	public int minCut(String s) {
		boolean[][] pal = new boolean[s.length()][s.length()];
		int[] dp = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (s.charAt(i) == s.charAt(j) && (i - j < 2 || pal[j + 1][i - 1])) {
					pal[j][i] = true;
					if (j == 0) {
						min = 0;
					} else {
						min = Math.min(min, dp[j - 1] + 1);
					}
				}
			}
			dp[i] = min;
		}
		return dp[s.length() - 1];
	}
}
