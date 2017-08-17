package Leetcode;

public class _639 {
	public static void main(String[] args) {
		_639 a = new _639();
		a.execute();
	}

	public void execute() {
		System.out.println(numDecodings("1*"));
	}

	public int numDecodings(String s) {
		int M = 1000000007;
		long[] dp = new long[s.length() + 1];
		dp[0] = 1;
		if (s.charAt(0) == '*') {
			dp[1] = 9;
		} else if (s.charAt(0) == '0') {
			dp[1] = 0;
		} else {
			dp[1] = 1;
		}
		for (int i = 2; i <= s.length(); i++) {
			// length 1;
			if (s.charAt(i - 1) == '*') {
				dp[i] = (dp[i] + 9 * dp[i - 1]) % M;
			} else {
				if (Integer.parseInt(s.substring(i - 1, i)) > 0 && Integer.parseInt(s.substring(i - 1, i)) <= 9) {
					dp[i] = (dp[i] + dp[i - 1]) % M;
				}
			}

			// length 2
			if (s.charAt(i - 1) == '*') {
				if (s.charAt(i - 2) == '1') {
					dp[i] = (dp[i] + 9 * dp[i - 2]) % M;
				} else if (s.charAt(i - 2) == '2') {
					dp[i] = (dp[i] + 6 * dp[i - 2]) % M;
				} else if (s.charAt(i - 2) == '*') {
					dp[i] = (dp[i] + 15 * dp[i - 2]) % M;
				}
			} else if (s.charAt(i - 1) != '*') {
				if (s.charAt(i - 2) != '*') {
					if (Integer.parseInt(s.substring(i - 2, i)) >= 10
							&& Integer.parseInt(s.substring(i - 2, i)) <= 26) {
						dp[i] = (dp[i] + dp[i - 2]) % M;
					}
				} else {
					if (s.charAt(i - 1) <= '6') {
						dp[i] = (dp[i] + 2 * dp[i - 2]) % M;
					} else {
						dp[i] = (dp[i] + dp[i - 2]) % M;
					}
				}
			}
		}
		return (int)dp[s.length()];
	}
}
