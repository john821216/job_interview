package Leetcode;

public class _44 {

	public static void main(String[] args) {
		_44 a = new _44();
		a.execute();
	}

	public void execute() {
		System.out.println(isMatch2("aa", "aa"));
	}

	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i < s.length(); i++) {
			dp[i][0] = false;
		}

		for (int i = 1; i <= p.length(); i++) {
			if (p.charAt(i - 1) == '*') {
				dp[0][i] = true;
			} else {
				break;
			}
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j - 1) != '*') {
					if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
						dp[i][j] = dp[i - 1][j - 1];
					}

					// equals '*'
				} else {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				}
			}
		}
		return dp[s.length()][p.length()];
	}

	public boolean isMatch2(String s, String p) {
		// draw a table for s and p
		boolean[] dp = new boolean[p.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= p.length(); i++) {
			if (p.charAt(i - 1) == '*') {
				dp[i] = true;
			} else {
				break;
			}
		}
		boolean pre = dp[0];
		boolean temp = false;
		for (int i = 1; i <= s.length(); i++) {
            dp[0] = false;
			for (int j = 1; j <= p.length(); j++) {
				temp = false;
				if (p.charAt(j - 1) != '*') {
					if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
						temp = pre;
					}
				} else {
					temp = dp[j - 1] || dp[j];				
				}
				pre = dp[j];
				dp[j] = temp;
			}
            pre = dp[0];
		}
		return dp[p.length()];
	}
}
