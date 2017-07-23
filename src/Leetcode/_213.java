package Leetcode;

public class _213 {
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[][] dp = new int[nums.length + 1][2];
		for (int i = 1; i <= nums.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = nums[i - 1] + dp[i - 1][0];
		}

		int curMax = dp[nums.length][0];
		for (int i = 1; i <= nums.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = i == 1 ? 0 : nums[i - 1] + dp[i - 1][0];
		}
		return Math.max(curMax,
				Math.max(dp[nums.length][0], dp[nums.length][1]));
	}
}
