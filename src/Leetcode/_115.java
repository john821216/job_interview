package Leetcode;

public class _115 {
	public int numDistinct(String s, String t) {
		//http://blog.csdn.net/abcbc/article/details/8978146
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		dp[0][0] = 1;
		for(int i = 1; i <= s.length() ; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1 ; i <= t.length() ; i++) {
			for(int j = 1 ; j <= s.length() ; j++) {
				dp[i][j] += dp[i][j-1];
				if(s.charAt(j-1) == t.charAt(i-1)) {
					dp[i][j] += dp[i-1][j-1];
				}
			}
		}
		return dp[t.length()][s.length()];
	}
}
