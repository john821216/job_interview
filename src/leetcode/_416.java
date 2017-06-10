package Leetcode;

public class _416 {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}

		if (sum % 2 == 1) {
			return false;
		}

		sum /= 2;
		boolean[][] dp = new boolean[nums.length + 1][sum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					if (j == 0) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				} else {
					// dont pick i-1
					dp[i][j] |= dp[i - 1][j];

					// pick i-1
					if (j >= nums[i - 1]) {
						dp[i][j] |= dp[i - 1][j - nums[i - 1]];
					}
				}
			}
		}
		return dp[nums.length][sum];
	}

	public boolean canPartition2(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}

		if (sum % 2 == 1) {
			return false;
		}
		sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true; // others are false;
		for (int i = 1; i < nums.length; i++) {
			for (int j = sum; j >= 0; j--) {
				if (j >= nums[i - 1]) {
					dp[j] = dp[j] || dp[j - nums[i - 1]];
				}

			}
		}
		return dp[sum];
	}
}
