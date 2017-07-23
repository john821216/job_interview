package Leetcode;

public class _97 {
	public static void main(String[] args) {
		_97 a = new _97();
		a.execute();
	}

	public void execute() {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		dp[0][0] = true;
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 && j != 0) {
					dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
				} else if (i != 0 && j== 0) {
					dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
				} else if(i != 0 && j != 0){
					dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
							|| dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
}
