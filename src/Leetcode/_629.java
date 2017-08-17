package Leetcode;

public class _629 {
	public static void main(String[] args) {
		_629 a = new _629();
		a.execute();
	}

	public void execute() {
		System.out.println(kInversePairs(1000, 1000));
	}

	public int kInversePairs(int n, int k) {
		int MOD = 1000000007;
		long[][] dp = new long[n + 1][k + 1];
		if (k == 0 || k == n * (n - 1) / 2) {
			return 1;
		}

		if (k < 0 || k > n * (n - 1) / 2) {
			return 0;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= Math.min(k, i * (i - 1) / 2); j++) {
				if (j - i >= 0) {
					dp[i][j] = (dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - i]) % MOD;
				} else {
					dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
				}
				
				//A%MOD + B%MOD - C%MOD may <0  so we need do this
				dp[i][j] = (dp[i][j] + MOD) % MOD;
			}
		}
		return (int) dp[n][k];
	}
}
