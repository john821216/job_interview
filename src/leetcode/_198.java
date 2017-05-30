package Leetcode;

public class _198 {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = nums[i];
			if (dp[i] > max) {
				max = dp[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int maxJval = 0;
			for (int j = 0; j < i - 1; j++) {
				if (dp[j] > maxJval) {
					maxJval = dp[j];
				}
			}
			dp[i] = maxJval + dp[i];
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}
}
